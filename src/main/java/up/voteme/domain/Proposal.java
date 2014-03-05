package up.voteme.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Proposal")
public class Proposal {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "DataCreate")
    private String dataCreate;
    
    @Column(name = "DateEnd")
    private String dateEnd;

    @Column(name = "Description")
    private String description;

    @Column(name = "Improvement")
    private String improvement;

    @Column(name = "TotalYes")
    private int totalYes;

    @Column(name = "TotalNo")
    private int totalNo;
    
    @ManyToOne
    @JoinColumn(name = "Level_id")
    private Level level;

    @OneToMany(mappedBy = "proposal")
    private List<Attachment> attachments;

    @ManyToMany(mappedBy = "proposal")
    private List<Category> categoryes;
    
    @OneToMany(mappedBy = "proposal")
    private List<VoteProposal> voteProposals;

    
    @ManyToOne
    @JoinColumn(name = "Author")
    private User user;

    @OneToMany(mappedBy = "proposal")
    private List<Comment> comments;
    
    
    public List<Category> getCategoryes() {
		return categoryes;
	}

	public void setCategoryes(List<Category> categoryes) {
		this.categoryes = categoryes;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDataCreate() {
		return dataCreate;
	}

	public void setDataCreate(String dataCreate) {
		this.dataCreate = dataCreate;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImprovement() {
		return improvement;
	}

	public void setImprovement(String improvement) {
		this.improvement = improvement;
	}

	public int getTotalYes() {
		return totalYes;
	}

	public void setTotalYes(int totalYes) {
		this.totalYes = totalYes;
	}

	public int getTotalNo() {
		return totalNo;
	}

	public void setTotalNo(int totalNo) {
		this.totalNo = totalNo;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}


}