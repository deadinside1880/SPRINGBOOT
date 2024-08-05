DROP TABLE IF EXISTS Run;

CREATE TABLE IF NOT EXISTS Run(
    id INT NOT NULL,
    title VARCHAR(256) NOT NULL,
    time_started TIMESTAMP NOT NULL,
    time_ended TIMESTAMP NOT NULL,
    kilometers INT NOT NULL,
    location VARCHAR(10) NOT NULL,
    version INT,
    PRIMARY KEY (id)
);