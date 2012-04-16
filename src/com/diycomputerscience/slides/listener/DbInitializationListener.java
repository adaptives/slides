package com.diycomputerscience.slides.listener;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.diycomputerscience.slides.service.SlideService;

public final class DbInitializationListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            Properties properties = new Properties();
            properties.setProperty (Context.INITIAL_CONTEXT_FACTORY,"org.apache.openejb.client.LocalInitialContextFactory");
            InitialContext context = new InitialContext(properties);

            SlideService service = (SlideService) context.lookup("SlideServiceLocalBean");
            service.initDb();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

}
