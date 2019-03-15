package com.cg.dynamodb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamodbConfig {
	
	@Value("${awsAccessKey}")
	private String awsAccessKey;
	
	@Value("${awsSecretKey}")
	private String awsSecretKey;
	
	@Value("${awsRegion}")
	private String awsRegion;
	
	@Value("${awsDynamodbEndpoint}")
	private String awsDynamodbEndpoint;
	
	@Bean
    public DynamoDBMapper mapper()
    {
    	return new DynamoDBMapper(amazonDynamoDbConfig());
    }

	public AmazonDynamoDB amazonDynamoDbConfig()
	{
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsDynamodbEndpoint,awsRegion))
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey,awsSecretKey)))
				.build();
	}
}
