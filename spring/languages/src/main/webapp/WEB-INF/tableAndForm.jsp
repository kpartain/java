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
			   		<td><a href="/languages/${eachLanguage.id}">${eachLanguage.name}</a></td>
			   		<td>${eachLanguage.creator}</td>
			   		<td>${eachLanguage.version}</td>
			   		<td>
						<a href="/languages/delete/${eachLanguage.id}">delete</a>	| 
						<a href="/languages/${eachLanguage.id}">edit</a>	   		
			   		</td>
			   </tr>
		  </c:forEach>
	
	  </tbody>
	</table>
</div>

<div class="m-5 p-5">
<!-- FORM -->
	<form:form method="POST" action="/languages" modelAttribute="language">
	
		<div class="d-flex mt-3 justify-content-between mx-5">
			<!-- name -->
			<form:label path="name">
				<p class="w-30">Name <form:errors path="name" class="text-danger"/></p>
			</form:label>
			<form:input class="w-50" path="name" placeholder="name"/>
		</div>
		
		<div class="d-flex mt-3 justify-content-between mx-5">
			<!-- Creator -->
			<form:label path="creator">
					<p class="w-30">Creator <form:errors path="creator" class="text-danger"/></p>
			</form:label>
			<form:input class="w-50" path="creator" placeholder="creator"/>
		</div>
		
		<div class="d-flex mt-3 justify-content-between mx-5">
			<!-- Version -->
			<form:label path="version">
				<p class="w-30">Version <form:errors path="version" class="text-danger"/></p>
			</form:label>
			<form:input class="w-50" path="version" placeholder="version"/>
		</div>
		
		<div class="d-flex align-items-end flex-column mt-3  mx-5">
			<button class="btn btn-primary px-5" type="submit">Submit</button>
		</div>
	</form:form>
</div>

</body>
</html>