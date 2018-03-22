package org.cloudcms;

import org.cloudcms.config.JerseyConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties
//@ComponentScan(basePackages = {"org.cloudcms", "org.cloudcms.dao", "org.cloudcms.service.impl"})
//@ServletComponentScan
@MapperScan(basePackages = "org.cloudcms.dao")
@EnableDiscoveryClient
public class CloudcmsSimpleServiceApplication {

	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean regietration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
		regietration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
		return regietration;
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudcmsSimpleServiceApplication.class, args);
	}
}
