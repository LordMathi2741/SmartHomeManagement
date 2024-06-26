package com.smartHomeManagement.acme.analytics.domain.model.exceptions;

/**
 * PerformanceIndicatorWithThisTypeAlreadyExistsException
 * <p>
 *     - This class represents the PerformanceIndicatorWithThisTypeAlreadyExistsException exception.
 *     - It is thrown when a PerformanceIndicator with the same type already exists.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public class PerformanceIndicatorWithThisTypeAlreadyExistsException extends RuntimeException{
    public PerformanceIndicatorWithThisTypeAlreadyExistsException(String message){
        super(message);
    }
}
