package com.github.MaryHrisanfova.BibliographySystem.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Mariia_Khrisanfova
 */
public class AppInitializer implements WebApplicationInitializer {

    private static final int LOAD_ON_STARTUP = 1;
    private static final String DISPATCHER_NAME = "dispatcher";
    private static final String URL_PATTERN = "/";

    public void onStartup(ServletContext servletContext) throws ServletException {
        configureRootContext(servletContext);
        configureDispatcherContext(servletContext);
    }

    private void configureRootContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));
    }

    private void configureDispatcherContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebMvcConfig.class);
        dispatcherContext.setServletContext(servletContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_NAME, new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(LOAD_ON_STARTUP);
        dispatcher.addMapping(URL_PATTERN);
    }
}
