package com.csg.handler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.csg.model.WordRequest;
import com.csg.model.WordResponse;
import com.csg.service.WordsService;

import static org.junit.Assert.*;
public class ServiceHandlerTest {
	
	@Mock
	WordsService service;
	@InjectMocks
	ServiceHandler handler;
	
	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testgetWordsDetails() {
		WordRequest request =new WordRequest();
		request.setFilter("J");
		request.setLength(null);
		request.setWords(Arrays.asList("Jai","Monu","RohitTest","MohanTest"));
		WordResponse response=new WordResponse();
		Mockito.when(service.processWords(request)).thenReturn(response);
		ResponseEntity<WordResponse> wordsDetails = handler.getWordsDetails(request);
		Map<String,Long> map=new HashMap<>();
		map.put(null, null);
		response.setCountWords(map);
		assertEquals(wordsDetails.getBody().getCountWords(), response.getCountWords());
		assertEquals(wordsDetails.getStatusCode(), HttpStatus.OK);
	}
}
