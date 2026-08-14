# policy-payments-service

Exposes lookups for annuity/insurance policies.

## Endpoints

- `GET /policies/{policyId}` — returns policy details.

## Running locally

```
mvn spring-boot:run
```

Seed data is loaded automatically on startup (H2 in-memory).
