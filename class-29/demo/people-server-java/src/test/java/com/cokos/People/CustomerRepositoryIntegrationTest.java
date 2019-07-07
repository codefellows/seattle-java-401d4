package com.cokos.People;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.cokos.People.Models.Customer;
import com.cokos.People.Repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PeopleApplication.class)
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = {"amazon.dynamodb.endpoint=http://localhost:8000/"})
public class CustomerRepositoryIntegrationTest {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    CustomerRepository repository;

    private static final String EXPECTED_NAME = "Supa Shoppa";

    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        dynamoDBMapper.batchDelete(repository.findAll());
    }

    @Test
    public void readWriteTestCase() {
        Customer supa = new Customer(EXPECTED_NAME);
        repository.save(supa);

        List<Customer> result = (List<Customer>) repository.findAll();

        assertTrue("Not empty", result.size() > 0);
    }
}


//  Run a local DynamoDB server:
//      https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html
//
//  Then edit/use this command to create a local table:
//    aws dynamodb create-table \
//        --table-name Customers \
//        --attribute-definitions AttributeName=id,AttributeType=S \
//        --key-schema AttributeName=id,KeyType=HASH \
//        --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 \
//        --endpoint-url http://localhost:8000