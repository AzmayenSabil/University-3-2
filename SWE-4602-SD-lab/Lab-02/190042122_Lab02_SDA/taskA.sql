CREATE TABLE invoice (
  invoice_id INT AUTO_INCREMENT PRIMARY KEY,
  customer_id INT,
  seller_id INT,
  timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE sale (
  sale_id INT AUTO_INCREMENT PRIMARY KEY,
  product_id INT NOT NULL,
  invoice_id INT NOT NULL,
  unit_price DECIMAL(10,2) NOT NULL,
  count INT NOT NULL,
  timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (product_id) REFERENCES product(product_id),
  FOREIGN KEY (invoice_id) REFERENCES invoice(invoice_id)
);

CREATE TABLE customer (
  customer_id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE employee (
  employee_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  role VARCHAR(255) NOT NULL,
  hire_date DATE NOT NULL,
  salary DECIMAL(10,2) NOT NULL
);