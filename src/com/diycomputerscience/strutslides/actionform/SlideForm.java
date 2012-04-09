package com.diycomputerscience.strutslides.actionform;

import org.apache.struts.action.ActionForm;

public class SlideForm extends ActionForm {

	private String title;
	private String contents;
	private int placement;
	
	public SlideForm() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getPlacement() {
		return placement;
	}

	public void setPlacement(int placement) {
		this.placement = placement;
	}
	
}
