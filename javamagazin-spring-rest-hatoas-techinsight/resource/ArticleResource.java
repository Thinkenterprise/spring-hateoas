package com.msg.xt.spring.hateoas.resource;

import org.springframework.hateoas.Resource;

import com.msg.xt.spring.hateoas.entity.Article;


public class ArticleResource extends Resource<Article>{

	public ArticleResource() {
		super(null);
	}
	
	public ArticleResource(Article content) {
		super(content);
		
	}
}
