package com.enzulode.exception;

/**
 * This exception type represents situation when the validation process not ended up successfully
 * because of inappropriate point coordinates.
 *
 */
public class InvalidPointCoordinatesException extends ValidationException
{

	/**
	 * This constructor consumes an exception message.
	 *
	 * @param message exception message
	 */
	public InvalidPointCoordinatesException(String message)
	{
		super(message);
	}

	/**
	 * This constructor consumes not only the exception message. It also consumes the reason why the
	 * {@link ValidationException} exception appeared.
	 *
	 * @param message exception message
	 * @param cause   the exception was caused by
	 */
	public InvalidPointCoordinatesException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
