/**
 * 
 */
package com.diycomputerscience.slides.view.action;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.diycomputerscience.slides.service.SlideService;
import com.diycomputerscience.slides.util.SlideShowPrintUtils;
import com.diycomputerscience.slides.view.dto.CategoryTO;
import com.diycomputerscience.slides.view.dto.SlideShowTO;

/**
 * @author pshah
 *
 */
public class HomeAction extends Action {
	
	public static String SLIDE_SHOWS = "slideShows";
	
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

		SlideService slideService = (SlideService)new InitialContext().lookup("java:module/SlideService");
		
		Map<CategoryTO, List<SlideShowTO>> slideShows = slideService.fetchSlideShowsByCategory();
		request.setAttribute(SLIDE_SHOWS, slideShows);
		
		return mapping.findForward("success");
	}
}
