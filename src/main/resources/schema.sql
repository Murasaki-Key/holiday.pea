CREATE DATABASE spring_holiday;

DROP TABLE IF EXISTS account;

CREATE TABLE account(
  id SERIAL PRIMARY KEY,
  name TEXT
  password TEXT
);

