#list comments of the proposal in chronological order 

SELECT p.proposal_text, c.comment_text, c.comment_date, u.last_name, u.first_name FROM 
commentd c LEFT JOIN proposal p on c.proposal_id = p.proposal_id
left join userd u on c.userd_id = u.userd_id
order by (c.comment_date);
