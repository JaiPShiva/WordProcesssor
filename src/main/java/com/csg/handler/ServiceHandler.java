package com.csg.handler;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csg.exception.WordExecptionHandler;
import com.csg.model.WordRequest;
import com.csg.model.WordResponse;
import com.csg.service.WordsService;

@RestController
public class ServiceHandler {
	public static Logger logger = org.slf4j.LoggerFactory.getLogger(WordExecptionHandler.class);
	@Autowired
	WordsService wordService;
	
	@RequestMapping(value = "/words",method = RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WordResponse> getWordsDetails(@RequestBody @Valid  WordRequest request) {
		logger.info("getWordsDetails request {}",request);
		WordResponse response=  wordService.processWords(request);
		logger.info("getWordsDetails response {}",response);
		return new ResponseEntity<WordResponse>(response,HttpStatus.OK);
		
		
	}

}
