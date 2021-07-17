package com.juylee.pinachigong.exception.handler;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.juylee.pinachigong.config.Constant;
import com.juylee.pinachigong.exception.NoMenuException;
import com.juylee.pinachigong.util.ResponseBodyUtil;


@RestControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);
	
	@ExceptionHandler(NoMenuException.class)
	public ResponseEntity<Map<String, Object>> noMenuException(Exception e) {
		logger.warn(Constant.NO_MENU_EXCEPTION_MESSAGE);
		
		return new ResponseEntity<Map<String, Object>>(
					ResponseBodyUtil.createExceptionResponseBody(
							HttpStatus.BAD_REQUEST, // return status
							HttpStatus.BAD_REQUEST.value(), // return code
							e.getMessage(), // error message
							null
					),
					HttpStatus.BAD_REQUEST
				);
	}
}
