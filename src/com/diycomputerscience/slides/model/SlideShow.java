package com.diycomputerscience.slides.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	@ManyToOne(optional=false)
	public Category category;
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	public List<Tag> tags = new ArrayList<Tag>();
    @OneToMany(mappedBy="slideShow", cascade = {CascadeType.ALL})
	public List<Slide> slides = new ArrayList<Slide>();
	public String header;
	public String footer;
	public String styleClass;
	
	public SlideShow() {
		//this.tags = new ArrayList<Tag>();
		//this.slides = new ArrayList<Slide>();
	}

}
