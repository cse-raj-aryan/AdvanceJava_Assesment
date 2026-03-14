package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.request.CustomerRequestDTO;
import com.example.demo.dto.response.CustomerResponseDTO;

public interface CustomerService {

    CustomerResponseDTO createCustomer(CustomerRequestDTO dto);

    List<CustomerResponseDTO> getAllCustomers();

    CustomerResponseDTO getCustomerById(Long id);

    CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO dto);

    void deleteCustomer(Long id);
}