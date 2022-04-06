package com.csg.model;

import java.util.List;
import java.util.Map;

public class WordResponse {

	private Map<String, Long> countWords;
	
	private List<String> words;

	public Map<String, Long> getCountWords() {
		return countWords;
	}

	public void setCountWords(Map<String, Long> countWords) {
		this.countWords = countWords;
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	@Override
	public String toString() {
		return "WordResponse [countWords=" + countWords + ", words=" + words + "]";
	}
	
}
