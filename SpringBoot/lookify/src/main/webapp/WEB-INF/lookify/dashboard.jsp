<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify!</title>
</head>
<body>
	<div style="display: flex; margin: 5px;">
		<a href="/songs/new">Add New</a>
		<a href="/search/topTen">Top Songs</a>
		<form action="/search">
			<input type="text" name="query">
			<button>Search Artists</button>
		</form>
	</div>
	
	<table>
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Rating</th>	       
	            <th>Action</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${songs}" var="song">
	        <tr>
	            <td><a href="/songs/<c:out value="${song.id}"/>"><c:out value="${song.title}"/></a></td>
	            <td><c:out value="${song.rating}"/></td>
	            <td>
	            	
	            	<form action="/songs/${song.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
					</form>
	            </td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
</body>
</html>