<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
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
<body>
	<!-- NAV ELEMENTS -->
	<div class="d-flex justify-content-around">
		<h1>EDIT EVENT</h1>
		<a href="/events">Event Dashboard</a>
		<a href="/logout">Logout</a>
	</div>
	
	<!-- BODY -->
	<!-- Header -->
	<h1>Welcome, <c:out value="${loggedInUserName}" /></h1>
	
	<!-- Events in the state -->
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
			   		<td><c:out value="${eventInState.date}" /></td>
			   		<td><c:out value="${eventInState.city}" /></td>
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
	
	<!-- Events out of the state-->
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
			   		<td><c:out value="${eventNotInState.date}" /></td>
			   		<td><c:out value="${eventNotInState.city}" /></td>
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
	
	<!-- Create -->
	<form:form method="POST" action="/ninjas/new/post" modelAttribute="ninja">
		<!-- Event Name -->
		<div class="d-flex justify-content-around">
			<label> Event Name:  </label>
			<form:input path="name" class="w-50"/>
			<form:errors path="name" class="text-danger" />
		</div>
		
		<!-- Event Date -->
		<div class="d-flex justify-content-around">
			<label>Date: </label>
			<form:input type="date" path="date" class="w-50"/>
			<form:errors path="date" class="text-danger" />
		</div>
		
		<!-- Event City & State-->
		<div class="d-flex justify-content-around">
			<label>City </label>
			<form:input path="city" class="w-50"/>
			<form:errors path="city" class="text-danger" />
			<!-- Event State  in same div-->
			<form:select path="state" name="state">
	  			<c:forEach items="${listOfStateCodes}" var="stateCode"  varStatus="loop">
	  				<!--  the VALUE is the entire DOJO OBJECT! -->
	    			<form:option value="${stateCode}">
	    				<!-- 1 Name format for testing  -->
	        			<c:out value="${stateCode}"></c:out>
	    			</form:option>
	  			</c:forEach>
	  			<form:errors path="state" class="text-danger" />
			</form:select>
		</div>
	
		<!-- Submit -->
		<div class="d-flex align-items-end flex-column px-5 mx-5 mt-3">
			<button class="btn btn-primary mx-5 px-5" type="submit">Create</button>
		</div>
	
	</form:form>
	
</body>
</html>