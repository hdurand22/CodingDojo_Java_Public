<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
	<form:form action="/addLicense" method="POST" modelAttribute="newLicense">
	    <p>
	       	<form:label path="person">Person:</form:label>
	        <form:errors path="person"/>
	        <form:select path="person">
        	     <c:forEach items="${people}" var="person">
	            	<option value="${person.id}">${person.firstName} ${person.lastName}</option>
	        	</c:forEach>
        	</form:select>
	    </p>
	    <p>
	        <form:label path="state">State:</form:label>
	        <form:errors path="state"/>
	        <form:input type="text" path="state"/>
	    </p>
	    <p>
	        <form:label path="expirationDate">Expiration Date:</form:label>
	        <form:errors path="expirationDate"/>
	        <form:input type="date" path="expirationDate"/>
	    </p>
	    <button>Create</button>
	</form:form>
</body>
</html>