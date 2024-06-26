package com.smartHomeManagement.acme.analytics.domain.model.exceptions;

/**
 * MaxValueMustToBeGreaterThanMinValueException
 * <p>
 *     - This class represents the MaxValueMustToBeGreaterThanMinValueException exception.
 *     - It is thrown when the max value is less than the min value.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public class MaxValueMustToBeGreaterThanMinValueException extends RuntimeException{
    public MaxValueMustToBeGreaterThanMinValueException(String message){
        super(message);
    }
}
