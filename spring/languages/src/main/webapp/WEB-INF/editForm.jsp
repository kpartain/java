<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
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
<h1>EDIT EXISTING LANGUAGE</h1>
<div class="m-5 p-3">

<!-- LINKS -->
	<div class="d-flex align-items-end flex-column">
		<a href="/languages/delete/${language.id}">Delete</a>
		<a href="/languages">Dashboard</a>
	</div>
<!-- FORM -->

<div>
	<form:form method="POST" action="/languages/${language.id}/edited" modelAttribute="language">
		<input type="hidden" name="_method" value="put">
		<div class="d-flex mt-3 justify-content-between">
			<!-- name -->
			<form:label path="name">
				<p class="w-30">Name <form:errors path="name" class="text-danger"/></p>
			</form:label>
			<form:input class="w-50" path="name"/>
		</div>
		
		<div class="d-flex mt-3 justify-content-between">
			<!-- Creator -->
			<form:label path="creator">
					<p class="w-30">Creator <form:errors path="creator" class="text-danger"/></p>
			</form:label>
			<form:input class="w-50" path="creator"/>
		</div>
		
		<div class="d-flex mt-3 justify-content-between">
			<!-- Version -->
			<form:label path="version">
				<p class="w-30">Version <form:errors path="version" class="text-danger"/></p>
			</form:label>
			<form:input class="w-50" path="version"/>
		</div>
		
		<div class="d-flex align-items-end flex-column mt-3">
			<button class="btn btn-primary px-5" type="submit">Submit</button>
		</div>
	</form:form>
</div>

</div>
</body>
</html>