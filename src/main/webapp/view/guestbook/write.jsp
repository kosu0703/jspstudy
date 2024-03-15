<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 쓰기</title>
<style type="text/css">
	a { text-decoration: none;}
	table{width: 600px; border-collapse:collapse; text-align: center;}
	table,th,td{border: 1px solid black; padding: 3px}
	div{width: 600px; margin:auto; text-align: center;}
</style>
</head>
<body>
<div>
<h2>방명록 : 작성화면</h2>
<hr>
<p>[<a href="${pageContext.request.contextPath}/GuestBook?cmd=list">목록으로 이동</a>]</p>
<form action="${pageContext.request.contextPath}/GuestBook" method="post">
	<table>
		<tr align="center">
			<td bgcolor="#99ccff">작성자</td>
			<td><input type="text" name="name" size ="20" required></td>
		</tr>
		<tr align="center">
			<td bgcolor="#99ccff">제목</td>
			<td><input type="text" name="subject" size ="20" required></td>
		</tr>
		<tr align="center">
			<td bgcolor="#99ccff">이메일</td>
			<td><input type="text" name="email" size ="20" required></td>
		</tr>
		<tr align="center">
			<td bgcolor="#99ccff">비밀번호</td>
			<td><input type="text" name="pwd" size ="20" required></td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<textarea rows="10" cols="60" name="content" required></textarea>
			</td>
		</tr>
		<tfoot>
		<tr align="center">
			<td colspan="2">
				<input type="hidden" name="cmd" value="write_ok">
				<input type="submit" value="저장">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">
			</td>
		</tr>
		</tfoot>
	</table>
</form>
</div>	
</body>
</html>