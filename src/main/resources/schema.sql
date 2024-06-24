CREATE TABLE PET (
    PET_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    PET_NAME VARCHAR(64),
    PET_TYPE VARCHAR(64),
    PET_BREED VARCHAR(64),
    WEIGHT DECIMAL(5,2),
    VACCINATED BOOLEAN,
    TRAINING_LEVEL INT
);

