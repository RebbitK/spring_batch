package com.sparta.springbatch.global.config;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LambdaHandler implements RequestHandler<Object, String> {

	private final JobLauncher jobLauncher;
	private final Job myJob;
	private final SpringBatchConfig springBatchConfig;

	@Autowired
	public LambdaHandler(JobLauncher jobLauncher, Job myJob, SpringBatchConfig springBatchConfig) {
		this.jobLauncher = jobLauncher;
		this.myJob = myJob;
		this.springBatchConfig = springBatchConfig;
	}

	@Override
	public String handleRequest(Object input, Context context) {
		try {
			springBatchConfig.runBatchJob();
			return "Batch job executed successfully!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error executing batch job: " + e.getMessage();
		}
	}
}
