package com.msg.xt.spring.hateoas.controller;

/*
**  Spring Hateoas Samples 
**  Design and Development by msg Applied Technology Research
**  Copyright (c) 2013 msg systems ag (http://www.msg-systems.com/)
**  All Rights Reserved.
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.msg.xt.spring.hateoas.entity.JavaMagazine;
import com.msg.xt.spring.hateoas.repository.IJavaMagazineRepository;
import com.msg.xt.spring.hateoas.resource.ArticleResourceAssembler;
import com.msg.xt.spring.hateoas.resource.JavaMagazinePageResourceAssembler;
import com.msg.xt.spring.hateoas.resource.JavaMagazineResource;
import com.msg.xt.spring.hateoas.resource.JavaMagazineResourceAssembler;


/**
 * REST Interface für die JavaMagazine Resource 
 * 
 * @author Michael Schäfer, Peter Huber
 */

@RestController
@RequestMapping("javaMagazine")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class JavaMagazineResourceController {
	
	@Autowired
	private IJavaMagazineRepository javaMagazineRepository;
	
	@Autowired
	private JavaMagazineResourceAssembler javaMagazineResourceAssembler;
	
	
	@Autowired
	private JavaMagazinePageResourceAssembler javaMagazinePageResourceAssembler;
	
	
	@RequestMapping("{id}")
	public ResponseEntity<JavaMagazine> get(@PathVariable Long id) {
		
		return new ResponseEntity<JavaMagazine>(javaMagazineRepository.findOne(id),HttpStatus.OK);
		
	}
	

	@RequestMapping("hateoas/{id}")
	public ResponseEntity<JavaMagazineResource> getHateoas(@PathVariable Long id) {
				
		return new ResponseEntity<JavaMagazineResource>(new JavaMagazineResource(javaMagazineRepository.findOne(id)),HttpStatus.OK);
	}
	
	@RequestMapping("hateoas/relations/{id}")
	public ResponseEntity<JavaMagazineResource> getHateoasRelations(@PathVariable Long id) {
				
		return new ResponseEntity<JavaMagazineResource>(javaMagazineResourceAssembler.toResource(javaMagazineRepository.findOne(id)),HttpStatus.OK);
	}
	
	
	@RequestMapping("hateoas/relations")
	public ResponseEntity<PagedResources<JavaMagazineResource>> getHateoasRelationsPaging( @RequestParam Integer size, @RequestParam Integer page) {
		
		Page p = javaMagazineRepository.findAll(new PageRequest(size,page));
		
		return new ResponseEntity<PagedResources<JavaMagazineResource>>(javaMagazinePageResourceAssembler.toResource(p, javaMagazineResourceAssembler),HttpStatus.OK); 
	}

	
	
	
	
	
	
	
	

}
