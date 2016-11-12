package com.sarp.vod.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Long> {
	
	List<Video> findByTitle(String title);
}
