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
	<form:form method="POST" action="/languages/${language.id}/edited" modelAttribute="language">
		<input type="hidden" name="_method" value="put">
		<div class="d-flex justify-content-around">
			<!-- name -->
			<p>
			<form:label path="name"> Name:  </form:label>
			<form:errors path="name"/>
			<form:input path="name" class="w-50"/>
			</p>
		</div>
		<div class="d-flex justify-content-around mt-3">
			<!-- Creator -->
			<p>
			<form:label path="creator"> Creator:</form:label>
			<form:errors path="creator"/>
			<form:input path="creator" class="w-50"/>
			</p>
		</div>
		<div class="d-flex justify-content-around mt-3">
			<!-- Version -->
			<p>
			<form:label path="version"> Version:</form:label>
			<form:errors path="version"/>
			<form:input path="version" class="w-50"/>
			</p>
		</div>
		<div class="d-flex align-items-end flex-column px-5 mx-5 mt-3">
			<input type="submit" value="submit" />
		</div>
	</form:form>
	
</div>


</body>
</html>