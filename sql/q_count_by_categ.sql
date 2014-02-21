# count proposals quantity by category

SELECT c.categ_name, COUNT(*) 
FROM category c INNER JOIN proposal p
ON c.categ_id = p.categ_id
GROUP BY c.categ_name;