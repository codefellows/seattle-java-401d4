package com.cokos.People.Controllers;

import com.cokos.People.Models.Customer;
import com.cokos.People.Repository.CustomerRepository;
import com.cokos.People.Repository.S3Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class CustomerController {

    private S3Client s3Client;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerController(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return (List) customerRepository.findAll();
    }

    @PostMapping("/customers")
    public Customer uploadFile(
            @RequestParam("name") String name,
            @RequestParam("old") Boolean old,
            @RequestPart(value = "file") MultipartFile file
    ){

        String pic = this.s3Client.uploadFile(file);
        Customer customer = new Customer();
        customer.setName(name);
        customer.setOld( Boolean.valueOf(old) );
        customer.setPic(pic);
        customerRepository.save(customer);
        return customer;

    }
}
