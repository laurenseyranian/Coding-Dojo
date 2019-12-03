<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<meta charset="UTF-8">
	<script type="text/javascript" src="js/time.js"></script>
	<title>Display Date (Time)</title>
</head>
<body>
	<h1><fmt:formatDate type = "time" value = "${time}" /></h1>
</body>
</html>