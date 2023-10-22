package com.enzulode.exception;

/**
 * This exception type represents situation when the validation process not ended up successfully
 * because of validation target being null.
 *
 */
public class NullValidationTargetException extends ValidationException
{

	/**
	 * This constructor consumes an exception message.
	 *
	 * @param message exception message
	 */
	public NullValidationTargetException(String message)
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
	public NullValidationTargetException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
