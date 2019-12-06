<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>One Song</title>
</head>
<body>
	<div>
	
		<div>
			<a href="/dashboard">Dashboard</a>
			<a href="/songs/new">Add New</a>
			<a href="/search/topTen">Top Song</a>
			<form action="/search" method="post">
				<input type="text" name="search">
    			<input type="submit" value="Search Artists">
			</form>
			<h1>View One Song<h1>
		</div>
		
		<div>
			<p>Title: <c:out value="${song.title}"/></p>
			<p>Artist: <c:out value="${song.artist}"/></p>
			<p>Rating (1-10): <c:out value="${song.rating}"/></p>
		</div>
		
		<div>
			<form action="/songs/${song.id}" method="post">
	   			 <input type="hidden" name="_method" value="delete">
	    		<input type="submit" value="Delete">
			</form>
		</div>
		
	</div>
</body>
</html>