CREATE TABLE USERS(
    id VARCHAR(50) PRIMARY KEY,
    created_date TIMESTAMP,
    modified_date TIMESTAMP,
    last_login TIMESTAMP,
    token VARCHAR(500),
    is_active BOOLEAN,
    name VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(12)
);