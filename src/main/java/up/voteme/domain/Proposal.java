package up.voteme.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Proposal {

	
	private int proposalId;
	private String proposalText;
	private Date creationDate;
	private Date voteStartDate;
	private String proposalStatus; // "active", "complete", "inChecking"
	private String proposalLevel;  // "local", "region", "state"
	//private int userdId;	
	//private int categId;	
	private Category category; //FK to category many-to-one
	private Userd userd;		//FK to userd	many-to-one
	private Collection<Commentd> comments = new HashSet<>(); //for one-to-many relation
	private Collection<Vote> votes = new HashSet<>();//for one-to-many relation
	//many-to-many rel. join table: PROPOSAL_DOCUMENT, FK: DOCUMENTS_DOCUMENTID, PROPOSALS_PROPOSALID 
	private Collection<Document> documents = new HashSet<>();
	
	
	@OneToMany (mappedBy = "proposal")
	public Collection<Commentd> getComments() {
		return comments;
	}
	public void setComments(Collection<Commentd> comments) {
		this.comments = comments;
	}
	@ManyToOne
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
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
	
	@ManyToOne
	public Userd getUserd() {
		return userd;
	}
	public void setUserd(Userd userd) {
		this.userd = userd;
	}
	@OneToMany (mappedBy = "userd")
	public Collection<Vote> getVotes() {
		return votes;
	}
	public void setVotes(Collection<Vote> votes) {
		this.votes = votes;
	}
	
	@ManyToMany
	public Collection<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(Collection<Document> documents) {
		this.documents = documents;
	}

	

	
	
	
	
	
	
	
}
