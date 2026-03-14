package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.request.PolicyRequestDTO;
import com.example.demo.dto.response.PolicyResponseDTO;
import com.example.demo.service.PolicyService;

@RestController
@RequestMapping("/api/policies")
public class PolicyController 
{

    private final PolicyService service;

    public PolicyController(PolicyService service) 
    {
        this.service = service;
    }

    @PostMapping
    public PolicyResponseDTO createPolicy(@RequestBody PolicyRequestDTO dto) 
    {
        return service.createPolicy(dto);
    }

    @GetMapping("/{id}")
    public PolicyResponseDTO getPolicy(@PathVariable Long id) 
    {
        return service.getPolicyById(id);
    }

    @PutMapping("/{id}")
    public PolicyResponseDTO updatePolicy(@PathVariable Long id, @RequestBody PolicyRequestDTO dto) 
    {
        return service.updatePolicy(id, dto);
    }

    @DeleteMapping("/{id}")
    public void cancelPolicy(@PathVariable Long id)
    {
        service.cancelPolicy(id);
    }

    @GetMapping("/type/{type}")
    public List<PolicyResponseDTO> getByType(@PathVariable String type)
    {
        return service.getPoliciesByType(type);
    }

    @GetMapping("/premium")
    public List<PolicyResponseDTO> getByPremiumRange(@RequestParam Double min,@RequestParam Double max)
    {
        return service.getPoliciesByPremiumRange(min,max);
    }

    @GetMapping
    public Page<PolicyResponseDTO> getAllPolicies(@RequestParam int page,@RequestParam int size,@RequestParam String sortBy,@RequestParam String direction)
    {

        return service.getAllPolicies(page,size,sortBy,direction);
    }
}