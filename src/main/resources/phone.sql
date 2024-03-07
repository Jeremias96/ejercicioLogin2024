CREATE TABLE PHONE(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    number BIGINT,
    city_code INT,
    country_code VARCHAR(10)
    FOREIGN KEY (user_id) REFERENCES USER(id)
);