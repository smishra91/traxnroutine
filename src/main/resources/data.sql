-- Create table accounts
CREATE TABLE IF NOT EXISTS accounts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    document_number VARCHAR(20) NOT NULL UNIQUE
);

-- Create table operation_types
CREATE TABLE IF NOT EXISTS operation_types (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(100) NOT NULL
);

-- Create table transactions
CREATE TABLE IF NOT EXISTS transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_id BIGINT NOT NULL,
    operation_type_id BIGINT NOT NULL,
    amount DOUBLE NOT NULL,
    event_date TIMESTAMP NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(id),
    FOREIGN KEY (operation_type_id) REFERENCES operation_types(id)
);

-- Insert sample data for accounts
INSERT INTO accounts (document_number) VALUES ('12345678900');
INSERT INTO accounts (document_number) VALUES ('09876543210');

-- Insert sample data for operation types
INSERT INTO operation_types (description) VALUES ('NORMAL_PURCHASE');
INSERT INTO operation_types (description) VALUES ('PURCHASE_WITH_INSTALLMENTS');
INSERT INTO operation_types (description) VALUES ('WITHDRAWAL');
INSERT INTO operation_types (description) VALUES ('CREDIT_VOUCHER');

-- Insert sample data for transactions
INSERT INTO transactions (account_id, operation_type_id, amount, event_date)
VALUES (1, 1, -50.0, '2024-06-01 10:32:07.7199222');

INSERT INTO transactions (account_id, operation_type_id, amount, event_date)
VALUES (1, 1, -23.5, '2026-06-01 10:48:12.2135875');

INSERT INTO transactions (account_id, operation_type_id, amount, event_date)
VALUES (1, 1, -18.7, '2020-06-02 19:01:23.1458543');

INSERT INTO transactions (account_id, operation_type_id, amount, event_date)
VALUES (1, 4, 60.0, '2020-06-05 09:34:18.5893223');

INSERT INTO transactions (account_id, operation_type_id, amount, event_date)
VALUES (2, 3, -100.0, '2020-06-10 12:15:00.0000000');