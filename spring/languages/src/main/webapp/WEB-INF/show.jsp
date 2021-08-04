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
<h1>Show Page</h1>
<div class="m-5">
<!--  DASHBOARD LINK -->
	<div class="d-flex align-items-end flex-column">
		<a href="/languages">Dashboard</a>
	</div>
<!-- BODY -->
<p class="mt-3">${language.name}</p>
<p class="mt-3">${language.creator}</p>
<p class="mt-3">${language.version}</p>
<a href="/languages/${language.id}/edit" class="mt-3">Edit</a>
<a href="languages/delete/${language.id}" class="mt-3">Delete</a>
</div>

</body>
</html>