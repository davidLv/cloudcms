package org.cloudcms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudcmsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudcmsEurekaServerApplication.class, args);
	}
}
