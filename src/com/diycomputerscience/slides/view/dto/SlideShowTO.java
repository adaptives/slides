package com.diycomputerscience.slides.view.dto;

import java.util.ArrayList;
import java.util.List;

import com.diycomputerscience.slides.model.Slide;
import com.diycomputerscience.slides.model.SlideShow;
import com.diycomputerscience.slides.model.Tag;

/**
 * @author pshah
 *
 */
public class SlideShowTO implements Comparable {
	
	private long id;
	private int placement;
	private String title;
	private String createdBy;
	private CategoryTO category;
	private List<TagTO> tags;
	private List<SlideTO> slides;
	private String header;
	private String footer;
	private String styleClass;
	
	public SlideShowTO() {
		
	}
	
	public SlideShowTO(SlideShow slideShow) {
		this.id = slideShow.id;
		this.placement = slideShow.placement;
		this.title = slideShow.title;
		this.createdBy = slideShow.createdBy;
		this.category = new CategoryTO(slideShow.category);
		//tags
		this.tags = new ArrayList<TagTO>();
		if(slideShow.tags != null) {
			for(Tag tag : slideShow.tags) {
				TagTO tagTo = new TagTO(tag);
				this.tags.add(tagTo);
			}
		}
	
		//slides
		this.slides = new ArrayList<SlideTO>();
		if(slideShow.slides != null) {
			for(Slide slide : slideShow.slides) {
				SlideTO slideTo = new SlideTO(slide);
				this.slides.add(slideTo);
			}
		}
		
		this.header = slideShow.header;
		this.footer = slideShow.footer;
		this.styleClass = slideShow.styleClass;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPlacement() {
		return placement;
	}

	public void setPlacement(int placement) {
		this.placement = placement;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public CategoryTO getCategories() {
		return category;
	}

	public void setCategories(CategoryTO categories) {
		this.category = categories;
	}

	public List<TagTO> getTags() {
		return tags;
	}

	public void setTags(List<TagTO> tags) {
		this.tags = tags;
	}

	public List<SlideTO> getSlides() {
		return slides;
	}

	public void setSlides(List<SlideTO> slides) {
		this.slides = slides;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	@Override
	public int compareTo(Object o) {
		SlideShowTO other = (SlideShowTO)o;
		return this.placement - other.placement;
	}

}
