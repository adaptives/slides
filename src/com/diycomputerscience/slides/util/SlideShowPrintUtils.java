/**
 * 
 */
package com.diycomputerscience.slides.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.diycomputerscience.slides.model.Category;
import com.diycomputerscience.slides.model.SlideShow;
import com.diycomputerscience.slides.view.dto.CategoryTO;
import com.diycomputerscience.slides.view.dto.SlideShowTO;

/**
 * @author pshah
 *
 */
public class SlideShowPrintUtils {
	public static void printSlideShowTOByCategory(Map<CategoryTO, List<SlideShowTO>> slideShowsByCat) {
		System.out.println("Printing slideShowsByCategory - TO's");
		Set<CategoryTO> categories = slideShowsByCat.keySet();
		for(CategoryTO category : categories) {
			System.out.println("Category - " + category.getName() );
			List<SlideShowTO> slideShows = slideShowsByCat.get(category);
			for(SlideShowTO slideShow : slideShows) {
				System.out.println("  " + slideShow.getTitle());
			}
		}
	}
	
	public static void printSlideShowByCategory(Map<Category, List<SlideShow>> slideShowsByCat) {
		System.out.println("Printing slideShowsByCategory");
		Set<Category> categories = slideShowsByCat.keySet();
		for(Category category : categories) {
			System.out.println("Category - " + category.name );
			List<SlideShow> slideShows = slideShowsByCat.get(category);
			for(SlideShow slideShow : slideShows) {
				System.out.println("  " + slideShow.title);
			}
		}
	}
}
