package com.nf.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //root cofig
        AnnotationConfigWebApplicationContext rootConfig = new AnnotationConfigWebApplicationContext();
        rootConfig.register(DBConfig.class);
        rootConfig.refresh();
        servletContext.addListener(new ContextLoaderListener(rootConfig));

        // servlet config

        AnnotationConfigWebApplicationContext servletConfig= new AnnotationConfigWebApplicationContext();
        servletConfig.register(ServletConfig.class);
        ServletRegistration.Dynamic servletRegistration= servletContext.
                addServlet("servlet",new DispatcherServlet(servletConfig));

        //Load on Startup
        servletRegistration.setLoadOnStartup(1);

        //add mapping
        servletRegistration.addMapping("/");
    }


}
