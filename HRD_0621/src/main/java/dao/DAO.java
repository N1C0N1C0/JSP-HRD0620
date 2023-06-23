package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import dto.DTO;

public class DAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/XE",
				"hr",
				"hr"
				);
		return con;
	}
	
	public ArrayList<DTO> cadidate() {
		String select = "select t1.m_no, t2.m_name, count(t1.m_no) "
				+ "from tbl_vote_202005 t1, tbl_member_202005 t2 "
				+ "where t1.m_no=t2.m_no "
				+ "group by t1.m_no, t2.m_name "
				+ "order by count(t1.m_no) desc";
		ArrayList<DTO> list = new ArrayList<>();
		try {
			con = getConnection();
			ps = con.prepareStatement(select);
			rs = ps.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setM_no(rs.getString(1));
				dto.setM_name(rs.getString(2));
				dto.setTotal(rs.getInt(3));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			} catch (Exception e) {}
		}
		return list;
	}
	
	public ArrayList<DTO> voteList() {
		String select = "select v_name, v_jumin, m_no, v_time, v_confirm from tbl_vote_202005";
		ArrayList<DTO> list = new ArrayList<>();
		try {
			con = getConnection();
			ps = con.prepareStatement(select);
			rs = ps.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setM_name(rs.getString(1));
				String jumin = rs.getString(2);
				dto.setBirthDate(
						"19"+jumin.substring(0,2)+"년"+jumin.substring(2,4)+"월"+jumin.substring(4,6)+"일생"
				);
				Calendar cd = Calendar.getInstance();
				int cdY = cd.get(Calendar.YEAR);
				int cdM = cd.get(Calendar.MONTH)+1;
				int cdD = cd.get(Calendar.DAY_OF_MONTH);
				int ageYear = cdY - (1900+Integer.parseInt(jumin.substring(0,2)));
				int ageMonth = Integer.parseInt(jumin.substring(2,4));
				int ageDay = Integer.parseInt(jumin.substring(4,6));
				if(cdM*100 + cdD < ageMonth * 100 + ageDay ) ageYear--;
				dto.setAge(ageYear);
				if(jumin.substring(6,7).equals("1")) {
					dto.setSex("남");
				}else if (jumin.substring(6,7).equals("2")) {
					dto.setSex("여");
				}
				dto.setM_no(rs.getString(3));
				StringBuffer sb = new StringBuffer();
				sb.append(rs.getString(4));
				sb.insert(2, ":");
				dto.setTime(sb.toString());
				if(rs.getString(5).equals("Y")) {
					dto.setVoter("확인");
				}else if (rs.getString(5).equals("N")) {
					dto.setVoter("미확인");
				}
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			} catch (Exception e) {}
		}
		return list;
	}
	
	public int vote(DTO dto) {
		String insert = "insert into tbl_vote_202005 "
				+ "values(?,?,?,?,?,?)";
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(insert);
			ps.setString(1, dto.getM_jumin());
			ps.setString(2, dto.getM_name());
			ps.setString(3, dto.getM_no());
			ps.setString(4, dto.getTime());
			ps.setString(5, dto.getArea());
			ps.setString(6, dto.getVoter());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}finally {
			try {
				if(con!=null) con.close();
				if(ps!=null) ps.close();
			} catch (Exception e) {}
		}
		return result;
	}
	
	public ArrayList<DTO> listJoin() {
		ArrayList<DTO> list = new ArrayList<>();
		String select = "select t1.m_no, t1.m_name, t2.p_name, t1.p_school, t1.m_jumin, "
				+ "t1.m_city, t2.p_tel1, t2.p_tel2, t2.p_tel3 "
				+ "from tbl_member_202005 t1, tbl_party_202005 t2 "
				+ "where t1.p_code = t2.p_code";
		try {
			con = getConnection();
			ps = con.prepareStatement(select);
			rs = ps.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setM_no(rs.getString(1));
				dto.setM_name(rs.getString(2));
				dto.setP_code(rs.getString(3));
				String school = rs.getString(4);
				switch(school) {
					case "1" : dto.setP_school("고졸");  break;
					case "2" : dto.setP_school("학사");  break;
					case "3" : dto.setP_school("석사");  break;
					case "4" : dto.setP_school("박사");  break;
				}
				StringBuffer sb = new StringBuffer();
				sb.append(rs.getString(5));
				sb.insert(6, "-");
				dto.setM_jumin(sb.toString());
				dto.setM_city(rs.getString(6));
				String phone = rs.getString(7) + "-" + rs.getString(8) + "-" + rs.getString(9);
				dto.setP_tel(phone);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			} catch (Exception e) {}
		}
		return list;		
	}
}
