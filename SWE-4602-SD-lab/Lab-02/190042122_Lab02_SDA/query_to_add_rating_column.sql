ALTER TABLE product
ADD COLUMN average_rating int not null default 0;

ALTER TABLE rating
ADD COLUMN product_rating int default 0;