package com.csg.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.csg.exception.WordExecptionHandler;
import com.csg.model.WordRequest;
import com.csg.model.WordResponse;
import com.csg.service.WordsService;
import com.csg.util.WordPredicates;
/**
 * 
 * @author jaishankerpandey
 *
 */
@Service
public class WordServiceImpl implements WordsService{
	public static Logger logger = org.slf4j.LoggerFactory.getLogger(WordServiceImpl.class);
	/**
	 * This method is responsible for processing business logic
	 * request this parameter contains request details to process
	 * 
	 */
	@Override
	public WordResponse processWords(WordRequest request) {
		WordResponse response=new WordResponse();
		logger.info("processWords calculating count based on filter started");
		Map<String, Long> countWords = getWordsCount(request.getWords(),request.getFilter());
		logger.info("processWords calculating count based on filter completed. {} ",countWords);
		
		logger.info("processWords collect list of words based on length started");
		List<String> words = getWordsByLength(request.getWords(),request.getLength());
		
		logger.info("processWords collect list of words based on length completed. {} ",words);
		
		response.setCountWords(countWords);
		response.setWords(words);
		return response;
	}

	/**
	 * This method retuns a list based on length
	 * strings  :list of input string
	 * length	:long value for filter
	 */
	private List<String> getWordsByLength(List<String> strings,Long length) {
	return strings.stream()
			.filter(WordPredicates.filterByLength(length))
			.collect(Collectors.toList());
	}
	/**
	 * This method retun a map based on character
	 * strings  :list of input string
	 * character	:string value for filter
	 */
	private Map<String, Long> getWordsCount(List<String> strings,String character) {
		return strings
				.stream()
				.filter(WordPredicates.filterByChars(character))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	}

}
