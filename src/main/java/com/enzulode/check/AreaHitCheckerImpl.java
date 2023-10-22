package com.enzulode.check;

import com.enzulode.dto.PointCoordinatesCheckDTO;

/**
 * Default implementation of {@link AreaHitChecker}.
 */
public class AreaHitCheckerImpl implements AreaHitChecker
{

	/**
	 * This method check if the point hit area.
	 *
	 * @param data point and area data
	 * @return true if hit, false otherwise
	 */
	@Override
	public boolean check(PointCoordinatesCheckDTO data)
	{
//		(1) part
		if (data.x() >= 0 && data.y() >= 0)
			return (data.x() * data.x() + data.y() * data.y() <= data.r() * data.r());

//		(2) part
		if (data.x() <= 0 && data.y() >= 0)
			return (data.y() <= data.x() + data.r());

//		(3) part
		if (data.x() <= 0 && data.y() <= 0)
			return (data.x() >= -data.r() / 2 && data.y() >= -data.r());

		return false;
	}
}
