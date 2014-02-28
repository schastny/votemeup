package up.voteme.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Vote {
	private int voteId;
	//private int userdId;
	private Userd userd;
	//private int proposalId;
	private Proposal proposal;
	private boolean vote;
	private Date voteDate;
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public int getVoteId() {
		return voteId;
	}
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	
	@ManyToOne
	public Userd getUserd() {
		return userd;
	}
	public void setUserd(Userd userd) {
		this.userd = userd;
	}
	@ManyToOne
	public Proposal getProposal() {
		return proposal;
	}
	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}
	
	public void setVote(boolean vote) {
		this.vote = vote;
	}
	public boolean getVote() {
		return vote;
	}
	
	public Date getVoteDate() {
		return voteDate;
	}
	public void setVoteDate(Date voteDate) {
		this.voteDate = voteDate;
	}

}
