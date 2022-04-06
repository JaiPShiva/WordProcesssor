package com.csg.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.csg.model.WordRequest;
import com.csg.model.WordResponse;
import com.csg.service.WordsService;
import com.csg.util.WordPredicates;

@Service
public class WordServiceImpl implements WordsService{

	@Override
	public WordResponse processWords(WordRequest request) {
		WordResponse response=new WordResponse();
		
		Map<String, Long> countWords = getWordsCount(request.getWords(),request.getFilter());
		
		List<String> words = getWordsByLength(request.getWords(),request.getLength());
		
		response.setCountWords(countWords);
		response.setWords(words);
		return response;
	}

	private List<String> getWordsByLength(List<String> strings,Long length) {
	return strings.stream()
			.filter(WordPredicates.filterByLength(length))
			.collect(Collectors.toList());
	}

	private Map<String, Long> getWordsCount(List<String> strings,String character) {
		return strings
				.stream()
				.filter(WordPredicates.filterByChars(character))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	}

}
