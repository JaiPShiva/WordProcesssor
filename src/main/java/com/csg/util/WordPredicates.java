package com.csg.util;

import java.util.function.Predicate;

public class WordPredicates {

	public static Predicate<String> filterByChars(String chars) {
		Predicate<String> compare = x -> x.startsWith(chars);
		return compare;

	}

	public static Predicate<String> filterByLength(Long length) {
		Predicate<String> compare_Length = x -> x.length() > length;
		return compare_Length;

	}
}
