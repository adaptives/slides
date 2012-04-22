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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * @author pshah
 *
 */
@Entity
@NamedQueries (
    {
        @NamedQuery(name = "getAllSlideShows", query = "Select s from SlideShow s"),
        @NamedQuery(name = "getSlideShowsByTitle", query = "Select s from SlideShow s where s.title = :title"),
        @NamedQuery(name = "getSlideShowsByCategory", query = "Select s from SlideShow s WHERE s.category.name = :category")
    }
)
public class SlideShow {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public int placement;
	public String title;
	public String createdBy;
	public String header;
	public String footer;
	public String styleClass;
	
	@ManyToOne(optional=false, cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	public Category category;

	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	public List<Tag> tags = new ArrayList<Tag>();

	@OneToMany(mappedBy="slideShow", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	public List<Slide> slides = new ArrayList<Slide>();

	public SlideShow() {

	}

}
