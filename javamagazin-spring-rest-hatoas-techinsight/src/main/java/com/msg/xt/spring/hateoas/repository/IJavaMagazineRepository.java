package com.msg.xt.spring.hateoas.repository;

/*
**  Spring Hateoas Samples 
**  Design and Development by msg Applied Technology Research
**  Copyright (c) 2013 msg systems ag (http://www.msg-systems.com/)
**  All Rights Reserved.
*/

/**
 * JavaMagazine Repository Interface 
 * 
 * @author Michael Schäfer, Peter Huber  
 * 
 * */



import org.springframework.data.repository.PagingAndSortingRepository;

import com.msg.xt.spring.hateoas.entity.JavaMagazine;

public interface IJavaMagazineRepository extends PagingAndSortingRepository<JavaMagazine, Long> {

}
