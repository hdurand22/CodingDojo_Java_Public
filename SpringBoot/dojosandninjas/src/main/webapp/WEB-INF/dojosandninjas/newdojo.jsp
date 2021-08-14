<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action = "/dojos/addDojo" method="POST" modelAttribute="newDojo">
	    <p>
	       	<form:label path="name">Name:</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
    	</p>
    	<button>Create</button>
	</form:form>
</body>
</html>