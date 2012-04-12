package com.diycomputerscience.slides.service;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.diycomputerscience.slides.Application;
import com.diycomputerscience.slides.model.Category;
import com.diycomputerscience.slides.model.Slide;
import com.diycomputerscience.slides.model.SlideShow;
import com.diycomputerscience.slides.util.ModelTOConverter;
import com.diycomputerscience.slides.util.SlideShowPrintUtils;
import com.diycomputerscience.slides.view.dto.CategoryTO;
import com.diycomputerscience.slides.view.dto.SlideShowTO;

@Stateless(mappedName="SlideService", name="SlideService")
public class SlideService {
	
	public Map<CategoryTO, List<SlideShowTO>> fetchSlideShowsByCategory() {
		Application app = Application.getInstance();
		Map<Category, List<SlideShow>> slideShowsByCat =  app.retreiveAllSlideShowsByCategory();
		SlideShowPrintUtils.printSlideShowByCategory(slideShowsByCat);
		Map<CategoryTO, List<SlideShowTO>> slideShowsTOByCat = ModelTOConverter.convertSlideByCategory(slideShowsByCat); 
		return slideShowsTOByCat;
	}

	public SlideShow fetchSlideShow(long id) {
		return null;
	}

	public SlideShow fetchSlideShowsByTitle(String title) {
		Application app = Application.getInstance();
		return app.retreiveSlideShow(title);
	}
	
	public Slide fetchSlide(String title, SlideShow slideShow) {
		Application app = Application.getInstance();
		return app.retreiveSlide(title, slideShow);
	}

}
