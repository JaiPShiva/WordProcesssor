package com.csg.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author jaishankerpandey
 *
 */
public class WordRequest {
	@NotNull(message = "list of words can not be null or blank")
	private List<String> words;

	@NotBlank(message = "filter can not be null or blank")
	private String filter;

	@Min(1)
	@Max(10)
	private Long length;

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "WordRequest [words=" + words + ", filter=" + filter + ", length=" + length + "]";
	}

}
