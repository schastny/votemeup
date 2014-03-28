package up.voteme.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity 
@Table (name = "commentd")
public class Comment {
	
	
	private long commentId;
	private Userd userd;
	private Proposal proposal;
	private String commentText;
	private Date commentDate;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column (name = "comment_id")
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	
	@Column (name="comment_text",columnDefinition="text")
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
	@Column (name="comment_date")
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	@ManyToOne 
	@JoinColumn (name="userd_id")
	public Userd getUserd() {
		return userd;
	}
	public void setUserd(Userd userd) {
		this.userd = userd;
	}
	
	@ManyToOne
	@JoinColumn (name="proposal_id")
	public Proposal getProposal() {
		return proposal;
	}
	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", userd=" + userd.getUserdId()
				+ ", proposal=" + proposal.getProposalId() + ", commentText=" + commentText
				+ ", commentDate=" + commentDate + "]";
	}
}
