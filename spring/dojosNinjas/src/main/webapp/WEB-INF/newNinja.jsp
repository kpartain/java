<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html lang="en">
<head>
	<!--  UTF AND TITLE -->
    <meta charset="UTF-8" />
    <title>ASSIGNMENT</title>
    
    <!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" type="text/css" href="/css/style.css"/> 
	<!-- For any Bootstrap that uses JS or jQuery-->
		<!-- 	<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->
</head>
<body>

<div class="m-5 p-3">
<h1>New Ninja</h1>
<!-- FORM -->
	<form:form method="POST" action="/ninjas/new/post" modelAttribute="ninja">
		<!-- Dojo Name -->
		<div class="d-flex justify-content-around">
			<form:select path="dojo" name="dojo">
	  			<c:forEach items="${listOfDojos}" var="eachDojo"  varStatus="loop">
	  				<!--  the VALUE is the entire DOJO OBJECT! -->
	    			<form:option value="${eachDojo}">
	    				<!-- 1.) Name format for testing  -->
	        			${eachDojo.id}.) ${eachDojo.name}
	    			</form:option>
	  			</c:forEach>
			</form:select>
		</div>
		
		<!-- Firstname -->
		<div class="d-flex justify-content-around">
			<label> First name:  </label>
			<input type="text" name="firstName" class="w-50"/>
		</div>
		
		<!-- Last name -->
		<div class="d-flex justify-content-around">
			<label>Last name:  </label>
			<input type="text" name="lastName" class="w-50"/>
		</div>
		
		<!-- Age -->
		<div class="d-flex justify-content-around">
			<label> Age:  </label>
			<input type="number" name="age" class="w-50"/>
		</div>
		
		<!-- Submit -->
		<div class="d-flex align-items-end flex-column px-5 mx-5 mt-3">
			<button class="btn btn-primary mx-5 px-5" type="submit">Create</button>
		</div>
		
	</form:form>
</div>

</body>
</html>