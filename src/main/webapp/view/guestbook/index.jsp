<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>방명록</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/GuestBook" method="post">
			<input type="hidden" name="cmd" value="list">
			<input type="submit" value="방명록">
		</form>
	</body>
</html>