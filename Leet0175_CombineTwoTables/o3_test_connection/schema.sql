-- Example LeetCode problem: Customers Who Never Order
CREATE TABLE Customers (
  customer_id   INT PRIMARY KEY,
  customer_name TEXT
);
CREATE TABLE Orders (
  order_id     INT PRIMARY KEY,
  customer_id  INT REFERENCES Customers(customer_id)
);
