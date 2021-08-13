<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
</head>
<body>
	<h1><c:out value="${person.getFirstName()} ${person.getLastName()}"/></h1>
	<h4>License Number: <c:out value="${license.number}"/></h4>
	<h4>State: <c:out value="${license.state}"/></h4>
	<h4>Expiration Date: <c:out value="${license.expirationDate}"/></h4>
</body>
</html>