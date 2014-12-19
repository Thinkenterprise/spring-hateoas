package com.msg.xt.spring.hateoas.entity;

/*
**  Spring Hateoas Samples 
**  Design and Development by msg Applied Technology Research
**  Copyright (c) 2013 msg systems ag (http://www.msg-systems.com/)
**  All Rights Reserved.
*/


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
/**
 * Abstract Entity Class 
 * 
 * @author Michael Schäfer, Peter Huber  
 * 
 * */



@MappedSuperclass
public abstract class AbstractEntity {
	
	@Id
	@GeneratedValue
	private Long id;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
