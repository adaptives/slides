/**
 * 
 */
package com.diycomputerscience.slides.view.dto;

import com.diycomputerscience.slides.model.Category;



/**
 * @author pshah
 *
 */
public class CategoryTO implements Comparable {
	
	private long id;
	private String name;
	private int placement;
	
	public CategoryTO() {
		
	}
	
	public CategoryTO(Category category) {
		this.id = category.id;
		this.name = category.name;
		this.placement = category.placement;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlacement() {
		return placement;
	}

	public void setPlacement(int placement) {
		this.placement = placement;
	}

	@Override
	public int compareTo(Object arg0) {
		CategoryTO other = (CategoryTO)arg0;
		return this.placement - other.placement; 
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
