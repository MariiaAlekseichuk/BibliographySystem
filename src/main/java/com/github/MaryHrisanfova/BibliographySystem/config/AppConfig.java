package com.github.MaryHrisanfova.BibliographySystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Mariia_Khrisanfova
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.github.MaryHrisanfova.BibliographySystem"})
public class AppConfig {
}
