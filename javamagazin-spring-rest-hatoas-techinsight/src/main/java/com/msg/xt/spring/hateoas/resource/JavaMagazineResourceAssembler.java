package com.msg.xt.spring.hateoas.resource;

/*
**  Spring Hateoas Samples 
**  Design and Development by msg Applied Technology Research
**  Copyright (c) 2013 msg systems ag (http://www.msg-systems.com/)
**  All Rights Reserved.
*/

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.msg.xt.spring.hateoas.controller.ArticleResourceController;
import com.msg.xt.spring.hateoas.controller.JavaMagazineResourceController;
import com.msg.xt.spring.hateoas.entity.Article;
import com.msg.xt.spring.hateoas.entity.JavaMagazine;

/**
 * Java Magazine Resource Assembler 
 * 
 * @author Michael Schäfer, Peter Huber 
 * 
 * */
@Component
public class JavaMagazineResourceAssembler extends	ResourceAssemblerSupport<JavaMagazine, JavaMagazineResource> {

	
	public JavaMagazineResourceAssembler() {
		
		super(JavaMagazineResourceController.class, JavaMagazineResource.class);
		
	}
	
	public JavaMagazineResourceAssembler(Class<?> controllerClass,
			Class<JavaMagazineResource> resourceType) {
		super(JavaMagazineResourceController.class, JavaMagazineResource.class);
		
	}

	@Override
	public JavaMagazineResource toResource(JavaMagazine entity) {
	
		JavaMagazineResource javaMagazineResource = new JavaMagazineResource(entity);
		
		
		// Link auf mich selbst 
		Link selfLink = linkTo(JavaMagazineResourceController.class).slash(entity.getId()).withSelfRel();
		javaMagazineResource.add(selfLink);
		
		// Link auf die Liste meiner Referenzen 
		Link articlesLink = linkTo(methodOn(ArticleResourceController.class).articleByJavaMagazine(entity.getId())).withRel("_articles");
		javaMagazineResource.add(articlesLink);
		
		// Linke auf jedes Elemente meiner Liste 
		Set<Article> articles = entity.getArticle();
		
		for (Article article : articles) {
			
			Link articleLink = linkTo(methodOn(ArticleResourceController.class).articleByJavaMagazine(entity.getId(),article.getId())).withRel("_article");		
			javaMagazineResource.add(articleLink);
		}
		
		
		
		return javaMagazineResource;
	
	
	}

	
	
}
