package up.voteme.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "CommentText")
    private String commentText;

    @Column(name = "CommentDate")
    private String commentDate;

    @Column(name = "CommentDelete")
    private boolean commentDelete;
    
    @ManyToOne
    @JoinColumn(name = "CommentAuthor")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "Proposal_id")
    private Proposal proposal;
    
    @OneToMany(mappedBy = "comment")
    private List<Comment> comments;
    
    @ManyToOne
    @JoinColumn(name = "CommentParent")
    private Comment comment;
    
}
