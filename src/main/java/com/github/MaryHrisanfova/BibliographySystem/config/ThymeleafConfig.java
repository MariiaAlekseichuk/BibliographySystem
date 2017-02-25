package com.github.MaryHrisanfova.BibliographySystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * @author Mariia_Khrisanfova
 */
@Configuration
public class ThymeleafConfig {

    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final String HTML_SUFFIX = ".html";
    private static final String HTML_PREFIX = "/WEB-INF/templates/";

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix(HTML_PREFIX);
        resolver.setSuffix(HTML_SUFFIX);
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCacheable(false);
        resolver.setCharacterEncoding(CHARACTER_ENCODING);
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setCharacterEncoding(CHARACTER_ENCODING);
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }
}
