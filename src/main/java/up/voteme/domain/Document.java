package up.voteme.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Document {
	private int docId;
	private String docName;
	private String docDescr;
	private String docUrl;
	
	private Collection<Proposal> proposals = new HashSet <>();
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocDescr() {
		return docDescr;
	}
	public void setDocDescr(String docDescr) {
		this.docDescr = docDescr;
	}
	public String getDocUrl() {
		return docUrl;
	}
	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}
	
	@ManyToMany (mappedBy="documents")	
	public Collection<Proposal> getProposals() {
		return proposals;
	}
	public void setProposals(Collection<Proposal> proposals) {
		this.proposals = proposals;
	}

}
