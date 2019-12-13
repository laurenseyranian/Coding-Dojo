<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    
    <title>Login Page</title>
</head>
<body>
	<div class="container">
		<div class="loginBox ml-5">
		    <h1 class="display-4 text-primary">Login</h1>
		    
		    <p class="text-danger"><c:out value="${error}" /></p>
		    
		    <form method="post" action="/login">
				<p>
			    	<label class="col-sm-4 col-form-label" for="email">Email</label>
			        <input class="form-control col-sm-6"  type="text" id="email" name="email"/>
			    </p>
			    
			    <p>
			        <label class="col-sm-4 col-form-label" for="password">Password</label>
			        <input class="form-control col-sm-6" type="password" id="password" name="password"/>
			    </p>
			    
			    <input class="btn btn-outline-primary mt-3" type="submit" value="Login"/>
			 </form>
	    </div>
<!-- end of container -->
    </div>   
</body>
</html>