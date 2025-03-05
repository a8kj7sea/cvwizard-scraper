package me.a8kj.wizardscrapper.exception;

import lombok.Getter;

@Getter
public class RuntimeEventException extends RuntimeException implements ErrorException {

    private final Throwable cause;

    public RuntimeEventException(Throwable throwable) {
        super(throwable);
        this.cause = throwable;
    }

    public RuntimeEventException() {
        this.cause = null;
    }

    public RuntimeEventException(Throwable cause, String message) {
        super(message, cause);
        this.cause = cause;
    }

    public RuntimeEventException(String message) {
        super(message);
        this.cause = null;
    }

}
