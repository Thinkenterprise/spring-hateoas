package com.msg.xt.spring.hateoas.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.msg.xt.spring.hateoas.controller.ArticleResourceController;
import com.msg.xt.spring.hateoas.entity.Article;

@Component
public class ArticleResourceAssembler extends ResourceAssemblerSupport<Article, ArticleResource>{

	@Autowired
	EntityLinks entityLinks;
	

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
