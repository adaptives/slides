/**
 * 
 */
package com.diycomputerscience.strutslides;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.diycomputerscience.strutslides.actionform.CategoryForm;
import com.diycomputerscience.strutslides.actionform.SlideForm;
import com.diycomputerscience.strutslides.actionform.SlideShowForm;
import com.diycomputerscience.strutslides.actionform.TagForm;
import com.diycomputerscience.strutslides.model.Category;
import com.diycomputerscience.strutslides.model.Slide;
import com.diycomputerscience.strutslides.model.SlideShow;
import com.diycomputerscience.strutslides.model.Tag;

/**
 * @author pshah
 *
 */
public class Application {
	
	private Map<String, Tag> tags;
	private Map<String, Category> categories;
	private Map<String, SlideShow> slideShows;
	
	private boolean populated;
	
	private static Application instance = new Application();
	
	
	private Application() {
		this.tags = new HashMap<String, Tag>();
		this.categories = new HashMap<String, Category>();
		this.slideShows = new HashMap<String, SlideShow>();
	}
	
	public static synchronized Application getInstance() {
		if(!instance.populated) {
			instance.populate();
			instance.populated = true;
		}
		return instance;
	}

	public void populate() {
		Category ejc = new Category("Enterprise Java");
		Category jc = new Category("Java");
		
		SlideShow slideShow1 = new SlideShow();
		slideShow1.setTitle("Introduction to EJB");
		slideShow1.setCreatedBy("Parag");
		slideShow1.setCategory(ejc);
		Slide slide11 = new Slide();
		slide11.setTitle("Agenda");
		slide11.setContents("Contents for the agenda");
		Slide slide12 = new Slide();
		slide12.setTitle("Summary");
		slide12.setContents("Contents for summary");
		List<Slide> slides1 = new ArrayList<Slide>();
		slides1.add(slide11);
		slides1.add(slide12);
		slideShow1.setSlides(slides1);
		this.slideShows.put(slideShow1.getTitle(), slideShow1);
		
		SlideShow slideShow2 = new SlideShow();
		slideShow2.setTitle("Effective Java");
		slideShow2.setCreatedBy("Anil");
		slideShow2.setCategory(jc);
		Slide slide21 = new Slide();
		slide21.setTitle("Agenda");
		slide21.setContents("Agenda for the Effective Java session");
		Slide slide22 = new Slide();
		slide22.setTitle("Effective Equals and HashCode");
		slide22.setContents("Effective Equals and HashCode contents");
		List<Slide> slides2 = new ArrayList<Slide>();
		slideShow2.setSlides(slides2);
		this.slideShows.put(slideShow2.getTitle(), slideShow2);
	}
	
	public void addSlideShow(SlideShow slideShow) {
		
	}
	
	public void deleteSlideShow(SlideShow slideShow) {
		
	}
	
	public SlideShow retreiveSlideShow(String title) {
		return this.slideShows.get(title);
	}
	
	public List<SlideShow> retreiveAllSlideShows() {
		return new ArrayList<SlideShow>(this.slideShows.values());
	}
	
	public Map<Category, List<SlideShow>> retreiveAllSlideShowsByCategory() {
		//TODO: Make this a TreeMap
		Map<Category, List<SlideShow>> retVal = new HashMap<Category, List<SlideShow>>();
		Collection<SlideShow> allSlideShows = this.slideShows.values();
		for(SlideShow slideShow : allSlideShows) {
			List<SlideShow> alreadyExists = retVal.get(slideShow.getCategory());
			if(alreadyExists != null) {
				alreadyExists.add(slideShow);
			} else {
				alreadyExists = new ArrayList<SlideShow>();
				alreadyExists.add(slideShow);
				retVal.put(slideShow.getCategory(), alreadyExists);
			}
		}
		return retVal;
	}
	
	public void addSlide(String title, Slide slide) {
		
	}
	
	public void deleteSlide(String title, Slide slide) {
		
	}
	
	public Slide retreiveSlide(String title, SlideShow slideShow) {
		Slide retVal = null;
		for(Slide slide : slideShow.getSlides()) {
			if(slide.getTitle().equals(title)) {
				retVal = slide;
				break;
			}
		}
		return retVal;
	}
	
	public void addCategory(CategoryForm category) {
		
	}
	
	public void deleteCategory(String category) {
		
	}
	
	public CategoryForm retreiveCategory(String name) {
		return null;
	}
	
	public void addTag(TagForm tag) {
		
	}
	
	public void deleteTag(String name) {
		
	}
	
	public TagForm retreiveTag(String name) {
		return null;
	}
}
