/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.bank.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author GuutonG
 */
@Configuration
public class WebApplicationConfig implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        sc.addServlet("h2", new WebServlet()).addMapping("/console/*");
    }

}
