/**
 * 
 */
package com.diycomputerscience.slides.view.action;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.diycomputerscience.slides.Application;
import com.diycomputerscience.slides.model.Slide;
import com.diycomputerscience.slides.model.SlideShow;
import com.diycomputerscience.slides.service.SlideService;
import com.diycomputerscience.slides.view.dto.SlideShowTO;
import com.diycomputerscience.slides.view.dto.SlideTO;

/**
 * @author pshah
 *
 */
public class SlideShowAction extends Action {
	
	public static String TITLE = "title";
	public static String SLIDE = "slide";
	public static String SLIDE_SHOW = "slideShow";
	
	public ActionForward execute(ActionMapping mapping,
            					ActionForm form,
            					HttpServletRequest request,
            					HttpServletResponse response) throws Exception {
		
		Properties properties = new Properties();
		properties.setProperty (Context.INITIAL_CONTEXT_FACTORY,"org.apache.openejb.client.LocalInitialContextFactory");
		InitialContext initialContext = new InitialContext(properties);
		SlideService slideService = (SlideService)initialContext.lookup("SlideServiceLocalBean");
		
		String title = request.getParameter(TITLE);
		String slideTitle = request.getParameter(SLIDE);
		
		SlideShowTO slideShow = slideService.fetchSlideShowsByTitle(title);
		SlideTO slide = slideService.fetchSlide(slideTitle, slideShow);
		
		request.setAttribute(SLIDE_SHOW, slideShow);
		request.setAttribute(SLIDE, slide);
		
		return mapping.findForward("success");
	}
}
