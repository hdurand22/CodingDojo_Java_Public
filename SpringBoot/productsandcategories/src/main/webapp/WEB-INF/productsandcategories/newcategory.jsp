<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
</head>
<body>
	<form:form action="/categories/addCategory" method="POST" modelAttribute="newCategory">
		<p>
	       	<form:label path="name">Name:</form:label>
	        <form:errors path="name"/>
	        <form:input type="text" path="name"/>
    	</p>
    	<button>Create</button>
	</form:form>
</body>
</html>