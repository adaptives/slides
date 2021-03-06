/**
 * 
 */
package com.diycomputerscience.slides.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.diycomputerscience.slides.model.Category;
import com.diycomputerscience.slides.model.Slide;
import com.diycomputerscience.slides.model.SlideShow;
import com.diycomputerscience.slides.view.dto.CategoryTO;
import com.diycomputerscience.slides.view.dto.SlideShowTO;

/**
 * @author pshah
 *
 */
public class ModelTOConverterTest extends TestCase {

	private Category ejc = new Category("Enterprise Java");
	private Category jc = new Category("Java");
	private Map<Category, List<SlideShow>> slideShows;
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.slideShows = new HashMap<Category, List<SlideShow>>();
		
		ejc.placement = 1;
		jc.placement = 2;
		
		SlideShow slideShow1 = new SlideShow();
		slideShow1.title = "Introduction to EJB";
		slideShow1.createdBy = "Parag";
		slideShow1.category = ejc;
		Slide slide11 = new Slide();
		slide11.title = "Agenda";
		slide11.contents = "Contents for the agenda";
		Slide slide12 = new Slide();
		slide12.title = "Summary";
		slide12.contents = "Contents for summary";
		List<Slide> slides1 = new ArrayList<Slide>();
		slides1.add(slide11);
		slides1.add(slide12);
		slideShow1.slides = slides1;
		List<SlideShow> slideShowsInCatEjc = new ArrayList<SlideShow>();
		slideShowsInCatEjc.add(slideShow1);
		this.slideShows.put(slideShow1.category, slideShowsInCatEjc);
		
		SlideShow slideShow2 = new SlideShow();
		slideShow2.title = "Effective Java";
		slideShow2.createdBy = "Kalpak";
		slideShow2.category = jc;
		Slide slide21 = new Slide();
		slide21.title = "Agenda";
		slide21.contents = "Agenda for the Effective Java session";
		Slide slide22 = new Slide();
		slide22.title = "Effective Equals and HashCode";
		slide22.contents = "Effective Equals and HashCode contents";
		List<Slide> slides2 = new ArrayList<Slide>();
		slideShow2.slides = slides2;
		List<SlideShow> slideShowsInCatJava = new ArrayList<SlideShow>();
		slideShowsInCatJava.add(slideShow2);
		this.slideShows.put(slideShow2.category, slideShowsInCatJava);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testConvertSlideByCategory() throws Exception {
		Map<CategoryTO, List<SlideShowTO>> slideShowsByCatTO = ModelTOConverter.convertSlideShowsByCategory(this.slideShows);
		assertEquals(2, slideShowsByCatTO.keySet().size());
		for(CategoryTO category : slideShowsByCatTO.keySet()) {
			List<SlideShowTO> slideShowsInCat = slideShowsByCatTO.get(category);
			if(category.getName().equals("Enterprise Java")) {
				assertEquals(1, slideShowsInCat.size());
				SlideShowTO slideShowTo = slideShowsInCat.get(0);
				assertEquals("Introduction to EJB", slideShowTo.getTitle());
			} else if(category.getName().equals("Java")) {
				assertEquals(1, slideShowsInCat.size());
				SlideShowTO slideShowTo = slideShowsInCat.get(0);
				assertEquals("Effective Java", slideShowTo.getTitle());
			} else {
				fail("Unknown category");
			}
		}
	}
	
	public void testConvertSlideShow() throws Exception {
		List<SlideShow> slideShows = this.slideShows.get(this.ejc);
		SlideShow ejcSlideShow = slideShows.get(0);
		//it's our data but just making sure
		assertNotNull(ejcSlideShow);
		SlideShowTO ejcSlideShowTO = ModelTOConverter.convertSlideShow(ejcSlideShow);
		
		assertEquals(ejcSlideShow.createdBy, ejcSlideShowTO.getCreatedBy());
		assertEquals(ejcSlideShow.footer, ejcSlideShowTO.getFooter());
		assertEquals(ejcSlideShow.header, ejcSlideShowTO.getHeader());
		assertEquals(ejcSlideShow.id, ejcSlideShowTO.getId());
		assertEquals(ejcSlideShow.placement, ejcSlideShowTO.getPlacement());
		assertEquals(ejcSlideShow.styleClass, ejcSlideShowTO.getStyleClass());
		assertEquals(ejcSlideShow.title, ejcSlideShowTO.getTitle());
		assertEquals(ejcSlideShow.slides.size(), ejcSlideShowTO.getSlides().size());
	}
	
}
