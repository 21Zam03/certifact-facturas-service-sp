package com.certicom.certifact_facturas_service_sp.exceptions;

public class ServiceException extends RuntimeException {
    private final String errorCode;

    public ServiceException(String message) {
        super(message);
        this.errorCode = null;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = null;
    }

    public ServiceException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
