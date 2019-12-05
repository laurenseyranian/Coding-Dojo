<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	<title>READ ALL LANGUAGES</title>
</head>

<body>
	<div class="container">
		<a class="btn btn-info mt-5 mb-3" href="/languages">HOME</a>
		<h1 class="diplay-4 mb-3 text-warning">Add a New Language</h1>

		<div class="createForm">
			<form:form action="/createLanguage" method="post" modelAttribute="language">
			    <p>
			        <form:label path="name">Language</form:label>
			        <form:errors path="name"/>
			        <form:input path="name"/>
		    	</p>
		    
			    <p>
			        <form:label path="creator">Creator</form:label>
			        <form:errors path="creator"/>
			        <form:input path="creator"/>
			    </p>
			    
			    <p>
			        <form:label path="version">Version</form:label>
			        <form:errors path="version"/>
			        <form:input path="version"/>
			    </p> 
			      
			    <input class="btn btn-success" type="submit" value="SUBMIT"/>
			    <a class="btn btn-danger" href="/languages">CANCEL</a>
			    
			</form:form>
		</div>

<!-- end of container --> 
	</div>
</body>
</html>