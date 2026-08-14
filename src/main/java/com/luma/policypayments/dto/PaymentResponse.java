package com.luma.policypayments.dto;

import java.time.LocalDate;

public class PaymentResponse {

    private final Long paymentId;
    private final double amount;
    private final LocalDate paymentDate;

    public PaymentResponse(Long paymentId, double amount, LocalDate paymentDate) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }
}
