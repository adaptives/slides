package com.diycomputerscience.slides.view.action;

import java.util.List;
import java.util.Map;

import servletunit.struts.MockStrutsTestCase;

import com.diycomputerscience.slides.view.dto.CategoryTO;
import com.diycomputerscience.slides.view.dto.SlideShowTO;
import com.diycomputerscience.slides.view.dto.SlideTO;

public class TestSlideShowAction extends MockStrutsTestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSlideShowAction() throws Exception {
		String slideShowTitle = "Introduction to EJB";
		String slideTitle = "Summary";
		
		setRequestPathInfo("/slideShow");
		addRequestParameter(SlideShowAction.TITLE, slideShowTitle);
		addRequestParameter(SlideShowAction.SLIDE, slideTitle);
//		actionPerform();
//		
//		verifyForward("success");
//		verifyNoActionErrors();
//		verifyNoActionMessages();
//		SlideShowTO slideShow = (SlideShowTO)getRequest().getAttribute(SlideShowAction.SLIDE_SHOW);
//		SlideTO slide = (SlideTO)getRequest().getAttribute(SlideShowAction.SLIDE);
//		assertNotNull(slideShow);
//		assertEquals(slideShowTitle, slideShow.getTitle());
//		assertNotNull(slide);
//		assertEquals(slideTitle, slide.getTitle());
	}

}
