package up.voteme.domain;

import java.util.Collection;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "CATEGORY" )
public class Category  {
	private int categId;
	private String categName;
	private Collection<Proposal> proposals= new HashSet<>(); 
	
	@OneToMany (mappedBy="category")
	public Collection<Proposal> getCategories() {
		return proposals;
	}

	public void setCategories(Collection<Proposal> proposals) {
		this.proposals = proposals;
	}

	public Category () {};
	
	//constructor for creating instances in test purposes
	public Category (String categName){
		this.categName = categName;
	}
	
	@Override
	public String toString() {
		return "Category [categId=" + categId + ", categName=" + categName
				+ "]";
	}

	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public int getCategId() {
		return categId;
	}

	public void setCategId(int categId) {
		this.categId = categId;
	}

	public String getCategName() {
		return categName;
	}

	public void setCategName(String categName) {
		this.categName = categName;
	}

	
	
	

}
