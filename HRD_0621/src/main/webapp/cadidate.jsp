<%@page import="dto.DTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<DTO> list = (ArrayList<DTO>)request.getAttribute("LIST"); %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<section>
		<h2>후보 조회</h2>
		<div class="table">
			<table>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>총 투표건수</th>
				</tr>
				<% for(DTO dto : list) { %>
				<tr>
					<td>
						<%= dto.getM_no() %>
					</td>
					<td>
						<%= dto.getM_name() %>
					</td>
					<td>
						<%= dto.getTotal() %>
					</td>
				</tr>
				<%} %>
			</table>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>