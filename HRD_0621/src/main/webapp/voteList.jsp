<%@page import="dto.DTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<DTO> list = (ArrayList<DTO>)request.getAttribute("LIST"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%@ include file="header.jsp" %>
	<section>
		<h2>후보 조회</h2>
		<div class="table">
			<table>
				<tr>
					<th>성명</th>
					<th>생년월일</th>
					<th>나이</th>
					<th>성별</th>
					<th>후보번호</th>
					<th>투표시간</th>
					<th>유권자확인</th>
				</tr>
				<% for(DTO dto : list) { %>
				<tr>
					<td>
						<%= dto.getM_name() %>
					</td>
					<td>
						<%= dto.getBirthDate() %>
					</td>
					<td>
						만 <%= dto.getAge() %>세
					</td>
					<td>
						<%= dto.getSex() %>
					</td>
					<td>
						<%= dto.getM_no() %>
					</td>
					<td>
						<%= dto.getTime() %>
					</td>
					<td>
						<%= dto.getVoter() %>
					</td>
				</tr>
				<%} %>
			</table>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>