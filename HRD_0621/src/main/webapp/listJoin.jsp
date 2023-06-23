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
					<th>후보 번호</th>
					<th>성명</th>
					<th>소속정당</th>
					<th>학력</th>
					<th>주민번호</th>
					<th>지역구</th>
					<th>대표전화</th>
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
						<%= dto.getP_code() %>
					</td>
					<td>
						<%= dto.getP_school() %>
					</td>
					<td>
						<%= dto.getM_jumin() %>
					</td>
					<td>
						<%= dto.getM_city() %>
					</td>
					<td>
						<%= dto.getP_tel() %>
					</td>
				</tr>
				<%} %>
			</table>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>