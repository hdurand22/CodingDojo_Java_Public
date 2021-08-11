<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
</head>
<body>
	<h2>Your Gold: <c:out value="${totalGold}"></c:out></h2>
		<div style="display: flex; margin: 10px;">
			<div style="border: 1px solid; margin: 5px; padding: 5px;">
				<h3>Farm</h3>
				<p>(earns 10-20 gold)</p>
				<form method="POST" action="/updateGold">
					<input type="hidden" name="location" value="farm">
					<button>Find Gold!</button>
				</form>
			</div>
			<div style="border: 1px solid; margin: 5px; padding: 5px;">
				<h3>Cave</h3>
				<p>(earns 5-10 gold)</p>
				<form method="POST" action="/updateGold">
					<input type="hidden" name="location" value="cave">
					<button>Find Gold!</button>
				</form>
			</div>
			<div style="border: 1px solid; margin: 5px; padding: 5px;">
				<h3>House</h3>
				<p>(earns 2-5 gold)</p>
				<form method="POST" action="/updateGold">
					<input type="hidden" name="location" value="house">
					<button>Find Gold!</button>
				</form>
			</div>
			<div style="border: 1px solid; margin: 5px; padding: 5px;">
				<h3>Casino!</h3>
				<p>(earns/takes 0-50 gold)</p>
				<form method="POST" action="/updateGold">
					<input type="hidden" name="location" value="casino">
					<button>Find Gold!</button>
				</form>
			</div>
			<div style="border: 1px solid; margin: 5px; padding: 5px;">
				<h3>Spa</h3>
				<p>(takes 5-20 gold)</p>
				<form method="POST" action="/updateGold">
					<input type="hidden" name="location" value="spa">
					<button>Relax</button>
				</form>
			</div>
		</div>
		
	<form method="POST" action="/resetGold">
		<div style="margin: 10px;">
			<button>Reset Gold</button>
		</div>
	</form>
	<h2>Activities:</h2>
	<div style="margin: 10px; border: 1px solid; height: 400px; overflow: scroll;">
		<c:forEach var="activity" items="${activities}">
			<p><c:out value="${activity}"></c:out></p>
		</c:forEach>
	</div>
</body>
</html>