package up.voteme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "vote_proposal")
public class VoteProposal {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "Vote")
    private boolean vote;

    @Column(name = "VoteDateTime")
    private String voteDateTime;

    @ManyToOne
    @JoinColumn(name = "Proposal_id")
    private Proposal proposal;
	
    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;
    
	
	
}
