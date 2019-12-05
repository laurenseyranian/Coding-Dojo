<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/update.css">
	
	<title>Update one languages</title>
</head>

<body>
	<div class="container">
		<a class="btn btn-info mt-5 mb-3" href="/languages">HOME</a>
		
		<p class="display-4 mb-3 text-warning">EDIT LANGUAGE</p>
		
		<div class="updateForm">
			<form:form action="/updateLanguage/${language.id}" method="post" modelAttribute="language">
			<input type="hidden" name="_method" value="put">
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
			    
			    <div class="buttons">
			    	<input class="btn btn-success" type="submit" value="SUBMIT"/>
			    	<a class="btn btn-danger" href="/languages">CANCEL</a>
			    </div>
			    
			</form:form>
		</div>
		
<!-- end of container -->
	</div>
</body>
</html>