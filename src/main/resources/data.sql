INSERT INTO policy (policy_id, policyholder_name, product_type, premium_amount, issue_date) VALUES
('P-1001', 'Maria Chen', 'Fixed Annuity', 50000.00, '2023-01-15'),
('P-1002', 'David Okafor', 'Indexed Annuity', 125000.50, '2023-03-02'),
('P-1003', 'Susan Patel', 'Fixed Annuity', 10000.10, '2023-05-20');

INSERT INTO payment (policy_id, amount, payment_date) VALUES
('P-1001', 10000.00, '2023-02-01'),
('P-1002', 0.10, '2023-04-01'),
('P-1002', 0.20, '2023-04-15'),
('P-1003', 9999.99, '2023-06-01');
