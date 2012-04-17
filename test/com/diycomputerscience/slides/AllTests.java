package com.diycomputerscience.slides;

import com.diycomputerscience.slides.service.SlideServiceTest;
import com.diycomputerscience.slides.util.ModelTOConverterTest;
import com.diycomputerscience.slides.view.action.TestHomeAction;
import com.diycomputerscience.slides.view.action.TestSlideShowAction;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(SlideServiceTest.class);
		suite.addTestSuite(ModelTOConverterTest.class);
		suite.addTestSuite(TestHomeAction.class);
		suite.addTestSuite(TestSlideShowAction.class);
		//$JUnit-END$
		return suite;
	}

}
