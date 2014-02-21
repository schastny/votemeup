#show top proposal
# nested select


drop table if exists prop_vote_count;
CREATE TABLE prop_vote_count (
proposal_id int,
yes_count int
);

INSERT INTO prop_vote_count (proposal_id,yes_count) 
	SELECT proposal_id, count(*)
		FROM vote
		where vote = 'yes'
		group by (proposal_id)
;



SELECT p.proposal_id, proposal_text, yes_count
	FROM prop_vote_count pvc LEFT JOIN proposal p
	on pvc.proposal_id = p.proposal_id
	#ORDER BY  (yes_count) DESC
	WHERE yes_count IN (SELECT MAX(yes_count) FROM prop_vote_count )
;


DROP TABLE prop_vote_count;

