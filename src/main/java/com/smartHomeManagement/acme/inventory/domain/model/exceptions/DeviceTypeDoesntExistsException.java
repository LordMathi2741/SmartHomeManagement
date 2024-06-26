package com.smartHomeManagement.acme.inventory.domain.model.exceptions;

/**
 * StatusDoesntExistsException class
 * <p>
 *     - This class is a custom exception that extends RuntimeException.
 *     - This class is used to throw an exception when a status doesn't exist in the database.
 * </p>
 * @author U202212721 Mathias Jave Diaz
 * @version 1.0
 */
public class DeviceTypeDoesntExistsException extends RuntimeException{
    public DeviceTypeDoesntExistsException(String message) {
        super(message);
    }
}
