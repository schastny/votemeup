package up.voteme.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: St1ch
 * Date: 27.02.14
 * Time: 13:06
 * Package name: up.voteme.domain
 * Project name: votemeup
 */
@Entity
@Table(name = "VOTE")
public class Vote
{
    private int id;

    private User user;
    private Proposal proposal;
    private Date date;

    public Vote()
    {
    }

    @Id
    @Column(name = "vote_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "proposal_id")
    public Proposal getProposal()
    {
        return proposal;
    }

    public void setProposal(Proposal proposal)
    {
        this.proposal = proposal;
    }

    @Column(name = "date")
    @Temporal(value = TemporalType.DATE)
    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
}
