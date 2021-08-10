<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Survey Results</title>
</head>
<body>
	<div style="display: flex; flex-direction: column;">
		<table>
			<tr>
				<td>Name: </td>
				<td><c:out value="${name}"></c:out></td>
			</tr>
			<tr>
				<td>Dojo Location: </td>
				<td><c:out value="${dojoLocation}"></c:out></td>
			</tr>
			<tr>
				<td>Favorite Language: </td>
				<td><c:out value="${favoriteLanguage}"></c:out></td>
			</tr>
			<tr>
				<td>Comment: </td>
				<td><c:out value="${comment}"></c:out></td>
			</tr>
			
		</table>
	</div>
</body>
</html>