/**
 * 
 */
package com.diycomputerscience.slides.service;

import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.diycomputerscience.slides.view.dto.CategoryTO;
import com.diycomputerscience.slides.view.dto.SlideShowTO;
import com.diycomputerscience.slides.view.dto.SlideTO;
/**
 * @author pshah
 *
 */
public class TestServiceFactory implements IServiceFactory {
	
	@Override
	public SlideService getSlideService() throws ServiceLookupException {
		//create slideshows by category
		Map<CategoryTO, List<SlideShowTO>> slideShowsTOByCat = new HashMap<CategoryTO, List<SlideShowTO>>();
		//create categories
		CategoryTO ejc = new CategoryTO();
		ejc.setName("Enterprise Java");
		ejc.setPlacement(1);
		CategoryTO jc = new CategoryTO();
		jc.setName("Java");
		jc.setPlacement(2);
		//create slideshows and slides
		SlideShowTO slideShow1 = new SlideShowTO();
		slideShow1.setId(1);
		slideShow1.setTitle("EJB");
		slideShow1.setCreatedBy("Parag");
		slideShow1.setFooter("");
		slideShow1.setHeader("");
		slideShow1.setStyleClass("");
		slideShow1.setCategories(ejc);
		SlideTO slide11 = new SlideTO();
		slide11.setId(1);
		slide11.setPlacement(0);
		slide11.setTitle("Agenda");
		slide11.setContents("Agenda for the ");
		SlideTO slide12 = new SlideTO();
		slide12.setId(2);
		slide12.setPlacement(1);
		slide12.setTitle("Introduction to EJB");
		slide12.setContents("This is the introduction to EJB's");
		List<SlideTO> slideShow11SlidesList = new ArrayList<SlideTO>();
		slideShow11SlidesList.add(slide11);
		slideShow11SlidesList.add(slide12);
		slideShow1.setSlides(slideShow11SlidesList);
		
		SlideShowTO slideShow2 = new SlideShowTO();
		slideShow2.setId(2);
		slideShow2.setTitle("Core Java");
		slideShow2.setCreatedBy("Kalpak");
		slideShow2.setFooter("");
		slideShow2.setHeader("");
		slideShow2.setStyleClass("");
		slideShow2.setCategories(jc);
		SlideTO slide21 = new SlideTO();
		slide21.setId(3);
		slide21.setPlacement(0);
		slide21.setTitle("Agenda");
		slide21.setContents("Agenda for the Effective Java course");
		SlideTO slide22 = new SlideTO();
		slide22.setId(4);
		slide22.setPlacement(1);
		slide22.setTitle("Introduction to Effective Java");
		slide22.setContents("This is the introduction to Effective Java");
		List<SlideTO> slideShow22SlidesList = new ArrayList<SlideTO>();
		slideShow22SlidesList.add(slide21);
		slideShow22SlidesList.add(slide22);
		slideShow2.setSlides(slideShow22SlidesList);
		
		List slideShowsInEjc = new ArrayList<SlideShowTO>();
		slideShowsInEjc.add(slideShow1);
		List slideShowsInJc = new ArrayList<SlideShowTO>();
		slideShowsInJc.add(slide21);
		slideShowsTOByCat.put(ejc, slideShowsInEjc);
		slideShowsTOByCat.put(jc, slideShowsInJc);
		
		SlideService mock = createMock(SlideService.class);
		expect(mock.fetchSlideShowsByCategory()).andReturn(slideShowsTOByCat);
		replay(mock);
		return mock;
	}

}
