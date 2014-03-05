package up.voteme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name="document")
public class Document {
	private long docId;
	private String docName;
	private String docUrl;
	private Proposal proposal;
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column (name = "doc_id")
	public long getDocId() {
		return docId;
	}
	public void setDocId(long docId) {
		this.docId = docId;
	}
	
	@Column (name = "doc_name")
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	
	
	@Column (name = "doc_url")
	public String getDocUrl() {
		return docUrl;
	}
	
	
	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}
	
	@ManyToOne
	@JoinColumn(name = "proposal_id")
	public Proposal getProposal() {
		return proposal;
	}
	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}
	
	@Override
	public String toString() {
		return "Document [docId=" + docId + ", docName=" + docName
				+  ", docUrl=" + docUrl
				+ ", proposal ID=" + proposal.getProposalId() 
				+ "]";
	}
}
