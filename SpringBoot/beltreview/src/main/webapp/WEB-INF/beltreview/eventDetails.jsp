<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${event.name}"/></title>
</head>
<body>
	<h2>
		<c:out value="${event.name}"/>
	</h2>
	<p>Host: <c:out value="${event.host.firstName} ${event.host.lastName}"/></p>
	<p>Date: <c:out value="${event.eventDate}"/></p>
	<p>Location: <c:out value="${event.eventLocation} ${event.eventState}"/></p>
	<p>People who are attending this event: <c:out value="${event.attendees.size()}"/></p>
	<br/>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${attendees}" var="a">
				<tr>
					<td><c:out value="${a.firstName} ${a.lastName}"/></td>
					<td><c:out value="${a.location}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>