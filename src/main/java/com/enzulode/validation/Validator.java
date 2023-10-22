package com.enzulode.validation;

import com.enzulode.exception.ValidationException;

/**
 * This interface represents specific validator contract.
 *
 * @param <T> validating type
 */
public interface Validator<T>
{

	/**
	 * This method performs validation.
	 *
	 * @param obj an object being checked
	 * @throws ValidationException if validation process not ended up successfully
	 */
	void validate(T obj) throws ValidationException;
}
