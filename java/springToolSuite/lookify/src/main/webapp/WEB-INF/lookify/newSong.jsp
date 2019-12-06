<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Song</title>
</head>
<body>
	<div>
		<div>
			<a href="/dashboard">Dashboard</a>
			<a href="/search/topTen">Top Song</a>
			<form action="/search" method="post">
				<input type="text" name="search">
    			<input type="submit" value="Search Artists">
			</form>
			<h1>Add A Song<h1>
		</div>
		
		<div>
			<form:form action="/createSong" method="post" modelAttribute="song">
			    <p>
			        <form:label path="title">Title</form:label>
			        <form:errors path="title"/>
			        <form:input path="title"/>
			    </p>
			    
			    <p>
			        <form:label path="artist">Artist</form:label>
			        <form:errors path="artist"/>
			        <form:input path="artist"/>
			    </p>
			    
			    <p>
			        <form:label path="rating">Rating</form:label>
			        <form:errors path="rating"/>
			        <form:select path="rating">
			        	<form:option value="1">1</form:option>
                		<form:option value="2">2</form:option>
                		<form:option value="3">3</form:option>
                		<form:option value="4">4</form:option>
                		<form:option value="5">5</form:option>
                		<form:option value="6">6</form:option>
                		<form:option value="7">7</form:option>
                		<form:option value="8">8</form:option>
                		<form:option value="9">9</form:option>
                		<form:option value="10">10</form:option>
            		</form:select>
			    </p>
			    <input type="submit" value="Add Song"/>
			</form:form>
		</div>
	</div>
</body>
</html>