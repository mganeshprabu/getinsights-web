package com.gp.getinsights.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.getinsights.entity.News;
import com.gp.getinsights.repository.NewsRepository;

@Service
public class NewsService
{
	@Autowired
	private NewsRepository newsRepo;
	
	public News addNews(News news)
	{
		return newsRepo.save(news);
	}
	
	public List<News> getAllNews()
	{
		return newsRepo.findAllByOrderByTimestampDesc();
	}
	
	public String updateNews(Long id, News newNews)
	{
		Optional<News> o = newsRepo.findById(id);
		if(o.isPresent())
		{
			News existing = o.get();
			existing.setTitle(newNews.getTitle());
			existing.setContent(newNews.getContent());
			newsRepo.save(existing);
			return "News updated";
		}
		return "News not found";
	}
	
	public String deleteNews(Long id)
	{
		if(newsRepo.existsById(id))
		{
			newsRepo.deleteById(id);
			return "News deleted";
		}
		return "News not found";	
	}
	
	
}
