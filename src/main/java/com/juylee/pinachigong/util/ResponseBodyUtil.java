package com.juylee.pinachigong.util;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ResponseBodyUtil {
	public static Map<String, Object> createResponseData(Object object) throws Exception {
		Map<String, Object> data = new HashMap<>();
		data.put("data", object);
		return data;
	}
	
	public static Map<String, Object> createExceptionResponseBody(HttpStatus error, int status, String message, String path) {
        Map<String, Object> exceptionResponseBody = new HashMap<String, Object>();
        exceptionResponseBody.put("timestamp", new Timestamp(System.currentTimeMillis()));
        exceptionResponseBody.put("error", error);
        exceptionResponseBody.put("status", status);
        exceptionResponseBody.put("message", message);
        exceptionResponseBody.put("path", path);
        return exceptionResponseBody;
    }

}
