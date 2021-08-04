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
<h1>TABLE AND FORM</h1>
<div class="m-5">
	<!-- TABLE -->
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Creator</th>
	      <th scope="col">Version</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	
		  <c:forEach items="${allLanguages}" var="eachLanguage"  varStatus="loop">
			   <tr>
			   		<td>${eachLanguage.name}</td>
			   		<td>${eachLanguage.creator}</td>
			   		<td>${eachLanguage.version}</td>
			   		<td>
						<a href="/languages/delete-${eachLanguage.id}">delete</a>	| 
						<a href="/languages/edit-${eachLanguage.id}">edit</a>	   		
			   		</td>
			   </tr>
		  </c:forEach>
	
	  </tbody>
	</table>
</div>

<div class="m-5 p-3">
<!-- FORM -->
	<form method="POST" action="/languages/post-new">
		<div class="d-flex justify-content-around">
			<!-- name -->
			<label> Name:  </label>
			<input type="text" name="name" class="w-50"/>
		</div>
		<div class="d-flex justify-content-around mt-3">
			<!-- Creator -->
			<label> Creator:</label>
			<input type="text" name="creator" class="w-50"/>
		</div>
		<div class="d-flex justify-content-around mt-3">
			<!-- Version -->
			<label> Version:</label>
			<input type="text" name="version" class="w-50"/>
		</div>
		<div class="d-flex align-items-end flex-column px-5 mx-5 mt-3">
			<button class="btn btn-primary mx-5 px-5" type="submit">Submit</button>
		</div>
	</form>
</div>

</body>
</html>