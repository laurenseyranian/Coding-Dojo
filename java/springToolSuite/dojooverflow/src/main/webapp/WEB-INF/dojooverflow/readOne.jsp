<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/readOne.css">
	
	<title>Read One Question & Create Answer</title>
</head>
<body>
<div class="container">
		<div class="jumbotron jumbotron-fluid">
		
		<a class="btn btn-outline-warning mb-5 ml-2" href="/questions">HOME</a>
		
			<h1 class="display-4 text-center mb-2">${question.question}</h1>
			<div class="row" id="tags">
			<c:forEach items="${question.tags}" var="tag">
				<h3 class="lead ml-2 text-primary"> ${tag.subject} </h3>
			</c:forEach>
			</div>
			<div class="row mt-5">
			<div class="col">
				<table class="table ml-5">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Answers</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
				
				<tbody>
					<c:forEach items="${question.answers }" var="answer">
						<tr>
							<td><c:out value="${answer.text}"/></td>
							<td><form action="/answers/${answer.id}/${question.id}" method="post">
				    				<input type="hidden" name="_method" value="delete">
				    				<input class="btn btn-outline-danger" type="submit" value="DELETE">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			
			</table>
			</div>
			
			<div class="col">
				<form:form action="/answer/create/${question.id}" method="post" modelAttribute="answer">
					<p>
						<form:label path="text" class="lead ml-5">Answer: </form:label>
						<form:errors path="text" />
						<form:textarea class="col-7" rows="7" path="text" />
					</p>
					
					<input class="btn btn-outline-success mt-2 ml-5" type="submit" value="SUBMIT" />
					<a class="btn btn-outline-danger mt-2 ml-2" href="/questions/${question.id}">CANCEL</a>
				</form:form>
			</div>
			</div>
		</div>
	</div>
</body>
</html>