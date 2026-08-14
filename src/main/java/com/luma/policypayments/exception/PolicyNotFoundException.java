package com.luma.policypayments.exception;

public class PolicyNotFoundException extends RuntimeException {

    public PolicyNotFoundException(String policyId) {
        super("Policy not found: " + policyId);
    }
}
