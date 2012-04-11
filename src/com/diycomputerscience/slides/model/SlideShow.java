package com.diycomputerscience.slides.model;

import java.util.List;

/**
 * @author pshah
 *
 */
public class SlideShow {
	
	public long id;
	public String title;
	public String createdBy;
	public Category categories;
	public List<Tag> tags;
	public List<Slide> slides;
	public String header;
	public String footer;
	public String styleClass;
	
	public SlideShow() {
		
	}

}
