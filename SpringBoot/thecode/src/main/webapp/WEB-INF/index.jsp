<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secret Code</title>
</head>
<body>
	<c:out value="${error}"></c:out>
	<h2>What is the code?</h2>
	<form method="POST" action="/validateCode">
		<input type="text" name="code">
		<button>Submit</button>
	</form>
</body>
</html>