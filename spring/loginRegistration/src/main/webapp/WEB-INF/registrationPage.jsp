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
<!--  MAIN DIV -->
<div class="d-flex m-5 justify-content-between gap-5">
	<!--  LEFT: Registration -->
	<div class="m-5 w-50">
	
	<form:form method="POST" action="/registration" modelAttribute="user">
	
		<fieldset class="border p-2">
			    <legend class="w-auto">Register:</legend>
			    	<p><form:errors path="user.*"/></p>
			        <p class="d-flex justify-content-between gap-2">
			            <form:label path="email">Email:</form:label>
			            <form:input type="email" path="email" class="form-control input-lg w-50"/>
			        </p>
			        <p class="d-flex justify-content-between gap-2">
			            <form:label path="password">Password:</form:label>
			            <form:password path="password" class="form-control input-lg w-50"/>
			        </p>
			        <p class="d-flex justify-content-between gap-2">
			            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
			            <form:password path="passwordConfirmation" class="form-control input-lg w-50"/>
			        </p>
			        <div class="d-flex flex-row-reverse">
			        	<input type="submit" class="btn btn-primary" value="Register!"/>
			        </div>
			
	  		 </fieldset>
	  		 
	    </form:form>
    </div>
    
    <!--  RIGHT: Login -->
    <div class="m-5 w-50">
    <form method="post" action="/login">
    
    <fieldset class="border p-2">
	    <legend class="w-auto">Login:</legend>
	    
	    
	    	<p><c:out value="${error}" /></p>
	    
	        <p class="d-flex justify-content-between gap-2 w-100">
	            <label for="email">Email</label>
	            <input type="text" id="email" name="email" class="form-control input-lg w-50"/>
	        </p>
	        <p class="d-flex justify-content-between gap-2 w-100">
	            <label for="password">Password</label>
	            <input type="password" id="password" name="password" class="form-control input-lg w-50"/>
	        </p>
	        <div class="d-flex flex-row-reverse">
	        	<input type="submit" class="btn btn-primary" value="Login!"/>
	        </div>
	    
    </fieldset>
    
    </form>
    </div>
<!--  end main div -->
</div>

</body>
</html>
