/**
 * 
 */
package com.diycomputerscience.slides.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.diycomputerscience.slides.Application;
import com.diycomputerscience.slides.model.Slide;
import com.diycomputerscience.slides.model.SlideShow;

/**
 * @author pshah
 *
 */
public class SlideShowAction extends Action {
	public ActionForward execute(ActionMapping mapping,
            					ActionForm form,
            					HttpServletRequest request,
            					HttpServletResponse response) throws Exception {
		
		Application app = Application.getInstance();
		
		String title = request.getParameter("title");
		String slideTitle = request.getParameter("slide");
		
		SlideShow slideShow = app.retreiveSlideShow(title);
		Slide slide = app.retreiveSlide(slideTitle, slideShow);
		request.setAttribute("slideShow", slideShow);
		request.setAttribute("slide", slide);
		
		return mapping.findForward("success");
	}
}
