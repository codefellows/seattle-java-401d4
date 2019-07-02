package com.brookr.FloatyShop;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface ProductInfoRepository extends CrudRepository<ProductInfo, String> {
    Optional<ProductInfo> findById(String id);
}
