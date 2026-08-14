package com.luma.policypayments.dto;

import com.luma.policypayments.model.Policy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PolicyResponse {

    private String policyId;
    private String policyholderName;
    private String productType;
    private BigDecimal premiumAmount;
    private LocalDate issueDate;

    public static PolicyResponse from(Policy policy) {
        PolicyResponse response = new PolicyResponse();
        response.policyId = policy.getPolicyId();
        response.policyholderName = policy.getPolicyholderName();
        response.productType = policy.getProductType();
        response.premiumAmount = policy.getPremiumAmount();
        response.issueDate = policy.getIssueDate();
        return response;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public void setPolicyholderName(String policyholderName) {
        this.policyholderName = policyholderName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }
}
