package com.newwayus.parishpro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/index.html")
                .addResourceLocations("classpath:/static/index.html")
                .setCachePeriod(0);

        // Mapping for resources under /assets path
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/static/") // Base location of static resources
                .setCachePeriod(0);

        registry.addResourceHandler("/main-8UzOKjJg.js/**")
                .addResourceLocations("classpath:/static/assets/main-8UzOKjJg.js") // Base location of static resources
                .setCachePeriod(0);

        registry.addResourceHandler("/main-8UzOKjJg.css/**")
                .addResourceLocations("classpath:/static/assets/main-8UzOKjJg.css") // Base location of static resources
                .setCachePeriod(0);

        // Mapping for resources under /favicon path
        registry.addResourceHandler("/favicon/**")
                .addResourceLocations("classpath:/static/favicon/") // Location of favicon resources
                .setCachePeriod(0);

        registry.addResourceHandler("/manifest.json")
                .addResourceLocations("classpath:/static/manifest.json")
                .setCachePeriod(0);

        // Mapping for favicon.ico
        registry.addResourceHandler("/favicon.ico")
                .addResourceLocations("classpath:/static/favicon.ico")
                .setCachePeriod(0);

        logStaticFolderContents();


    }


    private void logStaticFolderContents() {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resolver.getResources("classpath:/static/**");
            System.out.println("Contents of the static folder:");
            for (Resource resource : resources) {
                System.out.println(resource.getURL());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
