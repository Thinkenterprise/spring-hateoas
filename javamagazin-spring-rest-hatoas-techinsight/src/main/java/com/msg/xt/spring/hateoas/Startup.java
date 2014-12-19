package com.msg.xt.spring.hateoas;
/*
**  Spring Hateoas Samples 
**  Design and Development by msg Applied Technology Research
**  Copyright (c) 2013 msg systems ag (http://www.msg-systems.com/)
**  All Rights Reserved.
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.msg.xt.spring.hateoas.entity.Article;
import com.msg.xt.spring.hateoas.entity.JavaMagazine;
import com.msg.xt.spring.hateoas.repository.IJavaMagazineRepository;

/**
 * Startup Klasse
 * 
 * @author Michael Schäfer, Peter Huber
 */
@Component
@Scope("singleton")
public class Startup {

	private static final String CONTENT = "Content";

	@Autowired
	public void setCustomerRepository(
			IJavaMagazineRepository javaMagazineRepository) {

		javaMagazineRepository.deleteAll();

		if (javaMagazineRepository.count() == 0) {
			JavaMagazine javaMagazine = new JavaMagazine("Ausgabe 1");
			javaMagazine.add(new Article("Spring HATEOAS", CONTENT));
			javaMagazine.add(new Article("Spring BOOT",CONTENT));
			javaMagazine.add(new Article("Spring DATA",CONTENT));

			javaMagazineRepository.save(javaMagazine);

			javaMagazine = new JavaMagazine("Ausgabe 2");
			javaMagazine.add(new Article("Java EE JPA",CONTENT));
			javaMagazine.add(new Article("Java EE JAXRS",CONTENT));
			javaMagazineRepository.save(javaMagazine);

			javaMagazine = new JavaMagazine("Ausgabe 3");
			javaMagazine.add(new Article("OSGI Service Layer",CONTENT));
			javaMagazine.add(new Article("OSGI Module Layer",CONTENT));
			javaMagazineRepository.save(javaMagazine);

			javaMagazine = new JavaMagazine("Ausgabe 4");
			javaMagazine.add(new Article("Kotlin besser als Ceylon",CONTENT));
			javaMagazine.add(new Article("Scala besser als Kotlin",CONTENT));
			javaMagazine.add(new Article("Alles besser als Java",CONTENT));
			javaMagazineRepository.save(javaMagazine);
		}

		Iterable<JavaMagazine> mags = javaMagazineRepository.findAll();
		for (JavaMagazine javaMagazine : mags) {
			System.out.println("Magazine: " + javaMagazine.getId());
		}
	}
}
