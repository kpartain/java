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
<h1>EDIT FORM IN TABLE FOR FUN </h1>
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
	  <tbody class="w-100">
	
		  <c:forEach items="${allLanguages}" var="eachLanguage"  varStatus="loop">
			   
			   <c:if test="${eachLanguage.id == language.id}">
			 
				   	<form:form method="POST" action="/languages/${language.id}" modelAttribute="language">
				   	<form:input type="hidden" path="id" value="${language.id }"/>
				   	 <tr>
							<td>
								<form:label path="name">
									 <form:errors path="name" class="text-danger"/>
									</form:label>
									<form:input path="name" placeholder="name"/>
							</td>
							
							<td>
								<form:label path="creator">
									<form:errors path="creator" class="text-danger"/>
										</form:label>
									<form:input path="creator" placeholder="creator"/>
							</td>
							
							<td>
								<form:label path="version">
									<form:errors path="version" class="text-danger"/>
									</form:label>
									<form:input path="version" placeholder="version"/>
							</td>
							
							<td class="d-flex align-self-stretch align-items-stretch">
								<button type="submit"  class="btn btn-link">Submit </button>
								<a href="/languages" class="align-self-center"> Cancel</a>
							</td>
							</tr>
						</form:form>
				</c:if>
			   <!--  if it is not the current ID -->
			   <c:if test="${eachLanguage.id != language.id}">
			 <tr>
			   		<td><a href="/languages/${eachLanguage.id}">${eachLanguage.name}</a></td>
			   		<td>${eachLanguage.creator}</td>
			   		<td>${eachLanguage.version}</td>
			   		<td>
						<a href="/languages/delete/${eachLanguage.id}" class="btn btn-link disabled">delete</a>	| 
						<a href="/languages/${eachLanguage.id}" class="btn btn-link disabled">edit</a>	   		
			   		</td>
			</tr>
			</c:if>
			
		  </c:forEach>
	
	  </tbody>
	</table>
</div>

<!-- "fake form" -->
<div class="m-5 p-5">
		<div class="d-flex mt-3 justify-content-between mx-5">
			<!-- name -->
				<p class="w-30">Name </p>
			<input type="text" placeholder="unable to add new language while editing existing" class="w-50" />
		</div>
		
		<div class="d-flex mt-3 justify-content-between mx-5">
					<p class="w-30">Creator </p>
			<input type="text" placeholder="unable to add new language while editing existing" class="w-50" />
		</div>
		
		<div class="d-flex mt-3 justify-content-between mx-5">
				<p class="w-30">Version </p>
			<input type="text" placeholder="unable to add new language while editing existing" class="w-50"/>
		</div>
		
		<div class="d-flex align-items-end flex-column mt-3  mx-5">
			<button class="btn btn-primary px-5 disabled" type="submit">Submit</button>
		</div>
</div>


</body>
</html>