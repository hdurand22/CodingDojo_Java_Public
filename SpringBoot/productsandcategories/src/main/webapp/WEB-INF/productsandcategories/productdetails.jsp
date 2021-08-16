<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
</head>
<body>
	<c:choose>
		<c:when test="${product.name != null}">
			<div>
				<h1>
					<c:out value="${product.name}" />
				</h1>
				<div style="display: flex;">
					<div style="margin: 10px;">
						<h2>Categories:</h2>
						<ul>
							<c:forEach items="${product.categories}" var="prodCat">
								<li><c:out value="${prodCat.name}" /></li>
							</c:forEach>
						</ul>
					</div>
					<div style="margin: 10px;">
						<h2>Add Category:</h2>
						<form action="/products/${product.id}" method="POST">
							<p>
								<select name="categoryId">
									<c:forEach items="${categories}" var="c">
										<option value="${c.id}"><c:out value="${c.name}" /></option>
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
			<h2>This product doesn't exist!</h2>
			<a href="/products/new">Add it here</a>
		</c:otherwise>
	</c:choose>
</body>
</html>