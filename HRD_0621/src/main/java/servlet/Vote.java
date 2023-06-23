package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dto.DTO;

/**
 * Servlet implementation class Vote
 */
@WebServlet("/vote.do")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String jumin = request.getParameter("JUMIN");
		String name = request.getParameter("NAME");
		String no = request.getParameter("VNUM");
		String time = request.getParameter("TIME");
		String area = request.getParameter("AREA");
		String con = request.getParameter("VOTER");
		DTO dto = new DTO();
		dto.setM_jumin(jumin);
		dto.setM_name(name);
		dto.setM_no(no);
		dto.setTime(time);
		dto.setArea(area);
		dto.setVoter(con);
		DAO dao = new DAO();
		int result = dao.vote(dto);
		request.setAttribute("RE", result);
		request.getRequestDispatcher("voteResult.jsp").forward(request, response);
		
	}

}
