package com.brainstars.interview.shop.exceptions;

public class InsufficientQuantityException extends RuntimeException{
    private static final long serialVersionUID = -1714844894186209843L;

    private static final String DEFAULT_MESSAGE = "Not enough quantity of the product";

    public InsufficientQuantityException()
    {
        super(DEFAULT_MESSAGE);
    }


    public InsufficientQuantityException(String message)
    {
        super(message);
    }


    public InsufficientQuantityException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
