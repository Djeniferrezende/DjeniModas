package com.djeniModas.Modas.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id){
        super("Resource not foound" + id);
    }

}
