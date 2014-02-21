#list all proposals by the given category
# one-to-many relation

SELECT c.categ_name, p.proposal_text
FROM category AS c JOIN proposal AS p
on c.categ_id = p.categ_id
WHERE c.categ_name = 'Силовые структуры'
;