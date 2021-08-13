<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<h2>Top Ten Songs:</h2>
	<table>
		<c:forEach items="${songs}" var="song">
			<tr>
				<td><c:out value="${song.rating}"/></td>
				<td> - </td>
				<td><a href="/songs/<c:out value="${song.id}"/>"><c:out value="${song.title}"/></a></td>
				<td> - </td>
				<td><c:out value="${song.artist}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>