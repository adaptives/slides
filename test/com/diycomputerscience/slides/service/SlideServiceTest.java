/**
 * 
 */
package com.diycomputerscience.slides.service;

import java.util.List;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;

import com.diycomputerscience.slides.model.Category;
import com.diycomputerscience.slides.model.SlideShow;

import junit.framework.TestCase;

/**
 * @author pshah
 *
 */
public class SlideServiceTest extends TestCase {

	private SlideService slideService;
	
	/**
	 * @param name
	 */
	public SlideServiceTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		EJBContainer ejbContainer = EJBContainer.createEJBContainer();
		Object oSlideService = ejbContainer.getContext().lookup("java:global/slides/SlideService");
		assertNotNull(oSlideService);
		this.slideService = (SlideService)oSlideService;
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testFetchSlideShowsBycategory() {
		Map<Category, List<SlideShow>> slideShowsByCategory = this.slideService.fetchSlideShowsByCategory();
		assertNotNull(slideShowsByCategory);
	}

}
