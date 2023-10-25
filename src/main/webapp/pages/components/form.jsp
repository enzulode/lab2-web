<div class="container form-container">
	<form action="${pageContext.request.contextPath}" method="GET">
		<div class="x-input-container">
			<label for="x-selection">
				<span>X:</span>
				<select name="x" id="x-selection" class="form-select">
					<option value="-3">-3</option>
					<option value="-2">-2</option>
					<option value="-1">-1</option>
					<option value="0">0</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			</label>
		</div>

		<div class="y-input-container">
			<label for="y-selection">
				<span>Y:</span>
				<input type="text" class="form-control" name="y" id="y-selection" placeholder="Enter y (-3, 5):">
			</label>
		</div>

		<div class="r-input-container">
			<span>R:</span>
			<label for="r-1">
				<span>1</span>
				<input type="radio" class="form-check-input" name="r" id="r-1" value="1">
			</label>

			<label for="r-2">
				<span>2</span>
				<input type="radio" class="form-check-input" name="r" id="r-2" value="2">
			</label>

			<label for="r-3">
				<span>3</span>
				<input type="radio" class="form-check-input" name="r" id="r-3" value="3">
			</label>

			<label for="r-4">
				<span>4</span>
				<input type="radio" class="form-check-input" name="r" id="r-4" value="4">
			</label>

			<label for="r-5">
				<span>5</span>
				<input type="radio" class="form-check-input" name="r" id="r-5" value="5">
			</label>
		</div>

		<p id="error-message"></p>

		<button type="button" id="do-check" class="btn btn-primary">Check</button>
	</form>
</div>