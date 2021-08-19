<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<!-- NEED THIS FOR DATE FORMATTING -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <!--  UTF AND TITLE -->
        <meta charset="UTF-8" />
        <title>ASSIGNMENT</title>
        <!-- for Bootstrap CSS -->
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
        <!-- YOUR own local CSS -->
        <link rel="stylesheet" type="text/css" href="/css/style.css" />
        <!-- For any Bootstrap that uses JS or jQuery-->
        <!-- 	<script src="/webjars/jquery/jquery.min.js"></script>-->
        <!-- 	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->
    </head>
    <body class="mx-5">
        <div class="d-flex justify-content-around">
            <h1>EVENT DASHBOARD</h1>
        </div>
        
        <div class="d-flex justify-content-around mb-3">
            <a href="/events">Event Dashboard</a>
            <a href="/logout">Logout</a>
        </div>

        <h1 class="mb-3">
            Welcome, <c:out value="${currentUser.firstName}" />
        </h1>

        <div class="mb-3">
            <p>Here are some of the events in your state</p>
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
                    <c:forEach items="${eventsInState}" var="singleEvent" varStatus="loop" >
                        <tr>
                            <td><a href="/events/${singleEvent.id}"><c:out value="${singleEvent.name}" /></a></td>
                            <td>
                                <fmt:formatDate pattern="MMMM d, yyyy" value="${singleEvent.eventDate}" />
                            </td>
                            <td><c:out value="${singleEvent.eventCity}" /></td>
                            <td>
                                <c:out value="${singleEvent.getHost().getFirstName()}"/>
                            </td>
                            <c:choose>
                                <c:when test="${singleEvent.getHost() == currentUser}">
                                    <td>
                                        <a href="/events/${singleEvent.id}/edit">Edit</a>
                                        <a href="/events/${singleEvent.id}/delete">Delete</a>
                                    </td>
                                </c:when>
                                <c:otherwise>
                                    <td>
                                        <c:choose>
                                            <c:when test="${singleEvent.getAttendees().contains(currentUser)}">
                                                <p>Attending</p>
                                                <a href="/events/${singleEvent.id}/remove/{currentUser}">Cancel</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="/events/${eventInState.id}/add/{currentUser}">Join</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

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
                    <c:forEach items="${eventsNotInState}" var="thisEvent" varStatus="loop" >
                        <tr>
                            <td><a href="/events/${thisEvent.id}"><c:out value="${thisEvent.name}" /></a></td>
                            <td>
                                <fmt:formatDate pattern="MMMM d, yyyy" value="${thisEvent.eventDate}"/>
                            </td>
                            <td><c:out value="${thisEvent.eventCity}" /></td>
                            <td><c:out value="${thisEvent.eventState}" /></td>
                            <td>
                                <c:out value="${thisEvent.getHost().getFirstName()}"/>
                            </td>
                            <c:choose>
                                <c:when test="${thisEvent.getHost() == currentUser}">
                                    <td>
                                        <a href="/events/${thisEvent.id}/edit">Edit</a>
                                        <a href="/events/${thisEvent.id}/delete" >Delete</a>
                                    </td>
                                </c:when>
                                <c:otherwise>
                                    <td>
                                        <c:choose>
                                            <c:when test="${thisEvent.getAttendees().contains(currentUser)}">
                                                <p>Attending</p>
                                                <a href="/events/${thisEvent.id}/remove/{currentUser}">Cancel</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="/events/${thisEvent.id}/add/{currentUser}">Join</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="w-50">
            <h3>Create an Event</h3>
            <form:form method="POST" action="/events/new" modelAttribute="event">
                <form:input type="hidden" path="host" value="${currentUser.id}"/>
                <div class="d-flex justify-content-between gap-2 w-100 mb-2">
                    <label> Event Name: </label>
                    <div class="w-50">
                        <form:input path="name" class="form-control" placeholder="event name"/>
                        <form:errors path="name" class="text-danger" />
                    </div>
                </div>
                <div class="d-flex justify-content-between gap-2 w-100 mb-2">
                    <label>Date: </label>
                    <div class="w-50">
                        <form:input path="eventDate" type="date" class="form-control"/>
                        <form:errors path="eventDate" class="text-danger" />
                    </div>
                </div>
                <div class="d-flex justify-content-between w-100 mb-2">
                    <label>Location </label>
                    <div class="d-flex w-50">
                        <form:input  path="eventCity" class="form-control" placeholder="city"/>
                        <form:errors path="eventCity" class="text-danger" />
                        <form:select path="eventState">
                            <c:forEach items="${listOfStateCodes}" var="stateCode" varStatus="loop">
                                <c:if test="${stateCode == currentUser.state}">
                                    <form:option value="${stateCode}" selected="$currentUser.state}">
                                        <c:out value="${stateCode}"></c:out>
                                    </form:option>
                                </c:if>
                                <form:option value="${stateCode}">
                                    <c:out value="${stateCode}"></c:out>
                                </form:option>
                            </c:forEach>
                            <form:errors path="eventState" class="text-danger" />
                        </form:select>
                    </div>
                </div>
                <div class="d-flex align-items-end flex-column">
                    <button class="btn btn-primary" type="submit">
                        Create
                    </button>
                </div>
            </form:form>
        </div>
    </body>
</html>
