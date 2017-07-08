package store.web.securityConfiguration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	
//	 @Override
//	    public void addViewControllers(ViewControllerRegistry registry) {
//	        registry.addViewController("/login").setViewName("login");
//	        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//	    }
//	 
//    @Autowired
//    private ResourceProperties resourceProperties = new ResourceProperties();
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        Integer cachePeriod = resourceProperties.getCachePeriod();
//
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/")
//                .setCachePeriod(cachePeriod);
//
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/templates/home.html")
//                .setCachePeriod(cachePeriod).resourceChain(true)
//                .addResolver(new PathResourceResolver() {
//                    @Override
//                    protected Resource getResource(String resourcePath,
//                            Resource location) throws IOException {
//                        return location.exists() && location.isReadable() ? location
//                                : null;
//                    }
//                });
//    }
	
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//    }
//
//    @Bean
//    public SpringSecurityDialect securityDialect() {
//        return new SpringSecurityDialect();
//    }
}