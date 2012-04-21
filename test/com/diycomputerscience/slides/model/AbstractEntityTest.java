package com.diycomputerscience.slides.model;

import java.util.Date;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

public abstract class AbstractEntityTest extends TestCase {
    protected EntityManager em;

    @Override
    protected final void setUp() throws Exception {
        String dbName = "slides" + new Date().getTime();
        String connectionUrl = "jdbc:hsqldb:mem:" + dbName;
        final Properties p = new Properties();
        p.put("myds", "new://Resource?type=DataSource");
        p.put("myds.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("myds.JdbcUrl", connectionUrl);

        p.put("openjpa.Id", "entities");
        p.put("openjpa.ConnectionURL", connectionUrl);
        p.put("openjpa.ConnectionDriverName", "org.hsqldb.jdbcDriver");
        p.put("openjpa.ConnectionUserName", "sa");
        p.put("openjpa.ConnectionPassword", "");
        p.put("openjpa.Connection2URL", connectionUrl);
        p.put("openjpa.Connection2DriverName", "org.hsqldb.jdbcDriver");
        p.put("openjpa.Connection2UserName", "sa");
        p.put("openjpa.Connection2Password", "");

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("entities", p);
        em = emFactory.createEntityManager();
    }

    @Override
    protected final void tearDown() throws Exception {
        em.clear();
        em.close();
    }
}
