package com.msg.xt.spring.hateoas.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.context.annotation.Scope;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.msg.xt.spring.hateoas.controller.JavaMagazineResourceController;
import com.msg.xt.spring.hateoas.entity.JavaMagazine;

@Component
public class JavaMagazinePageResourceAssembler extends
		PagedResourcesAssembler<JavaMagazine> {

		
	
	public JavaMagazinePageResourceAssembler() {
		super(null, linkTo(JavaMagazineResourceController.class)
				.toUriComponentsBuilder().build());
	}

}
