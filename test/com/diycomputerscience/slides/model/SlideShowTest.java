package com.diycomputerscience.slides.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

public final class SlideShowTest extends TestCase {
    public EntityManager em;
    
    @Override
    protected void setUp() throws Exception {
        final Properties p = new Properties();
        p.put("myds", "new://Resource?type=DataSource");
        p.put("myds.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("myds.JdbcUrl", "jdbc:hsqldb:mem:slidesdb");

        p.put("openjpa.Id", "entities");
        p.put("openjpa.ConnectionURL", "jdbc:hsqldb:mem:slidedb");
        p.put("openjpa.ConnectionDriverName", "org.hsqldb.jdbcDriver");
        p.put("openjpa.ConnectionUserName", "sa");
        p.put("openjpa.ConnectionPassword", "");

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("entities", p);
        em = emFactory.createEntityManager();
    }


    @Override
    protected void tearDown() throws Exception {
        em.clear();
        em.close();
    }


    public void testSlideShowBean() throws Exception {
        Slide slide1 = new Slide();
        slide1.title = "Slide 1";
        slide1.contents = "Slide 1 Contents";
        slide1.placement = 10;
        Slide slide2 = new Slide();
        slide2.title = "Slide 2";
        slide2.contents = "Slide 2 Contents";
        slide2.placement = 20;
        List<Slide> slides = new ArrayList<Slide>();
        slides.add(slide1);
        slides.add(slide2);

        Tag tag1 = new Tag();
        tag1.name = "Tag 1";
        Tag tag2 = new Tag();
        tag2.name = "Tag 2";
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tag1);
        tags.add(tag2);

        Category category = new Category();
        category.name = "Category";
        category.placement = 50;

        SlideShow s = new SlideShow();
        s.title = "Test Slide Show";
        s.slides = slides;
        s.tags = tags;
        s.category = category;
        s.header = "Header";
        s.footer = "Footer";
        s.createdBy = "Creator";
        s.styleClass = "Style";
        s.placement = 100;

        em.persist(s);
    }
}
