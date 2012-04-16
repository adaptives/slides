package com.diycomputerscience.slides.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Slide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String title;
	public String contents;
	public int placement;
	
	public Slide() {
		
	}	
}
