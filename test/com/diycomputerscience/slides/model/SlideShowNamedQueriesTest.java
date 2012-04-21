package com.diycomputerscience.slides.model;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public final class SlideShowNamedQueriesTest extends AbstractEntityTest {
    public void testNamedQueries() throws Exception {
        Category java = new Category();
        java.name = "Java";

        Category javaee = new Category();
        javaee.name = "Java EE";

        SlideShow java1 = new SlideShow();
        java1.title = "Java Presentation 1";
        java1.category = java;
        java1.createdBy = "Kalpak";

        SlideShow java2 = new SlideShow();
        java2.title = "Java Presentation 2";
        java2.category = java;
        java2.createdBy = "Kalpak";

        SlideShow javaee1 = new SlideShow();
        javaee1.title = "Java EE Presentation 1";
        javaee1.category = javaee;
        javaee1.createdBy = "Kalpak";

        SlideShow javaee2 = new SlideShow();
        javaee2.title = "Java EE Presentation 2";
        javaee2.category = javaee;
        javaee2.createdBy = "Kalpak";

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(java);
        em.persist(javaee);
        em.flush();
        tx.commit();

        tx = em.getTransaction();
        tx.begin();
        em.persist(java1);
        em.persist(java2);
        em.persist(javaee1);
        em.persist(javaee2);
        em.flush();
        tx.commit();

        TypedQuery<SlideShow> query = em.createNamedQuery("getAllSlideShows", SlideShow.class);
        List<SlideShow> results = query.getResultList();

        assertEquals(4, results.size());

        assertEquals("Java Presentation 1", results.get(0).title);
        assertEquals("Java Presentation 2", results.get(1).title);
        assertEquals("Java EE Presentation 1", results.get(2).title);
        assertEquals("Java EE Presentation 2", results.get(3).title);

        assertNotNull(results.get(0).category);
        assertNotNull(results.get(1).category);
        assertNotNull(results.get(2).category);
        assertNotNull(results.get(3).category);

        assertEquals("Java", results.get(0).category.name);
        assertEquals("Java", results.get(1).category.name);
        assertEquals("Java EE", results.get(2).category.name);
        assertEquals("Java EE", results.get(3).category.name);

        query = em.createNamedQuery("getSlideShowsByTitle", SlideShow.class).setParameter("title", "Java Presentation 1");
        results = query.getResultList();
        assertEquals(1, results.size());
        assertEquals("Java Presentation 1", results.get(0).title);

        query = em.createNamedQuery("getSlideShowsByCategory", SlideShow.class).setParameter("category", "Java EE");
        results = query.getResultList();
        assertEquals(2, results.size());
        assertEquals("Java EE Presentation 1", results.get(0).title);
        assertEquals("Java EE Presentation 2", results.get(1).title);
    }
}
