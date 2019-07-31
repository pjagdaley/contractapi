package com.sundeus.file.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FileNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
    
    public FileNotFoundException( String resourceName) {
        super(String.format("%s not found ", resourceName));
        this.resourceName = resourceName;
        
    }

    public String getResourceName() {
        return resourceName;
    }   
}
