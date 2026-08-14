package com.luma.policypayments.controller;

import com.luma.policypayments.dto.PaymentRequest;
import com.luma.policypayments.dto.PolicyResponse;
import com.luma.policypayments.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    private static final Logger log = LoggerFactory.getLogger(PolicyController.class);

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping("/{policyId}")
    public ResponseEntity<PolicyResponse> getPolicy(@PathVariable String policyId) {
        return ResponseEntity.ok(policyService.getPolicyDetails(policyId));
    }

    @PostMapping("/{policyId}/payments")
    public ResponseEntity<PolicyResponse> addPayment(@PathVariable String policyId,
                                                       @RequestBody PaymentRequest request) {
        try {
            PolicyResponse response = policyService.recordPayment(policyId, request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error recording payment for policy {}", policyId, e);
            return ResponseEntity.ok(new PolicyResponse());
        }
    }
}
