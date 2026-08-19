# policy-payments-service

Exposes lookups for annuity/insurance policies.

## Endpoints

- `GET /policies/{policyId}` — returns policy details, balance, and payment history.
- `POST /policies/{policyId}/payments` — records a payment against a policy.

## Running locally

```
mvn spring-boot:run
```

Seed data is loaded automatically on startup (H2 in-memory).
