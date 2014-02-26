package up.modell;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Proposal implements Serializable {

	@Id
	private int proposalId;
	private String proposalText;
	private Date creationDate;
	private Date voteStartDate;
	private String proposalStatus; // "active", "complete", "inChecking"
	private String proposalLevel;  // "local", "region", "state"
	private int userdId;
	private int categId;
	public int getProposalId() {
		return proposalId;
	}
	public void setProposalId(int proposalId) {
		this.proposalId = proposalId;
	}
	public String getProposalText() {
		return proposalText;
	}
	public void setProposalText(String proposalText) {
		this.proposalText = proposalText;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getVoteStartDate() {
		return voteStartDate;
	}
	public void setVoteStartDate(Date voteStartDate) {
		this.voteStartDate = voteStartDate;
	}
	public String getProposalStatus() {
		return proposalStatus;
	}
	public void setProposalStatus(String proposalStatus) {
		this.proposalStatus = proposalStatus;
	}
	public String getProposalLevel() {
		return proposalLevel;
	}
	public void setProposalLevel(String proposalLevel) {
		this.proposalLevel = proposalLevel;
	}
	public int getUserdId() {
		return userdId;
	}
	public void setUserdId(int userdId) {
		this.userdId = userdId;
	}
	public int getCategId() {
		return categId;
	}
	public void setCategId(int categId) {
		this.categId = categId;
	}
	
	
	
	
	
	
	
}
