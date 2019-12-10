<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<title>Read All Questions</title>
</head>
<body>
<div class="container">
		<div class="jumbotron jumbotron-fluid">
		<a class="btn btn-outline-secondary mb-2 ml-2" href="/questions/new">ADD QUESTION</a>
			<h1 class="display-4 text-center mb-2">Questions Dashboard</h1>
			
			<table class="table">
				<thead class="thead-warning">
					<tr>
						<th scope="col">Question</th>
						<th scope="col">Tags</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${questions}" var="question">
						<tr>
							<td><a href="/questions/${question.id}"><c:out value="${question.question}"/></a></td>
							<td>
								<c:forEach items="${question.tags}" var="tag">${tag.subject},</c:forEach>
							</td>
							<td><form action="/questions/${question.id}" method="post">
				    				<input type="hidden" name="_method" value="delete">
				    				<input class="btn btn-outline-danger" type="submit" value="DELETE">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			
			</table>
			
		</div>
	</div>
</body>
</html>