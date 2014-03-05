package up.voteme.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class Category {
	
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "Category")
    private String category;

    @ManyToMany
    @JoinTable(
            name = "category_proposal", 
            joinColumns         = @JoinColumn(name = "Proposal_id", referencedColumnName = "id"), 
            inverseJoinColumns     = @JoinColumn(name = "Category_id", referencedColumnName = "id"))
    private List<Proposal> proposals;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}
	

}
