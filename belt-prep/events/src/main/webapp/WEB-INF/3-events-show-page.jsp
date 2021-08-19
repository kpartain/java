<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <!--  UTF AND TITLE -->
        <meta charset="UTF-8" />
        <title>ASSIGNMENT</title>

        <!-- for Bootstrap CSS -->
        <link
            rel="stylesheet"
            href="/webjars/bootstrap/css/bootstrap.min.css"
        />
        <!-- YOUR own local CSS -->
        <link rel="stylesheet" type="text/css" href="/css/style.css" />
        <!-- For any Bootstrap that uses JS or jQuery-->
        <!-- 	<script src="/webjars/jquery/jquery.min.js"></script>-->
        <!-- 	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->
    </head>
    <body>
    
        <div class="d-flex justify-content-around">
            <h1> SHOW PAGE</h1>
        </div>
        
        <div class="d-flex justify-content-around">
            <a href="/events">Event Dashboard</a>
            <a href="/logout">Logout</a>
        </div>

       <div class="d-flex justify-content-between p-5 gap-3">

        <div>
                <h3>Event Name: <c:out value="${event.name}" /></h3>
                <p>Host: <c:out value="${event.getHost().firstName}" /> <c:out value="${event.getHost().lastName}" /></p>
                <p>Date: <fmt:formatDate pattern="MMMM d, yyyy" value="${event.eventDate}"/></p>
                <p>Location: <c:out value="${event.eventCity}" />, <c:out value="${event.eventState}" /></p>
                <p>Number of Attendees: <c:out value="${event.getAttendees().size()}" /></p>
                 <table class="table table-striped">
                 <thead>
                 <tr>
                 <th scope="col">Attendee Name</th>
                 <th scope="col">Visiting From</th>
                 </tr>
                 </thead>
                 <tbody>
                 <tr>
                 <c:forEach items="${event.getAttendees()}" var="singleAttendee" varStatus="loop">
	                 <td><c:out value="${singleAttendee.firstName}" /> <c:out value="${singleAttendee.lastName}" /></td>
	                 <td><c:out value="${singleAttendee.city}" />, <c:out value="${singleAttendee.state}" /></td>
                 </c:forEach>
                 </tr>
                 </tbody>
                 </table>
        </div>
        
        <div class="align-self-center">
                <h3>Message Wall</h3>
                <div id="messagewall">
		                <div id="messagecontent">
		                <ul style="list-style-type:none;">
		                <c:forEach items="${event.getMessages()}" var="singleMessage" varStatus="loop">
		                <li>
		                	<p>
		                	<c:out value="${singleMessage.getAuthor().firstName}"></c:out> says: 
		                	<c:out value="${singleMessage.message}"></c:out>
		                	</p>
		                </li>
		                <br>
		                <p>**********************</p>
		                </c:forEach>
		                </ul>
		                </div>
          		</div>
          		
	           <div class="mt-3">
	              <form:form method="POST" action="/events/${event.id}/post-message" modelAttribute="newmessage">
	            	<form:input type="hidden" path="author" value="${currentUser.id}" />
	            	<form:input type="hidden" path="event" value="${event.id}"/>
	            	<p>Add Comment:</p>
	            	<form:errors path="message" class="text-danger" />
	            	<form:input type="textarea" path="message" id="messageinput"/>
	            	<div class="mt-2">
	            		<button class="btn btn-primary" type="submit">
	                        Create
	                    </button>
	                </div>
	            </form:form>
	            </div>
        </div>

        </div>
    </body>
</html>
