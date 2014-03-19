package up.voteme.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "category" )
public class Category  {
	private long categId;
	private String categName;
	private Collection<Proposal> proposals= new HashSet<>(); 
	

	@ManyToMany (mappedBy = "categories")
	@Column (name="proposal_id")
	public Collection<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(Collection<Proposal> proposals) {
		this.proposals = proposals;
	}

	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column (name="category_id")
	public long getCategId() {
		return categId;
	}

	public void setCategId(long categId) {
		this.categId = categId;
	}

	@Column (name="category_name")
	public String getCategName() {
		return categName;
	}

	public void setCategName(String categName) {
		this.categName = categName;
	}

	
	
	@Override
	public String toString() {
		return "Category [categId=" + categId + ", categName=" + categName
				+"]";
	}

}
