<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script type="text/javascript" src="js/date.js"></script>
	<title>Display Date (Date)</title>
</head>

<body>
	<h1><fmt:formatDate pattern = "yyyy-MM-dd" value = "${date}" /></h1>
</body>
</html>