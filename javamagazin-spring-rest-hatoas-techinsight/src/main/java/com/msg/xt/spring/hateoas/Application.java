package com.msg.xt.spring.hateoas;

/*
**  Spring Hateoas Samples 
**  Design and Development by msg Applied Technology Research
**  Copyright (c) 2013 msg systems ag (http://www.msg-systems.com/)
**  All Rights Reserved.
*/


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * Spring Application Boot  
 * 
 * @author Michael Schäfer, Peter Huber 
 * 
 * */
@ComponentScan 
@EnableAutoConfiguration
@EnableJpaRepositories
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
