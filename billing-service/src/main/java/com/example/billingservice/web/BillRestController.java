package com.example.billingservice.web;

import com.example.billingservice.entities.Bill;
import com.example.billingservice.feign.CustomerRestClient;
import com.example.billingservice.feign.ProductRestClient;
import com.example.billingservice.repository.BillRepository;
import com.example.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository BillRepository;
    @Autowired
    private ProductItemRepository  ProductItemRepository;
    @Autowired
    private CustomerRestClient CustomerRestClient;
    @Autowired
    private ProductRestClient ProductRestClient;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;


    @GetMapping(path = "/bills/{id}")
    public Bill getBill(@PathVariable Long id) {
      Bill bill = BillRepository.findById(id).get();
      bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
      bill.getProductItems().forEach(productItem -> {
          productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));

      });
      return bill;


    }
}
