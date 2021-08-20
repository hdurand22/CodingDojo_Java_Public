<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Events</title>
</head>
<body>
	<h1>Welcome, Ninja</h1>
	<div style="margin: 10px;">
		<span>Here are some of the events in your state:</span>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action / Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${stateEvents}" var="stateEvent">
					<tr>
						<td><a href="/events/${stateEvent.id}"><c:out
									value="${stateEvent.name}" /></a></td>
						<td><c:out value="${stateEvent.eventDate}" /></td>
						<td><c:out value="${stateEvent.eventLocation}" /></td>
						<td><c:out value="${stateEvent.host.firstName}" /></td>
						<td><c:choose>
								<c:when
									test="${stateEvent.host.id != user.id && !user.attendedEvents.contains(stateEvent)}">
									<form method="POST" action="/attendEvent/${stateEvent.id}">
										<input type="hidden" name="_method" value="put"> <input
											type="submit" value="Join" />
									</form>
								</c:when>
								<c:when test="${stateEvent.host.id == user.id}">
									<a href="/events/${stateEvent.id}/edit">Edit</a>
									<form method="POST" action="/cancelEvent/${stateEvent.id}">
										<input type="hidden" name="_method" value="delete"> <input
											type="submit" value="Delete" />
									</form>
								</c:when>
								<c:otherwise>
									<form method="POST" action="/declineEvent/${stateEvent.id}">
										<input type="hidden" name="_method" value="put"> <input
											type="submit" value="Decline" />
									</form>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div style="margin: 10px">
		<span>Here are some of the events in other states:</span>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action / Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${outOfStateEvents}" var="outOfStateEvent">
					<tr>
						<td><a href="/events/${outOfStateEvent.id}"><c:out
									value="${outOfStateEvent.name}" /></a></td>
						<td><c:out value="${outOfStateEvent.eventDate}" /></td>
						<td><c:out value="${outOfStateEvent.eventLocation}" /></td>
						<td><c:out value="${outOfStateEvent.host.firstName}" /></td>
						<td><c:choose>
								<c:when
									test="${outOfStateEvent.host.id != user.id && !user.attendedEvents.contains(outOfStateEvent)}">
									<form method="post"
										action="/attendEvent/${outOfStateEvent.id}">
										<input type="hidden" name="_method" value="put">
										<input type="submit" value="Join" />
									</form>
								</c:when>
								<c:when test="${outOfStateEvent.host.id == user.id}">
									<a href="/events/${outOfStateEvent.id}/edit">Edit</a>
									<form method="post"
										action="/cancelEvent/${outOfStateEvent.id}">
										<input type="hidden" name="_method" value="delete">
										<input type="submit" value="Delete" />
									</form>
								</c:when>
								<c:otherwise>
									<form method="POST"
										action="/declineEvent/${outOfStateEvent.id}">
										<input type="submit" value="Decline" />
									</form>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div style="margin: 10px">
		<form:form action="/newEvent" method="POST" modelAttribute="newEvent">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name" />
				<form:input type="text" path="name" />
			</p>
			<p>
				<form:label path="eventDate">Date</form:label>
				<form:errors path="eventDate" />
				<form:input type="date" path="eventDate" />
			</p>
			<p>
				<form:label path="eventLocation">Location</form:label>
				<form:errors path="eventLocation" />
				<form:input type="text" path="eventLocation" />
				<form:label path="eventState" />
				<form:select path="eventState">
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
			<button>Create</button>
		</form:form>
	</div>
</body>
</html>