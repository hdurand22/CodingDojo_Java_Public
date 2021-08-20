<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h2>Welcome</h2>
	<p>
		<form:errors path="user.*" />
	</p>

	<div style="display: inline-block;">
		<div style="margin: 10px;">
			<form:form method="POST" action="/register" modelAttribute="user">
				<p>
					<form:label path="firstName">First Name:</form:label>
					<form:input path="firstName" />
				</p>
				<p>
					<form:label path="lastName">Last Name:</form:label>
					<form:input path="lastName" />
				</p>
				<p>
					<form:label path="email">Email:</form:label>
					<form:input type="text" path="email" />
				</p>
				<p>
					<form:label path="location">Location: </form:label>
					<form:input path="location" />
					<form:label path="state" />
					<form:select path="state">
						<option value="AL">AL</option>
						<option value="AK">AK</option>
						<option value="AS">AS</option>
						<option value="AZ">AZ</option>
						<option value="AR">AR</option>
						<option value="CA">CA</option>
						<option value="CO">CO</option>
						<option value="CT">CT</option>
						<option value="DE">DE</option>
						<option value="DC">DC</option>
						<option value="FM">FM</option>
						<option value="FL">FL</option>
						<option value="GA">GA</option>
						<option value="GU">GU</option>
						<option value="HI">HI</option>
						<option value="ID">ID</option>
						<option value="IL">IL</option>
						<option value="IN">IN</option>
						<option value="IA">IA</option>
						<option value="KS">KS</option>
						<option value="KY">KY</option>
						<option value="LA">LA</option>
						<option value="ME">ME</option>
						<option value="MH">MH</option>
						<option value="MD">MD</option>
						<option value="MA">MA</option>
						<option value="MI">MI</option>
						<option value="MN">MN</option>
						<option value="MS">MS</option>
						<option value="MO">MO</option>
						<option value="MT">MT</option>
						<option value="NE">NE</option>
						<option value="NV">NV</option>
						<option value="NH">NH</option>
						<option value="NJ">NJ</option>
						<option value="NM">NM</option>
						<option value="NY">NY</option>
						<option value="NC">NC</option>
						<option value="ND">ND</option>
						<option value="MP">MP</option>
						<option value="OH">OH</option>
						<option value="OK">OK</option>
						<option value="OR">OR</option>
						<option value="PW">PW</option>
						<option value="PA">PA</option>
						<option value="PR">PR</option>
						<option value="RI">RI</option>
						<option value="SC">SC</option>
						<option value="SD">SD</option>
						<option value="TN">TN</option>
						<option value="TX">TX</option>
						<option value="UT">UT</option>
						<option value="VT">VT</option>
						<option value="VI">VI</option>
						<option value="VA">VA</option>
						<option value="WA">WA</option>
						<option value="WV">WV</option>
						<option value="WI">WI</option>
						<option value="WY">WY</option>
					</form:select>
				</p>
				<p>
					<form:label path="password">Password:</form:label>
					<form:password path="password" />
				</p>
				<p>
					<form:label path="passwordConfirmation">Password Confirmation:</form:label>
					<form:password path="passwordConfirmation" />
				</p>
				<button>Register</button>
			</form:form>
		</div>
		<div style="margin: 10px;">
			<p>
				<c:out value="${error}" />
			</p>
			<form method="POST" action="/login">
				<p>
					<label for="email">Email</label> <input type="text" id="email"
						name="email" />
				</p>
				<p>
					<label for="password">Password</label> <input type="password"
						id="password" name="password" />
				</p>
				<input type="submit" value="Login!" />
			</form>
		</div>
	</div>
</body>
</html>