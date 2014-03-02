package up.voteme.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Attachment")
public class Attachment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String kind;
    private String docName;
    private String docUrl;
    
    private Collection<Proposal> proposal = new HashSet<>();
    
    @ManyToMany
	public Collection<Proposal> getProposal() {
		return proposal;
	}

	public void setProposal(Collection<Proposal> proposal) {
		this.proposal = proposal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocUrl() {
		return docUrl;
	}

	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}
    
}

