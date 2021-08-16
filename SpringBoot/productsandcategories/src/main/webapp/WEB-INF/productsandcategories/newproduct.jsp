<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
	<form:form action="/products/addProduct" method="POST" modelAttribute="newProduct">
	    <p>
	       	<form:label path="name">Name:</form:label>
	        <form:errors path="name"/>
	        <form:input type="text" path="name"/>

	    <p>
	        <form:label path="description">Description:</form:label>
	        <form:errors path="description"/>
	        <form:textarea path="description"/>
	    </p>
   	    <p>
	        <form:label path="price">Price:</form:label>
	        <form:errors path="price"/>
	        <form:input type="number" min="0.01" step="0.01" path="price"/>
	    </p>
	    <button>Create</button>
	</form:form>
</body>
</html>