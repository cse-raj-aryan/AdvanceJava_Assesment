package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

public class PolicyRequestDTO {

    @NotBlank
    private String policyNumber;

    private String policyType;

    @Positive
    private Double premiumAmount;

    @Positive
    private Double coverageAmount;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;

    private Long customerId;

    public String getPolicyNumber() 
    { 
    	return policyNumber; 
    }

    public void setPolicyNumber(String policyNumber) 
    { 
    	this.policyNumber = policyNumber; 
    }

    public String getPolicyType() 
    { 
    	return policyType; 
    }

    public void setPolicyType(String policyType) 
    { 
    	this.policyType = policyType; 
    }

    public Double getPremiumAmount() 
    { 
    	return premiumAmount; 
    }

    public void setPremiumAmount(Double premiumAmount) 
    { 
    	this.premiumAmount = premiumAmount; 
    }

    public Double getCoverageAmount() 
    { 
    	return coverageAmount; 
    }

    public void setCoverageAmount(Double coverageAmount) 
    { 
    	this.coverageAmount = coverageAmount; 
    }

    public LocalDate getStartDate() 
    { 
    	return startDate; 
    }

    public void setStartDate(LocalDate startDate) 
    { 
    	this.startDate = startDate; 
    }

    public LocalDate getEndDate() 
    { 
    	return endDate; 
    }

    public void setEndDate(LocalDate endDate) 
    { 
    	this.endDate = endDate; 
    }

    public Long getCustomerId() 
    { 
    	return customerId; 
    }

    public void setCustomerId(Long customerId) 
    { 
    	this.customerId = customerId; 
    }
}