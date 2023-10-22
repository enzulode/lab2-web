<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Result page</title>
</head>
<body>
	<h1>Results are here</h1>

	<p>X: ${result.x}</p>
	<p>Y: ${result.y}</p>
	<p>R: ${result.r}</p>
	<p>Area hit result: ${result.result}</p>

	<p><a href="<%= request.getContextPath() %>">Back to main page</a></p>
</body>
</html>
