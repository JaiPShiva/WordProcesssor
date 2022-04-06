package com.csg.service;

import com.csg.model.WordRequest;
import com.csg.model.WordResponse;

public interface WordsService {

	public WordResponse processWords(WordRequest request);

}
