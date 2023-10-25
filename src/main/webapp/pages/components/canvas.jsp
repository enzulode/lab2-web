<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			pointsToBeLoaded.push({x: <%= result.x %>, y: <%= result.y %>, hit: <%= result.result %>})
		<%
				}
			}
		%>

		calculatedPoints = pointsToBeLoaded
	}

	loadCalculatedPoints()
	console.log(calculatedPoints)
</script>