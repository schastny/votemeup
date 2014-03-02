package domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Proposal")
public class Proposal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String Title;
	private Date date;
	private String improvment;
	private String propLevel;

	private User user;
	private Category category;
	private Collection<Comment> comment = new HashSet<>();
	private Collection<Vote> vote = new HashSet<>();
	private Collection<Attachment> attachment = new HashSet<>();

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(mappedBy = "Proposal")
	public Collection<Comment> getComment() {
		return comment;
	}

	public void setComment(Collection<Comment> comment) {
		this.comment = comment;
	}

	@OneToMany(mappedBy = "user")
	public Collection<Vote> getVote() {
		return vote;
	}

	public void setVote(Collection<Vote> vote) {
		this.vote = vote;
	}

	@ManyToMany
	public Collection<Attachment> getAttachment() {
		return attachment;
	}

	public void setAttachment(Collection<Attachment> attachment) {
		this.attachment = attachment;
	}

	@ManyToOne
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImprovment() {
		return improvment;
	}

	public void setImprovment(String improvment) {
		this.improvment = improvment;
	}

	public String getPropLevel() {
		return propLevel;
	}

	public void setPropLevel(String propLevel) {
		this.propLevel = propLevel;
	}
}