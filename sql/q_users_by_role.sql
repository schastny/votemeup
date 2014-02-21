#list users count by role, sorted by count
SELECT u.last_name, u.first_name, u.birth_year, role_name, role_description
FROM userd u LEFT JOIN userd_role ur on u.userd_id = ur.userd_id
LEFT join role r on r.role_id = ur.role_id
order by u.last_name
;