<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/addNinja" method="POST" modelAttribute="newNinja">
	    <p>
	       	<form:label path="dojo">Dojo:</form:label>
	        <form:errors path="dojo"/>
	        <form:select path="dojo">
        	     <c:forEach items="${dojos}" var="dojo">
	            	<option value="${dojo.id}">${dojo.name}</option>
	        	</c:forEach>
        	</form:select>
	    <p>
	        <form:label path="firstName">First Name:</form:label>
	        <form:errors path="firstName"/>
	        <form:input type="text" path="firstName"/>
	    </p>
   	    <p>
	        <form:label path="lastName">Last Name:</form:label>
	        <form:errors path="lastName"/>
	        <form:input type="text" path="lastName"/>
	    </p>
   	    <p>
	        <form:label path="age">Age:</form:label>
	        <form:errors path="age"/>
	        <form:input type="number" path="age"/>
	    </p>
	    <button>Create</button>
	</form:form>
</body>
</html>