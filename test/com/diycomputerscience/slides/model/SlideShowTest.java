package com.diycomputerscience.slides.model;

import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import junit.framework.TestCase;

public final class SlideShowTest extends AbstractEntityTest {

    public void testSlideShowPersist() throws Exception {
        SlideShow s = new SlideShow();

        Slide slide1 = new Slide();
        slide1.title = "Slide 1";
        slide1.contents = "Slide 1 Contents";
        slide1.placement = 10;
        slide1.slideShow = s;

        Slide slide2 = new Slide();
        slide2.title = "Slide 2";
        slide2.contents = "Slide 2 Contents";
        slide2.placement = 20;
        slide2.slideShow = s;

        Tag tag1 = new Tag();
        tag1.name = "Tag 1";
        Tag tag2 = new Tag();
        tag2.name = "Tag 2";

        Category category = new Category();
        category.name = "Category";
        category.placement = 50;
        category.slideShows = Arrays.asList( new SlideShow[] {s});
        
        s.title = "Test Slide Show";

        s.slides.add(slide1);
        s.slides.add(slide2);

        s.tags.add(tag1);
        s.tags.add(tag2);

        s.category = category;
        s.header = "Header";
        s.footer = "Footer";
        s.createdBy = "Creator";
        s.styleClass = "Style";
        s.placement = 100;

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(s);
        em.flush();
        tx.commit();

        TypedQuery<SlideShow> query = em.createQuery("Select s from SlideShow s", SlideShow.class);

        assertEquals(1, query.getResultList().size());
        
        SlideShow found = query.getSingleResult();
        assertEquals(found.title, "Test Slide Show");
        assertEquals(found.header, "Header");
        assertEquals(found.footer, "Footer");
        assertEquals(found.createdBy, "Creator");
        assertEquals(found.styleClass, "Style");
        assertEquals(found.placement, 100);

        assertNotNull(found.slides);
        assertEquals(2, found.slides.size());

        Slide slideFound = found.slides.get(0);
        assertEquals(slideFound.title, "Slide 1");
        assertEquals(slideFound.contents, "Slide 1 Contents");
        assertEquals(slideFound.placement, 10);

        slideFound = found.slides.get(1);
        assertEquals(slideFound.title, "Slide 2");
        assertEquals(slideFound.contents, "Slide 2 Contents");
        assertEquals(slideFound.placement, 20);

        assertNotNull(found.category);
        assertEquals(found.category.name, "Category");
        assertEquals(found.category.placement, 50);

        assertNotNull(found.tags);
        assertEquals(2, found.tags.size());
        assertEquals("Tag 1", found.tags.get(0).name);
        assertEquals("Tag 2", found.tags.get(1).name);

        tx = em.getTransaction();
        tx.begin();
        em.remove(found);
        em.flush();
        tx.commit();

        query = em.createQuery("Select s from SlideShow s", SlideShow.class);
        assertEquals(0, query.getResultList().size());
    }
}
