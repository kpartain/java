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
            <h1>EDIT EVENT</h1>
        </div>
        <!-- NAV ELEMENTS -->
        <div class="d-flex justify-content-around">
            <a href="/events">Event Dashboard</a>
            <a href="/logout">Logout</a>
        </div>

         <div class="w-50">
            <h3>Create an Event</h3>
            <form:form method="POST" action="/events/${event.id}/edit" modelAttribute="event">
                <form:input type="hidden" path="host" value="${currentUser.id}"/>
                <form:input type="hidden" path="id" value="${event.id}"/>
                <div class="d-flex justify-content-between gap-2 w-100 mb-2">
                    <label> Event Name: </label>
                    <div class="w-50">
                        <form:input path="name" class="form-control" placeholder="event name" value="${event.name}"/>
                        <form:errors path="name" class="text-danger" />
                    </div>
                </div>
                <div class="d-flex justify-content-between gap-2 w-100 mb-2">
                    <label>Date: </label>
                    <div class="w-50">
                        <form:input path="eventDate" type="date" class="form-control" />
                        <form:errors path="eventDate" class="text-danger" />
                    </div>
                </div>
                <div class="d-flex justify-content-between w-100 mb-2">
                    <label>Location </label>
                    <div class="d-flex w-50">
                        <form:input  path="eventCity" class="form-control" placeholder="city" value="${event.eventCity}"/>
                        <form:errors path="eventCity" class="text-danger" />
                        <form:select path="eventState">
                            <c:forEach items="${listOfStateCodes}" var="stateCode" varStatus="loop">
                                <c:if test="${stateCode == event.eventState}">
                                    <form:option value="${stateCode}" selected="${event.eventState}">
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
                       Update
                    </button>
                </div>
            </form:form>
        </div>
    </body>
</html>
