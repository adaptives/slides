/**
 * 
 */
package com.diycomputerscience.slides.action;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.diycomputerscience.slides.Application;
import com.diycomputerscience.slides.model.Category;
import com.diycomputerscience.slides.model.SlideShow;
import com.diycomputerscience.slides.service.SlideService;

/**
 * @author pshah
 *
 */
public class Home extends Action {
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

		Properties properties = new Properties();
		properties.setProperty (Context.INITIAL_CONTEXT_FACTORY,"org.apache.openejb.client.LocalInitialContextFactory");
		InitialContext initialContext = new InitialContext(properties);
		SlideService slideService = (SlideService)initialContext.lookup("SlideServiceLocalBean");
		
		Map<Category, List<SlideShow>> slideShows = slideService.fetchSlideShowsByCategory();
		request.setAttribute("slideShows", slideShows);
		
		return mapping.findForward("success");
	}
}
