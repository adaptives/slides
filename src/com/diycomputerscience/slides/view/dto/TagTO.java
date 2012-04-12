/**
 * 
 */
package com.diycomputerscience.slides.view.dto;

import com.diycomputerscience.slides.model.Tag;


/**
 * @author pshah
 *
 */
public class TagTO {
	
	private String name;
	
	public TagTO() {
		
	}
	
	public TagTO(Tag tag) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
