CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP,
                       name VARCHAR(255) NOT NULL,
                       surname VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL DEFAULT 'ROLE_USER'
);

INSERT INTO users (name, surname, email, username, password, role) VALUES
                                                                       ('Admin', 'Admin', 'admin@test.com', 'admin', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'ROLE_ADMIN'),
                                                                       ('User', 'User', 'user@test.com', 'user', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'ROLE_USER');
-- password: 'password'