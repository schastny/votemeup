package up.voteme.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Proposal {

	
	@Override
	public String toString() {
		return "Proposal [proposalId=" + proposalId + ", proposalName="
				+ ", comments.size=" + comments.size() 
				+ ", votes.size=" + votes.size()
				+ ", documents.size=" + documents.size() 
				+ ", categories.size=" + categories.size()
				+ "]";
	}
	private long proposalId;
	private String proposalName;
	private String proposalText;
	private String proposalResult;
	private Date creationDate;
	private ProposalStatus proposalStatus; 
	private ProposalLevel proposalLevel;    
	private Userd userd;		//FK to userd	many-to-one
	private Collection<Comment> comments = new HashSet<>(); //for one-to-many relation
	private Collection<Vote> votes = new HashSet<>();//for one-to-many relation
	private Collection<Document> documents = new HashSet<>();//for one-to-many relation
	private Collection<Category> categories = new HashSet<>();//many-to-many rel.
	
	
	@ManyToMany 
	 @JoinTable(
	            name = "proposal_category", 
	            joinColumns         = @JoinColumn(name = "proposal_id"), 
	            inverseJoinColumns     = @JoinColumn(name = "category_id"))
	public Collection<Category> getCategories() {
		return categories;
	}
	public void setCategories(Collection<Category> categories) {
		this.categories = categories;
	}
	
	@OneToMany (mappedBy = "proposal")
	public Collection<Comment> getComments() {
		return comments;
	}
	
	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column (name="proposal_id")
	public long getProposalId() {
		return proposalId;
	}
	public void setProposalId(long proposalId) {
		this.proposalId = proposalId;
	}
	
	@Column(name = "proposal_text",columnDefinition="text")
	public String getProposalText() {
		return proposalText;
	}
	public void setProposalText(String proposalText) {
		this.proposalText = proposalText;
	}
	
	@Column (name = "creation_date")
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Column (name = "proposal_name",columnDefinition="text")
	public String getProposalName() {
		return proposalName;
	}
	public void setProposalName(String proposalName) {
		this.proposalName = proposalName;
	}
	
	@Column (name = "proposal_result",columnDefinition="text")
	public String getProposalResult() {
		return proposalResult;
	}
	public void setProposalResult(String proposalResult) {
		this.proposalResult = proposalResult;
	}
	
	@ManyToOne
	@JoinColumn(name = "proposal_status_id")
	public ProposalStatus getProposalStatus() {
		return proposalStatus;
	}
	public void setProposalStatus(ProposalStatus proposalStatus) {
		this.proposalStatus = proposalStatus;
	}
	
	@ManyToOne
	@JoinColumn(name = "proposal_level_id")
	public ProposalLevel getProposalLevel() {
		return proposalLevel;
	}
	public void setProposalLevel(ProposalLevel proposalLevel) {
		this.proposalLevel = proposalLevel;
	}
	
	@ManyToOne
	@JoinColumn(name="userd_id")
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
	
	@OneToMany (mappedBy = "proposal")
	public Collection<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(Collection<Document> documents) {
		this.documents = documents;
	}

	

	
	
	
	
	
	
	
}
