package com.smartHomeManagement.acme.inventory.domain.model.exceptions;

/**
 * SerialNameAlreadyExistsException class
 * <p>
 *     - This class extends RuntimeException to handle the exception when the serial name already exists.
 *     - This class is used to throw an exception when the serial name already exists.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public class SerialNameAlreadyExistsException extends RuntimeException{
    public SerialNameAlreadyExistsException(String message) {
        super(message);
    }
}
