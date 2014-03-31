package up.voteme.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Vote {
	
	private long voteId;
	private Userd userd;
	private Proposal proposal;
	private boolean vote;
	private Date voteDate;
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "vote_id")
	public long getVoteId() {
		return voteId;
	}
	public void setVoteId(long voteId) {
		this.voteId = voteId;
	}
	
	@ManyToOne
	@JoinColumn(name = "userd_id")
	
	public Userd getUserd() {
		return userd;
	}
	public void setUserd(Userd userd) {
		this.userd = userd;
	}
	@ManyToOne
	@JoinColumn(name = "proposal_id")
	public Proposal getProposal() {
		return proposal;
	}
	public void setProposalId(Proposal proposal) {
		this.proposal = proposal;
	}
	
	public void setVote(boolean vote) {
		this.vote = vote;
	}
	
	@Column(name = "vote", columnDefinition = "BIT", length = 1)
	public boolean getVote() {
		return vote;
	}
	
	@Column(name = "vote_date")
	public Date getVoteDate() {
		return voteDate;
	}
	public void setVoteDate(Date voteDate) {
		this.voteDate = voteDate;
	}
	
	@Override
	public String toString() {
		return "Vote [voteId=" + voteId + ", userd=" + userd.getUserdId() + ", proposal="
				+ proposal.getProposalId() + ", vote=" + vote + ", voteDate=" + voteDate + "]";
	}

}
