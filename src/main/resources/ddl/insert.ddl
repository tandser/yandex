DELETE FROM company;

ALTER SEQUENCE seq_company RESTART WITH 1;

INSERT INTO company (name, address) VALUES
  ('Amazon', 'Seattle, Washington'),
  ('Google', 'Menlo Park, California'),
  ('Oracle', 'Santa Clara, California,');