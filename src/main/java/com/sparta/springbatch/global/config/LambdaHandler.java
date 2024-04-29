package com.sparta.springbatch.global.config;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LambdaHandler implements RequestStreamHandler {

	private final ObjectMapper objectMapper = new ObjectMapper();
	private final SpringBatchConfig springBatchConfig;

	@Override
	public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
		// Spring Batch 실행
		try {
			springBatchConfig.runBatchJob();
			sendResponse(outputStream, 200, "Batch job executed successfully.");
		} catch (Exception e) {
			sendResponse(outputStream, 500, "Failed to execute batch job: " + e.getMessage());
		}
	}

	private void sendResponse(OutputStream outputStream, int statusCode, String message) throws IOException {
		Map<String, Object> response = new HashMap<>();
		response.put("statusCode", statusCode);
		response.put("body", message);

		objectMapper.writeValue(outputStream, response);
	}
}
