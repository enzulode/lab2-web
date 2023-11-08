<%@ page import="com.enzulode.dto.CheckResultDTO" %>
<%@ page import="java.util.List" %>

<div class="canvas-container">
	<canvas id="area" width="300px" height="300px"></canvas>
</div>

<script>
	let calculatedPoints = []

	function loadCalculatedPoints() {
		let pointsToBeLoaded = []
		<%
			if (session.getAttribute("results") != null)
			{
				for (CheckResultDTO result : (List<CheckResultDTO>) session.getAttribute("results"))
				{
		%>
			pointsToBeLoaded.push({x: <%= result.x %>, y: <%= result.y %>, r: <%= result.r %>, hit: <%= result.result %>, resultString: '<%= result.resultString %>'})
		<%
				}
			}
		%>

		calculatedPoints = pointsToBeLoaded
	}

	loadCalculatedPoints()
</script>