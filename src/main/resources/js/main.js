import {applyErrorMessage, clearErrors, parseAppropriateFloat, validateFormData} from "./utils/Utils.js";
import {Canvas} from "./utils/Canvas.js";

const canvas = new Canvas("area")

$(window).on('load', () => {
	canvas.drawEmptyArea()
})

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
	$("input[name='r']").click((e) => {
		canvas.redrawArea($(e.target).val(), true)
		canvas.applyPoints(calculatedPoints)
	})

	canvas.onClick(
		(success) => {
			clearErrors()

			let loc = window.location
			let calculateUrl = `${loc.protocol}//${loc.host}${loc.pathname}?x=${success.x}&y=${success.y}&r=${success.r}`
			$(location).prop('href', calculateUrl)
		},
		(error) => {
			applyErrorMessage(error)
		}
	)

})