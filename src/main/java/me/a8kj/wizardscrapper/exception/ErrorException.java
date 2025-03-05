package me.a8kj.wizardscrapper.exception;

public interface ErrorException {

    Throwable getCause();

    String getMessage();
}

