<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- NEED THIS FOR DATE FORMATTING -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<!--  UTF AND TITLE -->
    <meta charset="UTF-8" />
    <title>ASSIGNMENT</title>
    
    <!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" type="text/css" href="/css/style.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
<!-- 	<script src="/webjars/jquery/jquery.min.js"></script>-->	
<!-- 	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->
</head>
<body class="mx-5">
<div class="d-flex justify-content-around">
<h1>EVENT DASHBOARD</h1>
</div>
	<!-- NAV ELEMENTS -->
	<div class="d-flex justify-content-around mb-3">
		<a href="/events">Event Dashboard</a>
		<a href="/logout">Logout</a>
	</div>
	
	<!-- BODY -->
	<!-- Header -->
	<h1 class="mb-3">Welcome, <c:out value="${currentUser.firstName}" /></h1>
	
	<!-- Events in the state -->
	<div class="mb-3">
	<p>Here are some of the events in your state</p>
	<!-- TABLE -->
	<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Event Name</th>
		      <th scope="col">Date</th>
		      <th scope="col">City</th>
		      <th scope="col">Host</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		   <c:forEach items="${eventsInState}" var="eventInState"  varStatus="loop">
			   <tr>
			   		<td><c:out value="${eventInState.name}" /></td>
			   		<td><c:out value="${eventInState.eventDate}" /></td>
			   		<td><c:out value="${eventInState.eventCity}" /></td>
			   		<td><c:out value="${eventInState.host.firstName}" /></td>
			  <!-- If User IS The Host -->
			  <c:if test="${eventInState.host == thisUser}">
			  		<td>
			  		<a href="events/${eventInState.id}/edit">Edit</a>
			  		<a href="events/${eventInState.id}/delete">Edit</a>
			  		</td>
			  </c:if>
			  <!-- If User is NOT The Host -->
			  <c:if test="${eventInState.host != currentUser}">
			  		<td>
				  		<!--  If they're already attending, allow them to not attend -->
				  		<c:if test="${eventInState.attendees().includes(currentUser)}" >
				  			<p>Attending</p>
				  			<a href="/events/${eventInState.id}/remove/{currentUser}">Cancel</a>
				  		</c:if>
				  		<!--  If they're NOT already attending, allow them to attend -->
				  		<c:if test="${!eventInState.attendees().includes(currentUser)}" >
				  			<a href="/events/${eventInState.id}/add/{currentUser}">Join</a>
				  		</c:if>
			  		</td>
			  </c:if>
			   </tr>
		  </c:forEach>
		  </tbody>
	</table>
	</div>
	
	<!-- Events out of the state-->
	<div class="mb-3">
	<p>Here are some events in other states</p>
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Event Name</th>
		      <th scope="col">Date</th>
		      <th scope="col">City</th>
		       <th scope="col">State</th>
		      <th scope="col">Host</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  		   <c:forEach items="${eventsNotInState}" var="eventNotInState"  varStatus="loop">
			   <tr>
			   		<td><c:out value="${eventNotInState.name}" /></td>
			   		<td><c:out value="${eventNotInState.eventDate}" /></td>
			   		<td><c:out value="${eventNotInState.eventCity}" /></td>
			   		<td><c:out value="${eventNotInState.eventState}" /></td>
			   		<td><c:out value="${eventNotInState.host.firstName}" /></td>
			  <!-- If User IS The Host -->
			  <c:if test="${eventInState.host == thisUser}">
			  		<td>
			  		<a href="events/${eventInState.id}/edit">Edit</a>
			  		<a href="events/${eventInState.id}/delete">Edit</a>
			  		</td>
			  </c:if>
			  <!-- If User is NOT The Host -->
			  <c:if test="${eventInState.host != currentUser}">
			  		<td>
				  		<!--  If they're already attending, allow them to not attend -->
				  		<c:if test="${eventInState.attendees().includes(currentUser)}" >
				  			<p>Attending</p>
				  			<a href="/events/${eventInState.id}/remove/{currentUser}">Cancel</a>
				  		</c:if>
				  		<!--  If they're NOT already attending, allow them to attend -->
				  		<c:if test="${!eventInState.attendees().includes(currentUser)}" >
				  			<a href="/events/${eventInState.id}/add/{currentUser}">Join</a>
				  		</c:if>
			  		</td>
			  </c:if>
			   </tr>
		  </c:forEach>
		  </tbody>
	</table>
	</div>
	<!-- CREATE EVENT FORM -->
	<div class="w-50">
	<h3>Create an Event</h3>
	<form:form method="POST" action="/events" modelAttribute="event">
		<!-- Event Name -->
		<div class="d-flex justify-content-between gap-2 w-100 mb-2">
			<label> Event Name:  </label>
			<div class="w-50">
				<form:input path="name" class="form-control" placeholder="event name"/>
				<form:errors path="name" class="text-danger" />
			</div>
		</div>
		
		<!-- Event Date -->
		<div class="d-flex justify-content-between gap-2 w-100 mb-2">
			<label>Date: </label>
			<div class="w-50">
				<input type="date" name="${form.event.eventDate}" class="form-control"/>
				<form:errors path="eventDate" class="text-danger" />
			</div>
		</div>
		
		<!-- Event City & State-->
		<div class="d-flex justify-content-between w-100 mb-2">
			<label>Location </label>
			
			<div class="d-flex w-50">
			<form:input path="eventCity" class="form-control" placeholder="city"/>
			<form:errors path="eventCity" class="text-danger" />
			<!-- Event State  in same div-->
			<form:select path="eventState"  >
	  			<c:forEach items="${listOfStateCodes}" var="stateCode"  varStatus="loop">
	  				<!--  PRE-SELECT THE CURRENT USER'S HOME STATE -->
	  				<c:if test="${stateCode == currentUser.state}">
	  				<form:option value="${stateCode}"  selected="$currentUser.state}">
	        			<c:out value="${stateCode}"></c:out>
	    			</form:option>
	  				</c:if>
	  				<!--  THE REST OF THE STATES -->
	    			<form:option value="${stateCode}" >
	    				<!-- 1 Name format for testing  -->
	        			<c:out value="${stateCode}"></c:out>
	    			</form:option>
	  			</c:forEach>
	  			<form:errors path="eventState" class="text-danger" />
			</form:select>
			</div>
			
		</div>
	
		<!-- Submit -->
		<div class="d-flex align-items-end flex-column">
			<button class="btn btn-primary" type="submit">Create</button>
		</div>
	
	</form:form>
	</div>
	
</body>
</html>