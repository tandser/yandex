DROP TABLE    IF EXISTS company;
DROP SEQUENCE IF EXISTS seq_company;

CREATE SEQUENCE seq_company START 1;

CREATE TABLE company (
  id      INTEGER PRIMARY KEY DEFAULT nextval('seq_company'),
  name    VARCHAR NOT NULL,
  address VARCHAR NOT NULL
);

CREATE UNIQUE INDEX unique_company ON company (name);