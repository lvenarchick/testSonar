
package com.rochcap.cpa.config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.rochcap.cpa.interceptor.SessionManager;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.rochcap.cpa" })
public class WebMvcConfig implements WebMvcConfigurer
{
	@Resource(lookup = "java:/DEFAULT_DB2DS")
	DataSource dataSource;

	@Bean
	public DataSource dataSource() throws NamingException
	{
		return dataSource;
	}

	@Bean
	public InternalResourceViewResolver resolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(new SessionManager()).addPathPatterns("/**").excludePathPatterns("/resources/**", "/login", "/");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

	}

	@Bean
	public MessageSource messageSource()
	{
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/messages");
		messageSource.setUseCodeAsDefaultMessage(false);
		messageSource.setCacheSeconds((int) TimeUnit.HOURS.toSeconds(1));
		messageSource.setFallbackToSystemLocale(false);
		return messageSource;
	}

	@Override
	public Validator getValidator()
	{
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}

	@Bean(name = "filterMultipartResolver")
	public CommonsMultipartResolver getMultiPartResolver() throws IOException
	{
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();

		// Set the maximum allowed size (in bytes) for each individual file.
		resolver.setMaxUploadSize(300000000); // 30MB
		resolver.setMaxInMemorySize(300000000); // 30MB

		return resolver;
	}
}
