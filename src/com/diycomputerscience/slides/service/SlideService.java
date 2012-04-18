package com.diycomputerscience.slides.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.diycomputerscience.slides.model.Category;
import com.diycomputerscience.slides.model.Slide;
import com.diycomputerscience.slides.model.SlideShow;
import com.diycomputerscience.slides.util.ModelTOConverter;
import com.diycomputerscience.slides.view.dto.CategoryTO;
import com.diycomputerscience.slides.view.dto.SlideShowTO;
import com.diycomputerscience.slides.view.dto.SlideTO;

@Stateless
public class SlideService {
    @PersistenceContext(unitName="entities", type=PersistenceContextType.TRANSACTION)
	private EntityManager em;

    public Map<CategoryTO, List<SlideShowTO>> fetchSlideShowsByCategory() {
        List<SlideShowTO> slideShows = fetchAllSlideShows();
        Map<CategoryTO, List<SlideShowTO>> slideShowsTOByCat = new HashMap<CategoryTO, List<SlideShowTO>>();
        for (SlideShowTO s : slideShows) {
            CategoryTO category = s.getCategories();
            List<SlideShowTO> catSlideShows = slideShowsTOByCat.get(category);
            if (catSlideShows == null) {
                catSlideShows = new LinkedList<SlideShowTO>();
                slideShowsTOByCat.put(category, catSlideShows);
            }

            catSlideShows.add(s);
        }
        return slideShowsTOByCat;
	}

    public List<SlideShowTO> fetchAllSlideShows() {
        TypedQuery<SlideShow> query = em.createQuery("Select s from SlideShow s", SlideShow.class);
        List<SlideShow> result = query.getResultList();
        List<SlideShowTO> slideShows = new ArrayList<SlideShowTO>();

        for (SlideShow s : result) {
            SlideShowTO slideShowTO = ModelTOConverter.convertSlideShow(s);
            slideShows.add(slideShowTO);
        }

        return slideShows;
    }

	public SlideShow fetchSlideShow(long id) {
		return em.find(SlideShow.class, id);
	}

	public SlideShowTO fetchSlideShowsByTitle(String title) {
	    TypedQuery<SlideShow> query = em.createQuery("Select ss from SlideShow ss where ss.title = '" + title + "'", SlideShow.class);
	    List<SlideShow> results = query.getResultList();
	    SlideShow slideShow = results.size() > 0 ? results.get(0) : null;
		SlideShowTO slideShowTO = slideShow != null ? ModelTOConverter.convertSlideShow(slideShow) : null;
		return slideShowTO;
	}

	public void persistSlideShow(SlideShow s) {
	    em.persist(s);
	    em.flush();
	}

	//TODO: This method must take the slideShw id
	public SlideTO fetchSlide(String title, SlideShowTO slideShow) {
		
		if(slideShow == null) {
			throw new NullPointerException("slideShow is null");
		}
		
		if(title == null) {
			return null;
		}
		
		SlideTO retVal = null;
		for(SlideTO slide : slideShow.getSlides()) {
			if(slide.getTitle().equals(title)) {
				retVal = slide;
				break;
			}
		}
		return retVal;
	}

	public void initDb() {
        Category ejc = new Category("Enterprise Java");
        ejc.placement = 1;
        em.persist(ejc);
        Category jc = new Category("Java");
        jc.placement = 2;
        em.persist(jc);

        SlideShow slideShow1 = new SlideShow();
        slideShow1.title = "Introduction to EJB";
        slideShow1.createdBy = "Parag";
        slideShow1.category = ejc;
        em.persist(slideShow1);
        Slide slide11 = new Slide();
        slide11.slideShow = slideShow1;
        slide11.title = "Agenda";
        slide11.contents = "Contents for the agenda";
        slideShow1.slides.add(slide11);
        Slide slide12 = new Slide();
        slide12.slideShow = slideShow1;
        slide12.title = "Summary";
        slide12.contents = "Contents for summary";
        slideShow1.slides.add(slide12);
        em.persist(slideShow1);

        SlideShow slideShow2 = new SlideShow();
        slideShow2.title = "Effective Java";
        slideShow2.createdBy = "Kalpak";
        slideShow2.category = jc;
        Slide slide21 = new Slide();
        slide21.slideShow = slideShow2;
        slide21.title = "Agenda";
        slide21.contents = "Agenda for the Effective Java session";
        slideShow2.slides.add(slide21);
        Slide slide22 = new Slide();
        slide22.slideShow = slideShow2;
        slide22.title = "Effective Equals and HashCode";
        slide22.contents = "Effective Equals and HashCode contents";
        slideShow2.slides.add(slide22);
        em.persist(slideShow2);
	}
}
