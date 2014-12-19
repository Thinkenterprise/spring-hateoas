package com.msg.xt.spring.hateoas.resource;

/*
**  Spring Hateoas Samples 
**  Design and Development by msg Applied Technology Research
**  Copyright (c) 2013 msg systems ag (http://www.msg-systems.com/)
**  All Rights Reserved.
*/
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.msg.xt.spring.hateoas.controller.ArticleResourceController;
import com.msg.xt.spring.hateoas.entity.Article;

/**
 * Articel Resource Assembler   
 * 
 * @author Michael Schäfer, Peter Huber 
 * 
 * */
@Component
public class ArticleResourceAssembler extends ResourceAssemblerSupport<Article, ArticleResource>{

		

	public ArticleResourceAssembler() {
		super(ArticleResourceController.class,ArticleResource.class);
	}
	
	
	@Override
	public ArticleResource toResource(Article entity) {
		
		
		ArticleResource articleResource = new ArticleResource(entity);
				
		Link selfLink = linkTo(ArticleResourceController.class).slash(entity.getId()).withSelfRel();
		
		articleResource.add(selfLink);
		
		return articleResource;
		 
	}

	
	
	
}
