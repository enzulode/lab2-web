<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Result page</title>
</head>
<body>
	<h1>Results are here</h1>

	<table>
		<thead>
			<tr>
				<td>X</td>
				<td>Y</td>
				<td>R</td>
				<td>Result</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${ result.x }</td>
				<td>${ result.y }</td>
				<td>${ result.r }</td>
				<td>${ result.resultString }</td>
			</tr>
		</tbody>
	</table>

	<p><a href="<%= request.getContextPath() %>">Back to main page</a></p>
</body>
</html>
