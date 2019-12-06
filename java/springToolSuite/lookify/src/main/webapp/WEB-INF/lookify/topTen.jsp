<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Top Ten Songs</title>
</head>
<body>
	<div>
	
		<div>
			<a href="/dashboard">Dashboard</a>
			<a href="/songs/new">Add New</a>
			<form action="/search" method="post">
				<input type="text" name="search">
    			<input type="submit" value="Search Artists">
			</form>
			<h1>View One Song<h1>
		</div>
		
		<div>
			<c:forEach  items="${songs}" var="song">
				<p><c:out value="${song.rating}"/> - <a href="/songs/${song.id}"><c:out value="${song.title}"/></a> - <c:out value="${song.artist}"/></p>
			</c:forEach>
		</div>
		
	</div>
</body>
</html>