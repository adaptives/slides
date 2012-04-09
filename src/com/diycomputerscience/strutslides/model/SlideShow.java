package com.diycomputerscience.strutslides.model;

import java.util.List;

/**
 * @author pshah
 *
 */
public class SlideShow {
	
	private String title;
	private String createdBy;
	private Category categories;
	private List<Tag> tags;
	private List<Slide> slides;
	private String header;
	private String footer;
	private String styleClass;
	
	public SlideShow() {
		
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

	public Category getCategory() {
		return categories;
	}

	public void setCategory(Category categories) {
		this.categories = categories;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Slide> getSlides() {
		return slides;
	}

	public void setSlides(List<Slide> slides) {
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

}
