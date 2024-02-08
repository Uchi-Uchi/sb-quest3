package com.numacci.api.repository;

import org.apache.ibatis.annotations.Mapper;

import com.numacci.api.dto.Customer;

@Mapper
public interface CustomerMapper {

  /**
   * Insert a new customer record to the database.
   *
   * @param customer customer object which we want to insert
   * @return the number of inserted records
   */
  int insert(Customer customer);
}
