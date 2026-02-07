package com.gp.getinsights.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.getinsights.entity.News;

public interface NewsRepository extends JpaRepository<News, Long>
{
	List<News> findAllByOrderByTimestampDesc();
}
