package com.luma.policypayments.service;

import com.luma.policypayments.exception.PolicyNotFoundException;
import com.luma.policypayments.model.Policy;
import com.luma.policypayments.repository.PolicyRepository;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public Policy findPolicy(String policyId) {
        return policyRepository.findById(policyId)
                .orElseThrow(() -> new PolicyNotFoundException(policyId));
    }
}
