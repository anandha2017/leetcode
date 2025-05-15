-- Example LeetCode problem: Customers Who Never Order
CREATE TABLE Customers (
  customer_id   INT PRIMARY KEY,
  customer_name TEXT
);
CREATE TABLE Orders (
  order_id     INT PRIMARY KEY,
  customer_id  INT REFERENCES Customers(customer_id)
);


INSERT INTO Customers VALUES
  (1, 'Alice'),
  (2, 'Bob'),
  (3, 'Charlie');

INSERT INTO Orders VALUES
  (101, 1),
  (102, 1),
  (103, 3);


SELECT * FROM Customers;
SELECT * FROM Orders;