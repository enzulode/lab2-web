import {applyErrorMessage, clearErrors, parseAppropriateFloat, validateFormData} from "./utils/Utils.js";

$(document).ready(() => {
	const form = $("form")

	// perform form validation and submit form if form data is ok
	function validateInputs() {
		let xValue = parseAppropriateFloat($("#x-selection :selected").val())
		let yValue = parseAppropriateFloat($("#y-selection").val())
		let rValue = parseAppropriateFloat($("input[name='r']").val())

		let validationResult = validateFormData({x: xValue, y: yValue, r: rValue})
		if (!validationResult.result)
		{
			applyErrorMessage(validationResult.message)
			return
		}

		clearErrors()
		form.submit()
	}

	$("#do-check").click((e) => validateInputs())
})