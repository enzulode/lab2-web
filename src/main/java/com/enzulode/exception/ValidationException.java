package com.enzulode.exception;

/**
 * This exception supertype represents situation when the validation process not ended up successfully.
 *
 */
public abstract class ValidationException extends Exception
{

	/**
	 * This constructor consumes an exception message.
	 *
	 * @param message exception message
	 */
	public ValidationException(String message)
	{
		super(message);
	}

	/**
	 * This constructor consumes not only the exception message. It also consumes the reason why the
	 * {@link ValidationException} exception appeared.
	 *
	 * @param message exception message
	 * @param cause the exception was caused by
	 */
	public ValidationException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
