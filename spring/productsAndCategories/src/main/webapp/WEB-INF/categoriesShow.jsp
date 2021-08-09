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
<!--  Category name header  -->
<h1 class="m-5"><c:out value="${category.name}"/></h1>
<!--  MAIN DIV - flex, half/half-->
<div class="d-flex m-5 justify-content-between gap-5">
	<!--  LEFT: Current Products  -->
	<div class="m-5 w-50">
	<h2>Products:</h2> <!--currently has -->
	<ul>
		<c:forEach items="${allProductsInCategory}" var="eachProduct" varStatus="loop">
			<li>
				<c:out value="${eachProduct.name}" />
			</li>
		</c:forEach>
	</ul>
	</div>
    
    <!--  RIGHT: Add a product, flex half/half -->
    <div class="m-5 w-50 d-flex m-5 justify-content-between gap-5">
	    <div><p>Add Product</p></div>
	    <div> <!--  Double check syntax - should we allow multiple selections?? -->
		    <form:form method="PUT" action="/add-product-to-category/{category.id}" modelAttribute="product">
				<form:select path="categories" name="categories">
			  		<c:forEach items="${productsNotInCategory}" var="eachProduct"  varStatus="loop"> <!-- currently doesn't have -->
			  			<!--  the VALUE is the entire DOJO OBJECT! -->
			    		<form:option value="${eachProduct}">
			    			<!-- 1 Name format for testing  -->
			        		<c:out value="${eachProduct.name}"></c:out>
			    		</form:option>
			  		</c:forEach>
				</form:select>
				<button class="btn btn-primary mx-5 px-5" type="submit">Add Product To Category</button>
			</form:form>
		</div>
    </div>
  
<!--  end main div -->
</div>

</body>
</html>