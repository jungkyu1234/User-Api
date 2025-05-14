package com.zerobase.cms;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients(basePackages = "com.zerobase.cms.client")
@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
@RequiredArgsConstructor
public class CmsProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(CmsProjectApplication.class, args);
	}

}
