-- select * from shoe;
-- INSERT INTO shoe (brand, style) VALUES( "Born", "sandal"); 
-- VALUES ("Born", "Dr. Scholl's", "Coconuts", "Eurosoft", "XOXO", "Korks", "Jambu"),
-- ("sandal", "casual", "dress", "athletic", "sandal", "dress", "boots");

-- insert into prices (shoe_ID, price) values (2, 19.99); 
-- select * from prices;
-- drop table prices;

-- CREATE TABLE prices (shoe_ID INTEGER not null, price DECIMAL(6,2) not null, FOREIGN KEY (shoe_ID) references shoe(id));

-- create table color (shoe_id int not null, id int not null auto_increment, colors VARCHAR(10), primary key (id), foreign key (shoe_id) references shoe(id));

-- select colors, id, price from color inner join prices on color.shoe_id = prices.shoe_id;


-- select style, count(*) from shoe where style like "sandal" group by style;

-- select price from price group by price order by price asc;
-- select max(price) from price;