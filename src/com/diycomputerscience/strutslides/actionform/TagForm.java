/**
 * 
 */
package com.diycomputerscience.strutslides.actionform;

import org.apache.struts.action.ActionForm;

/**
 * @author pshah
 *
 */
public class TagForm extends ActionForm {
	
	private String name;
	
	public TagForm() {
		
	}
	
	public TagForm(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
