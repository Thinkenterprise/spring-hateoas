package com.msg.xt.spring.hateoas.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.msg.xt.spring.hateoas.entity.Article;
import com.msg.xt.spring.hateoas.entity.JavaMagazine;
import com.msg.xt.spring.hateoas.repository.IArticleRepository;
import com.msg.xt.spring.hateoas.repository.IJavaMagazineRepository;
import com.msg.xt.spring.hateoas.resource.ArticleResource;
import com.msg.xt.spring.hateoas.resource.ArticleResourceAssembler;

@RestController
@RequestMapping("article")
public class ArticleResourceController {

	@Autowired
	private IArticleRepository articleRepository;

	@Autowired
	private ArticleResourceAssembler articleResourceAssembler;

	@Autowired
	private IJavaMagazineRepository javaMagazineRepository;

	@RequestMapping(value = "/version", method = RequestMethod.GET)
	public String version() {
		return "v1";
	}

	@RequestMapping(value = "/javamagazine/{id}/article", method = RequestMethod.GET)
	public ResponseEntity<Iterable<ArticleResource>> articleByJavaMagazine(@PathVariable Long id) {
		JavaMagazine javaMagazine = javaMagazineRepository.findOne(id);

		List<ArticleResource> articleResources = articleResourceAssembler
				.toResources(javaMagazine.getArticle());

		return new ResponseEntity(articleResources,HttpStatus.OK);

	}

	@RequestMapping(value = "/javamagazine/{mid}/article/{aid}", method = RequestMethod.GET)
	public ResponseEntity<ArticleResource> articleByJavaMagazine(@PathVariable Long mid,
			@PathVariable Long aid) {
		JavaMagazine javaMagazine = javaMagazineRepository.findOne(mid);
		Set<Article> articles = javaMagazine.getArticle();
		for (Article article : articles) {
			if (aid.equals(article.getId())) {
				ArticleResource articleResources = articleResourceAssembler.toResource(article);
				return new ResponseEntity(articleResources,HttpStatus.OK);
			}
		}
		throw new ResourceAccessException(String.format(
				"Article Not Found; mag=%d; article=%d", mid, aid));
	}
}
