package com.juylee.pinachigong.exception.handler;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.juylee.pinachigong.util.ResponseBodyUtil;


@RestControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);
	
	public ResponseEntity<Map<String, Object>> noMenuException(Exception e) {
		logger.warn("존재하지 않는 메뉴입니다.");
		
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
