package com.diycomputerscience.slides.service;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.diycomputerscience.slides.Application;
import com.diycomputerscience.slides.model.Category;
import com.diycomputerscience.slides.model.Slide;
import com.diycomputerscience.slides.model.SlideShow;

@Stateless(mappedName="SlideService", name="SlideService")
public class SlideService {
	
	public Map<Category, List<SlideShow>> fetchSlideShowsByCategory() {
		Application app = Application.getInstance();
		return app.retreiveAllSlideShowsByCategory();
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
