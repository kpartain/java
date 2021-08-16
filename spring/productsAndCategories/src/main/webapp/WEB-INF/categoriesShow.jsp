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
		<h1>Category: 
			<c:out value="${category.name}"/>
		</h1>
	</div>
	
	<!--  PARENT DIV -->
	<div class="d-flex justify-content-between m-5">
		
		<!--  LEFT - CURRENT PRODUCTS -->
		<div class="justify-content-between">
			<p>Current Products In Category:</p>
			<ul style="list-style: none">
				<c:forEach items="${category.products}" var="product">
					<li>
						<c:out value="${product.name}"/>
					</li>
				</c:forEach>
			</ul>
		</div>
		
		<!--  RIGHT - ADD PRODUCTS FORM-->
		<div>
			<c:if test="${!empty products}">
			<div>
				<p>Add Product To Category:<p>
			</div>
			<form action="/categories/${ category.id }" method="POST">
				<div class="d-flex justify-content-between">
					<label for="product">Product:</label>
					<select name="product">
						<c:forEach items="${ products }" var="product">
							<option value="${ product.id }">
								<c:out value="${ product.name }"/></option>
						</c:forEach>
					</select>
				</div>
				<input type="submit"  value="Add" class="btn btn-primary"/>
			</form>
			</c:if>
		</div>
	
	</div>
</body>
</html>