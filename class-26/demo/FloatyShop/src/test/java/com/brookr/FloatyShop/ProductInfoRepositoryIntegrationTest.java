package com.brookr.FloatyShop;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FloatyShopApplication.class)
@WebAppConfiguration
@ActiveProfiles("local")
public class ProductInfoRepositoryIntegrationTest {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    ProductInfoRepository repository;

    private static final String EXPECTED_COST = "20";
    private static final String EXPECTED_PRICE = "50";

    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(ProductInfo.class);

        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

        dynamoDBMapper.batchDelete((List<ProductInfo>)repository.findAll());
    }

    @Test
    public void readWriteTestCase() {
        ProductInfo dave = new ProductInfo(EXPECTED_COST, EXPECTED_PRICE);
        repository.save(dave);

        List<ProductInfo> result = (List<ProductInfo>) repository.findAll();

        assertTrue("Not empty", result.size() > 0);
        assertTrue("Contains item with expected cost", result.get(0).getCost().equals(EXPECTED_COST));
    }
}

