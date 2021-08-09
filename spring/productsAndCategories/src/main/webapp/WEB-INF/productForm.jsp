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
<div class="d-flex m-5">
	<!--  New Product -->
	<form:form method="POST" action="/product-post" modelAttribute="product">
	
		<fieldset class="border p-2">
		
			    <legend class="w-auto">New Product</legend>
			    
			    	<p><form:errors path="user.*"/></p>
			    	<!-- PRODUCT NAME -->
			        <p class="d-flex justify-content-between gap-2">
			            <form:label path="name">Name:</form:label>
			            <form:input type="text" path="name" class="form-control input-lg w-50"/>
			        </p>
			        <!-- DESCRIPTION -->
			        <p class="d-flex justify-content-between gap-2">
			            <form:label path="description">Description:</form:label>
			            <form:textarea path="description" type="text"class="form-control input-lg w-50"/>
			        </p>
			        <!-- PRICE -->
			        <p class="d-flex justify-content-between gap-2">
			            <form:label path="price">Price:</form:label>
			            <form:text path="price" type="text" class="form-control input-lg w-50"/>
			        </p>
			        
			        <div class="d-flex flex-row-reverse">
			        	<input type="submit" class="btn btn-primary" value="Create"/>
			        </div>
			
	  		 </fieldset>
	  		 
	    </form:form>
    <!--  end main div -->
</div>

</body>
</html>