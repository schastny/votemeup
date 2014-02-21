#list  proposals by  categories (order by category)
# one-to-many relation

SELECT * 
FROM category c INNER JOIN proposal p
on c.categ_id = p.categ_id
ORDER BY c.categ_name

;