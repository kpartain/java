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
<h1>New Dojo</h1>
<!-- FORM -->
	<form:form method="POST" action="/dojos/new/post" modelAttribute="dojo">
		<div class="d-flex justify-content-around">
			<!-- name -->
			<label> Dojo:  </label>
			<input type="text" name="name" class="w-50"/>
		</div>
		<div class="d-flex align-items-end flex-column px-5 mx-5 mt-3">
			<button class="btn btn-primary mx-5 px-5" type="submit">Create</button>
		</div>
	</form:form>
</div>

</body>
</html>
