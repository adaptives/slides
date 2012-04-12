/**
 * 
 */
package com.diycomputerscience.slides;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.diycomputerscience.slides.model.Category;
import com.diycomputerscience.slides.model.Slide;
import com.diycomputerscience.slides.model.SlideShow;
import com.diycomputerscience.slides.model.Tag;
import com.diycomputerscience.slides.view.actionform.CategoryForm;
import com.diycomputerscience.slides.view.actionform.SlideForm;
import com.diycomputerscience.slides.view.actionform.SlideShowForm;
import com.diycomputerscience.slides.view.actionform.TagForm;

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
		ejc.placement = 1;
		Category jc = new Category("Java");
		jc.placement = 2;
		
		SlideShow slideShow1 = new SlideShow();
		slideShow1.title = "Introduction to EJB";
		slideShow1.createdBy = "Parag";
		slideShow1.categories = ejc;
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
		this.slideShows.put(slideShow1.title, slideShow1);
		
		SlideShow slideShow2 = new SlideShow();
		slideShow2.title = "Effective Java";
		slideShow2.createdBy = "Kalpak";
		slideShow2.categories = jc;
		Slide slide21 = new Slide();
		slide21.title = "Agenda";
		slide21.contents = "Agenda for the Effective Java session";
		Slide slide22 = new Slide();
		slide22.title = "Effective Equals and HashCode";
		slide22.contents = "Effective Equals and HashCode contents";
		List<Slide> slides2 = new ArrayList<Slide>();
		slideShow2.slides = slides2;
		this.slideShows.put(slideShow2.title, slideShow2);
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
			List<SlideShow> alreadyExists = retVal.get(slideShow.categories);
			if(alreadyExists != null) {
				alreadyExists.add(slideShow);
			} else {
				alreadyExists = new ArrayList<SlideShow>();
				alreadyExists.add(slideShow);
				retVal.put(slideShow.categories, alreadyExists);
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
		for(Slide slide : slideShow.slides) {
			if(slide.title.equals(title)) {
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
