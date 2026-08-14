package com.luma.policypayments.service;

import com.luma.policypayments.dto.PaymentRequest;
import com.luma.policypayments.dto.PaymentResponse;
import com.luma.policypayments.dto.PolicyResponse;
import com.luma.policypayments.exception.PolicyNotFoundException;
import com.luma.policypayments.model.Payment;
import com.luma.policypayments.model.Policy;
import com.luma.policypayments.repository.PaymentRepository;
import com.luma.policypayments.repository.PolicyRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;
    private final PaymentRepository paymentRepository;

    public PolicyService(PolicyRepository policyRepository, PaymentRepository paymentRepository) {
        this.policyRepository = policyRepository;
        this.paymentRepository = paymentRepository;
    }

    public Policy findPolicy(String policyId) {
        return policyRepository.findById(policyId)
                .orElseThrow(() -> new PolicyNotFoundException(policyId));
    }

    public PolicyResponse getPolicyDetails(String policyId) {
        Policy policy = findPolicy(policyId);

        List<Payment> payments = paymentRepository.findAll().stream()
                .filter(payment -> payment.getPolicyId().equals(policyId))
                .collect(Collectors.toList());

        double totalPaid = payments.stream()
                .mapToDouble(Payment::getAmount)
                .sum();

        PolicyResponse response = PolicyResponse.from(policy);
        response.setBalance(policy.getPremiumAmount().add(BigDecimal.valueOf(totalPaid)));
        response.setPayments(payments.stream()
                .map(payment -> new PaymentResponse(payment.getId(), payment.getAmount(), payment.getPaymentDate()))
                .collect(Collectors.toList()));
        return response;
    }

    public PolicyResponse recordPayment(String policyId, PaymentRequest request) {
        findPolicy(policyId);

        Payment payment = new Payment();
        payment.setPolicyId(policyId);
        payment.setAmount(request.getAmount().doubleValue());
        payment.setPaymentDate(request.getDate());
        paymentRepository.save(payment);

        return getPolicyDetails(policyId);
    }
}
