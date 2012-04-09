/**
 * 
 */
package com.diycomputerscience.strutslides.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.diycomputerscience.strutslides.Application;
import com.diycomputerscience.strutslides.model.Category;
import com.diycomputerscience.strutslides.model.SlideShow;

/**
 * @author pshah
 *
 */
public class Home extends Action {
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		
		Application app = Application.getInstance();
		Map<Category, List<SlideShow>> slideShows = app.retreiveAllSlideShowsByCategory();
		request.setAttribute("slideShows", slideShows);
		return mapping.findForward("success");
	}
}
