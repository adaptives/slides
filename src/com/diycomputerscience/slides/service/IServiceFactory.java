package com.diycomputerscience.slides.service;

public interface IServiceFactory {
	
	public SlideService getSlideService()  throws ServiceLookupException;
	
}
