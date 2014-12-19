package com.msg.xt.spring.hateoas.resource;

/*
**  Spring Hateoas Samples 
**  Design and Development by msg Applied Technology Research
**  Copyright (c) 2013 msg systems ag (http://www.msg-systems.com/)
**  All Rights Reserved.
*/
import org.springframework.hateoas.Resource;

import com.msg.xt.spring.hateoas.entity.JavaMagazine;

/**
 * Java Magazine Resource 
 * 
 * @author Michael Schäfer, Peter Huber 
 * 
 * */
public class JavaMagazineResource extends Resource<JavaMagazine> {

	public JavaMagazineResource() {
		super(null);	
	}
	
	public JavaMagazineResource(JavaMagazine javaMagazine) {
		super(javaMagazine);
		
	}


}
