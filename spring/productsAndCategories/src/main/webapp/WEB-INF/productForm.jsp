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
		<a href="/products/new">New Product</a>
		<a href="/categories/new">New Category</a>
	</div>
	<div class="d-flex justify-content-around m-5">
		<h1 class="text-center">New Product</h1>
	</div>
	<div class="mx-5">
		<form:form action="/products/new" method="POST" modelAttribute="product">
			<div class="d-flex justify-content-between mb-3 mx-5 w-100">
				<form:label path="name">Name</form:label>
				<p class="text-danger"><form:errors path="name"/></p>
				<form:input path="name" class="w-50 mx-5"/>
			</div>
			<div class="d-flex justify-content-between mb-3 mx-5 w-100">
				<form:label path="description">Description</form:label>
				<p class="text-danger"><form:errors path="description"/></p>
				<form:textarea path="description" class="w-50 mx-5"/>
			</div>
			<div class="d-flex justify-content-between mb-3 mx-5 w-100">
				<form:label path="price">Price</form:label>
				<p class="text-danger"><form:errors path="price"/></p>
				<form:input path="price" class="w-50 mx-5"/>
			</div>
			<div class="mx-5">
				<input type="submit" value="Create" class="btn btn-primary"/>
			</div>
		</form:form>
	</div>
</body>
</html>