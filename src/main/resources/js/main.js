import {applyErrorMessage, clearErrors, parseAppropriateFloat, validateFormData} from "./utils/Utils.js";
import {Canvas} from "./utils/Canvas.js";

$(document).ready(() => {
	const form = $("form")
	const canvas = new Canvas("area")

	$(window).on('pageshow', (e) => {
		let historyTraversal = e.persisted
			|| (typeof window.performance != 'undefined' && window.performance.navigation.type === 2)

		if (historyTraversal)
			window.location.reload()
	})

	calculatedPoints.forEach((point) => {
		$('#results-container').append(
			`<tr>
				<td>${point.x}</td>
				<td>${point.y}</td>
				<td>${point.r}</td>
				<td>${point.resultString}</td>
			</tr>`
		)
	})

	canvas.drawEmptyArea()

	$("input[type='radio'][name='r']").click((e) => {
		canvas.redrawArea($(e.target).val(), true)
		canvas.applyPoints(calculatedPoints)
	})

	canvas.onClick(
		(success) => {
			clearErrors()
			performCalculation(success)
		},
		(error) => applyErrorMessage(error)
	)

	$("#do-check").click((e) => processForm())


	/*  --------------------------------------------------------------------
		--------------------------------------------------------------------
		||||                                                            ||||
		||||                    Function declaration                    ||||
		||||                                                            ||||
		--------------------------------------------------------------------
		--------------------------------------------------------------------    */

	/**
	 * Performs form validation and if it succeeds - performs form submit.
	 *
	 */
	function processForm() {
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
		form.reset()
	}

	/**
	 * Performs exact calculation redirect for point check.
	 *
	 * @param data data to be passed with the request
	 */
	function performCalculation(data) {
		let loc = window.location
		let calculateUrl = `${loc.protocol}//${loc.host}${loc.pathname}?x=${data.x}&y=${data.y}&r=${data.r}`
		$(location).prop('href', calculateUrl)
	}

})