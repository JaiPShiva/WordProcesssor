package com.csg.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.UnexpectedTypeException;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * 
 * @author jaishankerpandey
 *
 */
@RestControllerAdvice
public class WordExecptionHandler {
	public static Logger logger = org.slf4j.LoggerFactory.getLogger(WordExecptionHandler.class);

	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<String> handleInvalidArgument(UnexpectedTypeException ex) {

		return new ResponseEntity(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
/**
 * This method is responsible to handale exception globally
 * @param ex  contains exception details
 * @return
 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
		logger.info("Request Validation Exception Occurred");
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}

}
