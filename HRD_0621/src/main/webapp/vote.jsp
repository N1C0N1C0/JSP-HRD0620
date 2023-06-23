<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%@ include file="header.jsp" %>
	<section>
		<h2>투표하기</h2>
		<div class="table">
		<form action="vote.do" method="post" name="frm">
			<table>
				<tr>
					<th>주민번호</th>
					<td>
						<input type="text" id="jumin" name="JUMIN" size="30px;">예 : 8906153154726
					</td>
				</tr>
				<tr>
					<th>성명</th>
					<td>
						<input type="text" name="NAME">
					</td>
				</tr>
				<tr>
					<th>투표 번호</th>
					<td>
						<select name="VNUM">
							<option value=""></option>
							<option value="1">김후보</option>
							<option value="2">이후보</option>
							<option value="3">박후보</option>
							<option value="4">조후보</option>
							<option value="5">최후보</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>투표 시간</th>
					<td>
						<input type="text" name="TIME">
					</td>
				</tr>
				<tr>
					<th>투표 장소</th>
					<td>
						<input type="text" name="AREA">
					</td>
				</tr>
				<tr>
					<th>유권자 확인</th>
					<td class="radio">
						<label><input type="radio" name="VOTER" value="Y">확인</label>
						<label><input type="radio" name="VOTER" value="N">미확인</label>
					</td>
				</tr>
				<tr>
					<td colspan="2"> 
						<button class="btn" type="submit" onclick="return check()">투표하기</button>
						<button class="btn" type="reset" onclick="rollback()">다시하기</button>
					</td>
				</tr>
			</table>
			</form>
		</div>
	</section>
	<%@ include file="footer.jsp" %>	
</body>
</html>