
package com.rochcap.cpa.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter.ReferrerPolicy;

import com.rochcap.cpa.utils.Constants;

import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	ServletContext context;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.requiresChannel().antMatchers("/*").requiresSecure();

		http.sessionManagement().invalidSessionUrl("/sessionTimeout");
		
		// The URL to redirect to if a user tries to access a resource and their session has been expired due to too
		// many sessions for the current user. The default is to write a simple error message to the response.
		// http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true).expiredUrl("/sessionExists");

		http.logout().deleteCookies("JSESSIONID");

		/* HTTP Strict Transport Security (HSTS) */
		http.headers().httpStrictTransportSecurity().includeSubDomains(true).maxAgeInSeconds(63072000);

		http.headers().cacheControl();

		/* X-Frame-Options */
		http.headers().frameOptions().deny();

		/* X-XSS-Protection added by default */
		http.headers().xssProtection().xssProtectionEnabled(true);

		/* Referer Policy */
		http.headers().referrerPolicy(ReferrerPolicy.SAME_ORIGIN);

		/* Static Headers */
		http.headers().addHeaderWriter(new StaticHeadersWriter("X-Custom-Security-Header", "header-value"));

		// Cache-Control: no-store, no-cache, must-revalidate, max-age=0
	}
}
