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
<div class="d-flex justify-content-around">
<h1>LOGIN & REGISTRATION</h1>
</div>
	<!-- NAV ELEMENTS -->
	<div class="d-flex justify-content-around">
		<a href="/events">Event Dashboard</a>
		<a href="/">Logout</a>
	</div>
	
	<div class="d-flex justify-content-between mx-5">
<!-- *****************************************************REGISTER***************************************************** -->
	 <div>
	    <form:form action="/register" method="post" modelAttribute="newUser">
        <div class="form-group">
            <label>First Name:</label>
            <form:input path="firstName" class="form-control" />
            <form:errors path="firstName" class="text-danger" />
        </div>
        
         <div class="form-group">
            <label>Last Name:</label>
            <form:input path="lastName" class="form-control" />
            <form:errors path="lastName" class="text-danger" />
        </div>
        
        <div class="form-group">
            <label>City:</label>
            <form:input path="city" class="form-control" />
            <form:errors path="city" class="text-danger" />
        </div>
        
         <div class="form-group">
            <label>State:</label>
            <form:select path="state" name="state">
	  			<c:forEach items="${listOfStateCodes}" var="state"  varStatus="loop">
	  				<!--  the VALUE is the entire DOJO OBJECT! -->
	    			<form:option value="${state}">
	    				<!-- 1 Name format for testing  -->
	        			<c:out value="${state}"></c:out>
	    			</form:option>
	  			</c:forEach>
			</form:select>
            <form:errors path="state" class="text-danger" />
        </div>
        
        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" class="text-danger" />
        </div>
        
        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-danger" />
        </div>
        
        <div class="form-group">
            <label>Confirm Password:</label>
            <form:password path="confirm" class="form-control" />
            <form:errors path="confirm" class="text-danger" />
        </div>
        <input type="submit" value="Register" class="btn btn-primary" />
    </form:form>
    </div>
<!-- *****************************************************LOGIN *****************************************************************-->
<div>
 <form:form action="/login" method="post" modelAttribute="newLogin">
        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" class="text-danger" />
        </div>
        
        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-danger" />
        </div>
        <input type="submit" value="Login" class="btn btn-success" />
    </form:form>
    </div>
    
    <!--  end main flex parent box -->
 </div>
	
</body>
</html>