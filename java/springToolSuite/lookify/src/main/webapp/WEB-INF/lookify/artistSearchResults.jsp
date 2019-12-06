<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Results</title>
</head>
<body>
	<div>
		<a href="/songs/new">Add New</a>
		<a href="/search/topTen">Top Song</a>
		<form action="/search" method="post">
			<input type="text" name="search">
    		<input type="submit" value="Search Artists">
		</form>
	</div>
	
	<div>
		<table>
		  <tr>
		  	<th>Artist</th>
		    <th>Title</th>
		    <th>Rating</th>
		    <th>Actions</th>
		  </tr>
		  
		 	<c:forEach  items="${songs}" var="song">
		 	<tr>
			  	<td><c:out value="${song.artist}"/></td>
			    <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
			    <td><c:out value="${song.rating}"/></td>
			    <td>
			    	<form action="/songs/${song.id}" method="post">
	   			 		<input type="hidden" name="_method" value="delete">
	    				<input type="submit" value="Delete">
					</form>
			    </td>
			    </tr>
		    </c:forEach>
		  
		</table>
	</div>
</body>
</html>