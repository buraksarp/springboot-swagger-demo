package com.sarp.vod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.sarp.vod.domain.Video;
import com.sarp.vod.domain.VideoRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/vod")
public class VodController {

	private VideoRepository videoRepository;

	@Autowired
	public VodController(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}
	
	@ApiOperation(value = "get list of videos", nickname = "get list of videos", response = List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "SUCCESS", response = List.class),
			@ApiResponse(code = 404, message = "NOT_FOUND"), 
			@ApiResponse(code = 500, message = "FAILURE") })
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Video>> getVideos() {
		return new ResponseEntity<List<Video>>((List<Video>) videoRepository.findAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "add video", nickname = "add video", response = HttpStatus.class)
	@ApiResponses({
	    @ApiResponse(code = 201, message ="CREATED", response = HttpStatus.class)})
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addVideo(@RequestBody Video video){
		videoRepository.save(video);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "update video", nickname = "update video", response = HttpStatus.class)
	@ApiResponses({
	    @ApiResponse(code = 200, message ="UPDATED", response = HttpStatus.class)})
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<HttpStatus> updateVideo(@RequestBody Video video){
		videoRepository.save(video);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}	
	
	@ApiOperation(value = "delete video", nickname = "delete video", response = HttpStatus.class)
	@ApiResponses({
	    @ApiResponse(code = 200, message ="DELETED", response = HttpStatus.class)})
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteVideo(@RequestBody Long id){
		videoRepository.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "get videos by title", nickname = "get videos by title", response = List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "SUCCESS", response = List.class),
			@ApiResponse(code = 404, message = "NOT_FOUND"), 
			@ApiResponse(code = 500, message = "FAILURE") })
	@RequestMapping(value = "/{title}", method = RequestMethod.GET)
	public ResponseEntity<List<Video>> getVideoByTitle(@PathVariable String title) {
		return new ResponseEntity<List<Video>>(videoRepository.findByTitle(title),HttpStatus.OK);
	}
	
}
