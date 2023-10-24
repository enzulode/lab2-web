<%@ page import="com.enzulode.dto.CheckResultDTO" %>
<%@ page import="java.util.List" %>

<table style="border: 1px; text-align: center;">
	<thead>
		<tr>
			<td>X</td>
			<td>Y</td>
			<td>R</td>
			<td>Result</td>
		</tr>
	</thead>
	<tbody>
		<%
			if (session.getAttribute("results") != null)
			{
				for (CheckResultDTO result : (List<CheckResultDTO>) session.getAttribute("results"))
				{
		%>
			<tr>
				<td><%= result.getX() %></td>
				<td><%= result.getY() %></td>
				<td><%= result.getR() %></td>
				<td><%= result.getResultString() %></td>
			</tr>
		<%      }
			}
		%>
	</tbody>
</table>