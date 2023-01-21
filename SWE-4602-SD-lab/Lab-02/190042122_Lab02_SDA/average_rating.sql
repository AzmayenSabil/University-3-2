delimiter //
create procedure calculate_avg_rating()
BEGIN
  -- create a temporary table to store the average rating for each product
  CREATE TEMPORARY TABLE temp_average_rating AS
  SELECT product_id, AVG(product_rating) as average_rating
  FROM rating
  GROUP BY product_id;

  -- update the product table with the average rating
  UPDATE product p 
  JOIN temp_average_rating t
  ON p.id = t.product_id
  SET p.average_rating = t.average_rating;
 
  -- drop the temporary table
  DROP TEMPORARY TABLE temp_average_rating;
END;//
delimiter ;