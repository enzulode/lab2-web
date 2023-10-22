package com.enzulode.check;

import com.enzulode.dto.PointCoordinatesCheckDTO;

/**
 * Area hit checker contract.
 *
 */
public interface AreaHitChecker
{

	/**
	 * This method check if the point hit area.
	 *
	 * @param data point and area data
	 * @return true if hit, false otherwise
	 */
	boolean check(PointCoordinatesCheckDTO data);
}
