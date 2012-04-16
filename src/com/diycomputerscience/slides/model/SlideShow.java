package com.diycomputerscience.slides.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author pshah
 *
 */
@Entity
public class SlideShow {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public int placement;
	public String title;
	public String createdBy;
	public Category category;
	@OneToMany(cascade = {CascadeType.ALL})
	public List<Tag> tags;
    @OneToMany(cascade = {CascadeType.ALL})
	public List<Slide> slides;
	public String header;
	public String footer;
	public String styleClass;
	
	public SlideShow() {
		
	}

}
