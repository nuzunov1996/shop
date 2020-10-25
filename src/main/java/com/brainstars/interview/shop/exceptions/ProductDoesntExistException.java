package com.brainstars.interview.shop.exceptions;

public class ProductDoesntExistException extends RuntimeException{
    private static final long serialVersionUID = 7574321655476236911L;

    private static final String DEFAULT_MESSAGE = "The Product doesn't exist";

    public ProductDoesntExistException()
    {
        super(DEFAULT_MESSAGE);
    }


    public ProductDoesntExistException(String message)
    {
        super(message);
    }


    public ProductDoesntExistException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
