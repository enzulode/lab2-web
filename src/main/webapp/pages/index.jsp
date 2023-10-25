<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Main</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<%@include file="components/header.jsp"%>

	<%@include file="components/form.jsp"%>

	<%@include file="components/canvas.jsp"%>

	<%@ include file="components/results-table.jsp"%>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script type="module" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>
