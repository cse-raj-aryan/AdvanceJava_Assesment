package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dto.request.PolicyRequestDTO;
import com.example.demo.dto.response.PolicyResponseDTO;

public interface PolicyService {

    PolicyResponseDTO createPolicy(PolicyRequestDTO dto);

    PolicyResponseDTO getPolicyById(Long id);

    PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto);

    void cancelPolicy(Long id);

    List<PolicyResponseDTO> getPoliciesByType(String type);

    List<PolicyResponseDTO> getPoliciesByPremiumRange(Double min, Double max);

    Page<PolicyResponseDTO> getAllPolicies(int page,int size,String sortBy,String direction);
}