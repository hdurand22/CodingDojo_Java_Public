<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<h4>Title: <c:out value="${song.title}"/></h4>
	<h4>Artist: <c:out value="${song.artist}"/></h4>
	<h4>Rating: <c:out value="${song.rating}"/></h4>

	<form action="/songs/${song.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
	</form>
</body>
</html>