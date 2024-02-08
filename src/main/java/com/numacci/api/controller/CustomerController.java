package com.numacci.api.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numacci.api.dto.Customer;
import com.numacci.api.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  private CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping
  public Customer post(@Validated @RequestBody Customer customer, Errors errors) {
    // If the fields of requested customer object are invalid,
    // throw Runtime Exception with validation errors.
    // NOTE: You can set HTTP status code and return it instead of throwing error.
    if (errors.hasErrors()) {
      throw new RuntimeException((Throwable) errors);
    }
    // NOTE: You can also validate whether insertion succeeded or not here.
    return customerService.register(customer);
  }
}