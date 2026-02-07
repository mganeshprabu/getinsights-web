package com.gp.getinsights.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gp.getinsights.entity.News;
import com.gp.getinsights.service.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController
{
	@Autowired
	private NewsService newsService;
	
	// PUBLIC - anyone can read
	@GetMapping("/getAll")
	public List<News> getAllNews()
	{
		return newsService.getAllNews();
	}
	
	// ADMIN only
	@PostMapping("/add")
	public News addNews(@RequestBody News news)
	{
		return newsService.addNews(news);
	}
	
	@PutMapping("/update/{id}")
	public String updateNews(@PathVariable Long id, @RequestBody News news)
	{
		return newsService.updateNews(id, news);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteNews(@PathVariable Long id)
	{
		return newsService.deleteNews(id);
	}
	
	
}
