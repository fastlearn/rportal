package com.renguangli.rportal.shiro;

import org.apache.shiro.authc.AuthenticationException;

public class ValidateCodeException extends AuthenticationException {

    /**
     * Creates a new ValidateCodeException.
     */
    public ValidateCodeException() {
        super();
    }

    /**
     * Constructs a new ValidateCodeException.
     *
     * @param message the reason for the exception
     */
    public ValidateCodeException(String message) {
        super(message);
    }

    /**
     * Constructs a new ValidateCodeException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public ValidateCodeException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new ValidateCodeException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public ValidateCodeException(String message, Throwable cause) {
        super(message, cause);
    }

}
