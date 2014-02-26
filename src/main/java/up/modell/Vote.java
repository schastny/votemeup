package up.modell;

import java.util.Date;

public class Vote {
	private int userdId;
	private int proposalId;
	private String vote; //"yes", "no"
	private Date voteDate;
	
	
	public int getUserdId() {
		return userdId;
	}
	public void setUserdId(int userdId) {
		this.userdId = userdId;
	}
	public int getProposalId() {
		return proposalId;
	}
	public void setProposalId(int proposalId) {
		this.proposalId = proposalId;
	}
	public String getVote() {
		return vote;
	}
	public void setVote(String vote) {
		this.vote = vote;
	}
	public Date getVoteDate() {
		return voteDate;
	}
	public void setVoteDate(Date voteDate) {
		this.voteDate = voteDate;
	}

}
