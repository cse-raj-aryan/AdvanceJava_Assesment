package com.example.demo.mapper;

import com.example.demo.entity.Policy;
import com.example.demo.entity.Customer;
import com.example.demo.dto.response.PolicyResponseDTO;
import com.example.demo.dto.response.CustomerResponseDTO;

public class PolicyMapper {

    public static PolicyResponseDTO toDTO(Policy policy) {

        PolicyResponseDTO dto = new PolicyResponseDTO();

        dto.setId(policy.getId());
        dto.setPolicyNumber(policy.getPolicyNumber());
        dto.setPolicyType(policy.getPolicyType());
        dto.setPremiumAmount(policy.getPremiumAmount());
        dto.setCoverageAmount(policy.getCoverageAmount());
        dto.setStartDate(policy.getStartDate());
        dto.setEndDate(policy.getEndDate());
        dto.setStatus(policy.getStatus());

        Customer customer = policy.getCustomer();

        if (customer != null) {
            CustomerResponseDTO customerDTO = new CustomerResponseDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setPhoneNumber(customer.getPhoneNumber());
            customerDTO.setAddress(customer.getAddress());

            dto.setCustomer(customerDTO);
        }

        return dto;
    }
}