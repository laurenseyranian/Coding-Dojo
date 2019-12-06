<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
	<title>Read All Licenses</title>
</head>
<body>
	<div class="container">
		<a class="btn btn-success mt-2" href="/persons/new">New Person</a>
		
		<h1 class="display-4">Information</h1>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
 					<th scope="col">License #</th>
					<th scope="col">State</th>
					<th scope="col">Expiration Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${persons}" var="person">
					<tr>
						<td><a href="/persons/${person.id}">${person.firstName}</a></td>
						<td><c:out value="${person.lastName}"/></td>
						<td><fmt:formatNumber value="${person.license.number}" minIntegerDigits="5" groupingUsed="false"/></td>
						<td><c:out value="${person.license.state}"/></td>
						<td><fmt:formatDate pattern="MMMM dd, yyyy" value="${person.license.expirationDate}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>