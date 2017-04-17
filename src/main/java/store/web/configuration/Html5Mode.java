package store.web.configuration;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class Html5Mode {
	
	@Bean
	ErrorViewResolver supportPathBasedLocationStrategyWithoutHashes() {
	    return new ErrorViewResolver() {
	        @Override
	        public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
	            return status == HttpStatus.NOT_FOUND
	                    ? new ModelAndView("/home", Collections.<String, Object>emptyMap(), HttpStatus.OK)
	                    : null;
	        }
	    };
	}
}
