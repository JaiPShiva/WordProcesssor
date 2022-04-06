package com.csg.handler;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csg.model.WordRequest;
import com.csg.model.WordResponse;
import com.csg.service.WordsService;

@RestController
public class ServiceHandler {
	
	@Autowired
	WordsService wordService;
	
	@RequestMapping(value = "/words",method = RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WordResponse> getWordsDetails(@RequestBody @Valid  WordRequest request) {
		
		WordResponse response=  wordService.processWords(request);
		return new ResponseEntity<WordResponse>(response,HttpStatus.OK);
		
		
	}

}
