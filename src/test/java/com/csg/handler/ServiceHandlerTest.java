package com.csg.handler;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csg.model.WordRequest;
import com.csg.model.WordResponse;
import com.csg.service.WordsService;

@RunWith(SpringJUnit4ClassRunner.class)
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
	public void testgetWordsDetails_Success() {
		WordRequest request = getRequest();
		WordResponse response = mockResponse();
		Mockito.when(service.processWords(request)).thenReturn(response);

		ResponseEntity<WordResponse> wordsDetails = handler.getWordsDetails(request);

		Long long1 = wordsDetails.getBody().getCountWords().get("Monu");
		List<String> words = wordsDetails.getBody().getWords();

		assertEquals(long1, new Long(1));
		assertEquals(wordsDetails.getBody().getCountWords(), response.getCountWords());
		assertEquals(wordsDetails.getStatusCode(), HttpStatus.OK);
		assertEquals(words, Arrays.asList("Jai", "Monu", "RohitTest", "MohanTest"));
	}

	private WordResponse mockResponse() {
		WordResponse response = new WordResponse();
		Map<String, Long> map = new HashMap<>();
		map.put("Monu", new Long(1));
		response.setCountWords(map);
		response.setWords(Arrays.asList("Jai", "Monu", "RohitTest", "MohanTest"));
		return response;
	}

	private WordRequest getRequest() {
		WordRequest request = new WordRequest();
		request.setFilter("J");
		request.setLength(new Long(3));
		request.setWords(Arrays.asList("Jai", "Monu", "RohitTest", "MohanTest"));
		return request;
	}
}
