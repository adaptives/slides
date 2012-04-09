/**
 * 
 */
package com.diycomputerscience.slides.actionform;

import org.apache.struts.action.ActionForm;

/**
 * @author pshah
 *
 */
public class CategoryForm extends ActionForm {
	
	private String name;
	
	public CategoryForm() {
		
	}
	
	public CategoryForm(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
