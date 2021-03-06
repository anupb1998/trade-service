CREATE TABLE Trade (
  trade_id INT AUTO_INCREMENT  PRIMARY KEY,
  version INT,
  is_expired CHAR(1),
  UPDATE_DATE DATE,
  CREATED_DATE DATE,
  MATURITY_DATE DATE,
  BOOK_ID INT,
  COUNTER_PRATY_ID INT
);

CREATE TABLE Trade_Book (
  book_Id INT AUTO_INCREMENT  PRIMARY KEY,
  book_Name VARCHAR(254)
);
CREATE TABLE counter_party (
  counter_Praty_Id INT AUTO_INCREMENT  PRIMARY KEY,
  counter_Praty_Name VARCHAR(254)
);