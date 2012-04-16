/**
 * 
 */
package com.diycomputerscience.slides.service;

/**
 * @author pshah
 *
 */
public class ServiceLookupException extends Exception {
	
	public ServiceLookupException() {
		
	}
	
	public ServiceLookupException(String msg) {
		super(msg);
	}
	
	public ServiceLookupException(Throwable cause) {
		super(cause);
	}
	
	public ServiceLookupException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
