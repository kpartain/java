<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<h1>${dojo.name} Location Ninjas</h1>
<div class="m-5">
	<!-- TABLE -->
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">First Name</th>
	      <th scope="col">Last Name</th>
	      <th scope="col">Age</th>
	    </tr>
	  </thead>
	  <tbody>
	
		  <c:forEach items="${ninjasInDojo}" var="ninja"  varStatus="loop">
			   <tr>
			   		<td>${ninja.firstName}</a></td>
			   		<td>${ninja.lastName}</td>
			   		<td>${ninja.age}</td>
			   </tr>
		  </c:forEach>
	
	  </tbody>
	</table>
</div>

</body>
</html>
