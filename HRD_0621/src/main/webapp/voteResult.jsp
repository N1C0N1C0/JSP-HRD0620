<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% int result = (int)request.getAttribute("RE"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%if(result==1){ %>
		<script type="text/javascript">
			alert('등록이 완료')
			location.href = "index.jsp";
		</script>
	<%}else{ %>
		<script type="text/javascript">
			alert('등록이 실패')
			location.href = "vote.jsp";
		</script>
	<%} %>
</body>
</html>