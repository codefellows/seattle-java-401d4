package com.cokos.People.Repository;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.cokos.People")
public class DynamoDBConfig {

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Value("${amazon.aws.bucket}")
    private String bucket;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(){
        AmazonDynamoDB amazonDynamoDB;

        if (amazonDynamoDBEndpoint.isEmpty()) {
            amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                    .withCredentials(credentialsProvider())
                    .withRegion(Regions.US_WEST_2)
                    .build();
            System.out.println("connecting to remote dynamo in region: " + Regions.US_WEST_2);
        } else {
            amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                    .withEndpointConfiguration(
                            new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
                    .build();
            System.out.println("connecting to dynamo at endpoint: "+ amazonDynamoDBEndpoint);
        }

        return amazonDynamoDB;
    }


    public AWSCredentialsProvider credentialsProvider() {
        return new AWSCredentialsProvider() {
            @Override
            public AWSCredentials getCredentials() {
                return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
            }

            @Override
            public void refresh() {

            }
        };
    }
}