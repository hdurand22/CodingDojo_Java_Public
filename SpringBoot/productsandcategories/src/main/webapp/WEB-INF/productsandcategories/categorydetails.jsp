<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Details</title>
</head>
<body>
	<c:choose>
		<c:when test="${category.name != null}">
			<div>
				<h1>
					<c:out value="${category.name}" />
				</h1>
				<div style="display: flex;">
					<div style="margin: 10px;">
						<h2>Products:</h2>
						<ul>
							<c:forEach items="${category.products}" var="catProd">
								<li><c:out value="${catProd.name}" /></li>
							</c:forEach>
						</ul>
					</div>
					<div style="margin: 10px;">
						<h2>Add Category:</h2>
						<form action="/categories/${category.id}" method="POST">
							<p>
								<select name="productId">
									<c:forEach items="${products}" var="p">
										<option value="${p.id}"><c:out value="${p.name}" /></option>
									</c:forEach>
								</select>
								<button>Add</button>
							</p>
						</form>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<h2>This category doesn't exist!</h2>
			<a href="/categories/new">Add it here</a>
		</c:otherwise>
	</c:choose>
</body>
</html>