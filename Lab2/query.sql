SELECT maker, type FROM product
WHERE type = 'Printer'
ORDER BY maker desc;

SELECT time_out FROM trip
WHERE time_out between '1900-01-01 12:00:00' and '1900-01-01 17:00:00';

SELECT maker, type, laptop.model, speed FROM laptop 
JOIN product ON laptop.model = product.model
WHERE speed > 600;

SELECT distinct maker FROM product
WHERE type = 'PC' and maker =ANY
(SELECT maker FROM product WHERE type = 'Laptop');

SELECT name, launched, displacement FROM ships
JOIN classes ON ships.class = classes.class
WHERE launched >= 1922 AND displacement >35000;

SELECT CONCAT('Code: ', code) code,
	   CONCAT('Model: ', model) model,
       CONCAT('Speed: ', speed) speed,
       CONCAT('Ram: ', ram) ram,
       CONCAT('Hd: ', hd) hd,
       CONCAT('Cd: ', cd) cd,
       CONCAT('Price: ', price) price
FROM pc;

SELECT date, count(date) FROM pass_in_trip
JOIN trip ON town_to = 'Moscow' and pass_in_trip.trip_no = trip.trip_no
GROUP BY 1;

SELECT speed, avg(price) FROM pc
WHERE speed > 600 
GROUP BY 1;

SELECT maker, CASE WHEN count(printer.model) > 0 THEN concat('YES(', count(printer.model), ')') ELSE "NO" END printer
FROM product
LEFT JOIN printer ON product.model = printer.model
GROUP BY maker;

SELECT classes.class, count(name) FROM classes
RIGHT JOIN
(SELECT name, class FROM ships UNION SELECT ship, null FROM outcomes) 
new_basa ON classes.class = new_basa.class
GROUP BY classes.class;