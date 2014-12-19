package com.msg.xt.spring.hateoas.resource;

/*
**  Spring Hateoas Samples 
**  Design and Development by msg Applied Technology Research
**  Copyright (c) 2013 msg systems ag (http://www.msg-systems.com/)
**  All Rights Reserved.
*/
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.context.annotation.Scope;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.msg.xt.spring.hateoas.controller.JavaMagazineResourceController;
import com.msg.xt.spring.hateoas.entity.JavaMagazine;

/**
* Java Magazine Paged Resource Assembler 
* 
* @author Michael Schäfer, Peter Huber 
* 
* */

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class JavaMagazinePageResourceAssembler extends
		PagedResourcesAssembler<JavaMagazine> {

	public JavaMagazinePageResourceAssembler() {
		super(null, linkTo(JavaMagazineResourceController.class)
				.toUriComponentsBuilder().build());
	}

}
