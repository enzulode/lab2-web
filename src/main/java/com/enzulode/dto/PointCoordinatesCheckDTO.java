package com.enzulode.dto;

/**
 * Coordinates check DTO contains all the required information about point being checked and the area size.
 *
 * @param x point x-axis coordinate
 * @param y point y-axis coordinate
 * @param r area size
 */
public record PointCoordinatesCheckDTO(Integer x, Float y, Integer r)
{
}
