package up.voteme.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
    @Column(name = "id")
    private int id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;
    
    @Column(name = "Role")
    private String role;
    
    @Column(name = "Login")
    private String login;
    
    @Column(name = "Password")
    private String password;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "CodeConfirmation")
    private String codeConfirmation;

    @Column(name = "ReportNewProposal")
    private boolean reportNewProposal;

    @Column(name = "ReportNewComment")
    private boolean reportNewComment;

    @Column(name = "ReportNewCommentAuthor")
    private boolean reportNewCommentAuthor;

    //в базе это поле Enum
    @Column(name = "PeriodReport")
    private String periodReport;

    @Column(name = "DateBirthday")
    private String dateBirthday;
    
    @Column(name = "DateRegistration")
    private String dateRegistration;

    //в базе это поле Enum
    @Column(name = "Gender")
    private String gender;
    
    @Column(name = "ProposalBan")
    private String proposalBan;

    @Column(name = "CommentBan")
    private String commentBan;
    
    @OneToMany(mappedBy = "user")
    private List<VoteProposal> voteProposals;
    
    @OneToMany(mappedBy = "user")
    private List<Proposal> proposals;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    
    
}
