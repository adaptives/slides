package com.diycomputerscience.slides.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServiceFactoryProvider {
	
	public static IServiceFactory getServiceFactory() throws ServiceLookupException {
		IServiceFactory serviceFactory = null;
		try {
			Properties serviceProviders = new Properties();
			InputStream is = ServiceFactoryProvider.class.getClassLoader().getResourceAsStream("ServiceProviders.properties");
			if(is == null) {
				throw new NullPointerException("Could not locate ServiceProviders.properties");
			}
			serviceProviders.load(is);
			String serviceFactoryImplClassName = 
							serviceProviders.getProperty("IServiceFactory");
			serviceFactory = (IServiceFactory)Class.forName(serviceFactoryImplClassName).newInstance();
		} catch(IOException ioe) {
			String msg = "Could not get IServiceFactory";
			throw new ServiceLookupException(msg, ioe);
		} catch (InstantiationException e) {
			String msg = "Could not get IServiceFactory";
			throw new ServiceLookupException(msg, e);
		} catch (IllegalAccessException e) {
			String msg = "Could not get IServiceFactory";
			throw new ServiceLookupException(msg, e);
		} catch (ClassNotFoundException e) {
			String msg = "Could not get IServiceFactory";
			throw new ServiceLookupException(msg, e);
		}
		return serviceFactory;
	}
}
