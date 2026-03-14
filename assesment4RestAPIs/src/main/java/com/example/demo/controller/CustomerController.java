package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.request.CustomerRequestDTO;
import com.example.demo.dto.response.CustomerResponseDTO;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public CustomerResponseDTO createCustomer(@RequestBody CustomerRequestDTO dto) {
        return service.createCustomer(dto);
    }

    // READ ALL
    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers() {
        return service.getAllCustomers();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public CustomerResponseDTO updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerRequestDTO dto) {

        return service.updateCustomer(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return "Customer deleted successfully";
    }
}