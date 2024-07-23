package config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import filter.UserFilter;

@Configuration
public class UserConfig {

    @Bean
    FilterRegistrationBean<UserFilter> loginFilter() {
		FilterRegistrationBean<UserFilter> registrationBean = new FilterRegistrationBean<UserFilter>();
		registrationBean.setFilter(new UserFilter());
		registrationBean.addUrlPatterns("/user/*");
		return registrationBean;
	}
}
