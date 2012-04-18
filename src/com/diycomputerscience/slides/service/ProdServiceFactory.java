/**
 * 
 */
package com.diycomputerscience.slides.service;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author pshah
 *
 */
public class ProdServiceFactory implements IServiceFactory {

	@Override
	public SlideService getSlideService() throws ServiceLookupException {
		
		try {
			String jndiName = "java:module/SlideService";
			return (SlideService)new InitialContext().lookup(jndiName);
		} catch (NamingException e) {
			String msg = "Could not get SlideService bean";
			throw new ServiceLookupException(msg, e);
		}
	}

}
