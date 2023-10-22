package com.enzulode.validation;

import com.enzulode.dto.PointCoordinatesCheckDTO;
import com.enzulode.exception.InvalidAreaSizeException;
import com.enzulode.exception.InvalidPointCoordinatesException;
import com.enzulode.exception.NullValidationTargetException;
import com.enzulode.exception.ValidationException;

import java.util.List;

/**
 * A {@link Validator} implementation for {@link PointCoordinatesCheckDTO}.
 *
 */
public class PointCoordinatesCheckDTOValidator implements Validator<PointCoordinatesCheckDTO>
{
	/**
	 * This list contains all valid point x-coordinate values.
	 *
	 */
	private final List<Integer> VALID_X_VALUES = List.of(-3, -2, -1, 0, 1, 2, 3, 4, 5);

	/**
	 * This list contains all valid area size values.
	 *
	 */
	private final List<Integer> VALID_AREA_SIZES = List.of(1, 2, 3, 4, 5);


	/**
	 * This method performs validation.
	 *
	 * @param obj an object being checked
	 * @throws ValidationException if validation process not ended up successfully
	 */
	@Override
	public void validate(PointCoordinatesCheckDTO obj) throws ValidationException
	{
		if (obj == null)
			throw new NullValidationTargetException("Something went wrong: validation target does not exist");

		if (obj.x() == null || !VALID_X_VALUES.contains(obj.x()))
			throw new InvalidPointCoordinatesException("Something went wrong: x is out of valid range");

		if (obj.y() == null || (obj.y() <= -3 || obj.y() >= 5))
			throw new InvalidPointCoordinatesException("Something went wrong: y is out of valid range");

		if (obj.r() == null || !VALID_AREA_SIZES.contains(obj.r()))
			throw new InvalidAreaSizeException("Something went wrong: r is out of valid range");
	}
}
