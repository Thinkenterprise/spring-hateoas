package com.msg.xt.spring.hateoas.entity;

/*
**  Spring Hateoas Samples 
**  Design and Development by msg Applied Technology Research
**  Copyright (c) 2013 msg systems ag (http://www.msg-systems.com/)
**  All Rights Reserved.
*/
/**
 * Article Entity Class 
 * 
 * @author Michael Schäfer, Peter Huber  
 * 
 * */
import javax.persistence.Entity;

import org.springframework.hateoas.core.Relation;

@Entity
public class Article extends AbstractEntity {

	private String name;
	private String articleText;
	
	public Article() {
		super();
		
	}

	public Article(String name, String articleText) {
		super();
		this.name = name;
		this.articleText = articleText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
	
}
