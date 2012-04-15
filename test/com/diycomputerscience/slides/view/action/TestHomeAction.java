package com.diycomputerscience.slides.view.action;

import java.util.List;
import java.util.Map;

import org.apache.struts.action.RequestProcessor;

import com.diycomputerscience.slides.view.dto.CategoryTO;
import com.diycomputerscience.slides.view.dto.SlideShowTO;

import servletunit.HttpServletRequestSimulator;
import servletunit.struts.MockStrutsTestCase;



public class TestHomeAction extends MockStrutsTestCase {

	public TestHomeAction(String testName) {
		super(testName);
		// TODO Auto-generated constructor stub
	}

	public void setUp() throws Exception {
		super.setUp();
	}

	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testHomePage() throws Exception {
		setRequestPathInfo("/homepage");
		actionPerform();
		verifyForward("success");
		verifyNoActionErrors();
		verifyNoActionMessages();
		Map<CategoryTO, List<SlideShowTO>> slideShows = (Map<CategoryTO, List<SlideShowTO>>)getRequest().getAttribute(HomeAction.SLIDE_SHOWS);
		assertNotNull(slideShows);
		assertEquals(2, slideShows.keySet().size());
	}

}
