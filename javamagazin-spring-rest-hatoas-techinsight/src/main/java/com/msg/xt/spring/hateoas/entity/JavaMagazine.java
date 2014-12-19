package com.msg.xt.spring.hateoas.entity;

/*
**  Spring Hateoas Samples 
**  Design and Development by msg Applied Technology Research
**  Copyright (c) 2013 msg systems ag (http://www.msg-systems.com/)
**  All Rights Reserved.
*/
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * JavaMagazine Entity Class 
 * 
 * @author @author Michael Schäfer, Peter Huber 
 * 
 * */
@Entity
public class JavaMagazine extends AbstractEntity {

	private String name;

	public JavaMagazine(String name) {
		this.name=name;
	}

	public JavaMagazine() {
		super();
		
	}

	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Article> article = new HashSet<Article>();

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Article> getArticle() {
		return article;
	}

	public void setArticle(Set<Article> article) {
		this.article = article;
	}

	public void add(Article newArticle) {
		article.add(newArticle);
		
	}
	
	
}
