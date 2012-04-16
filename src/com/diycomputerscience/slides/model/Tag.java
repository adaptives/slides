/**
 * 
 */
package com.diycomputerscience.slides.model;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * @author pshah
 *
 */
@Entity
public class Tag {

    @Id
	public String name;
	
	public Tag() {
		
	}	
}
