<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
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
	<script>
        var message = "This is the " + "${word}" + " template";
        alert(message);
    </script>
    <div class="m-5 align-center">
    	<h2 class="${color}"><c:out value="${dateOrTime}"></c:out></h2>
    	
    </div>
   
</body>
</html>