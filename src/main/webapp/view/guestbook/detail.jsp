<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<style type="text/css">
	a { text-decoration: none;}
	table{width: 600px; border-collapse:collapse; text-align: center;}
	table,th,td{border: 1px solid black; padding: 3px}
	div{width: 600px; margin:auto; text-align: center;}
</style>
<script type="text/javascript">
	function update_go(f) {
		f.action = "${pageContext.request.contextPath}/GuestBook?cmd=update";
		f.submit();
	}
	function delete_go(f) {
		f.action = "${pageContext.request.contextPath}/GuestBook?cmd=delete";
		f.submit();
	}
</script>
</head>
<body>
<div>
<h2>방명록 내용보기</h2>
<hr>
<p>[<a href="${pageContext.request.contextPath}/GuestBook?cmd=list">목록으로 이동</a>]</p>
<form method="post">
	<table>
		<tr align="center">
			<td bgcolor="#99ccff">작성자</td>
			<td>${gvo.name}</td>
		</tr>
		<tr align="center">
			<td bgcolor="#99ccff">제목</td>
			<td>${gvo.subject}</td>
		</tr>
		<tr align="center">
			<td bgcolor="#99ccff">이메일</td>
			<td>${gvo.email}</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<textarea rows="10" cols="60" name="content" required>${gvo.content}</textarea>
			</td>
		</tr>
		<tfoot>
		<tr align="center">
			<td colspan="2">
				<input type="hidden" name="idx" value="${gvo.idx}">
				<input type="hidden" name="pwd" value="${gvo.pwd}">
				<input type="button" value="수정" onclick="update_go(this.form)">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="삭제" onclick="delete_go(this.form)">
			</td>
		</tr>
		</tfoot>
	</table>
</form>
</div>
</body>
</html>