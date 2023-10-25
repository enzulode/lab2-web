<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Main</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<%@include file="components/header.jsp"%>

	<div class="general-container">

		<%@include file="components/form.jsp"%>

		<%@include file="components/canvas.jsp"%>

		<%@ include file="components/results-table.jsp"%>

	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script type="module" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>
