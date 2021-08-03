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
<form method="POST" action="/survey-post">
	<!-- name -->
	<label>Your Name: <input type="text" name="studentName" /></label></br>
	<!-- location -->
	<label>Location: <input type="text" name="location" /></label></br>
	<!-- favlang -->
	<p>Favorite Language: </p>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="favoriteLanguage">
  <c:forEach items="${languages}" var="language" varStatus="loop">
    <option value="${loop.index}">
        ${language}
    </option>
  </c:forEach>
</select>
	<!-- comment -->
	<label for="description">Comment (optional)
		<textarea type="text" name="comment" value=""></textarea>
	</label>
	<button class="btn btn-primary" type="submit">Button</button>
</form>

</body>
</html>