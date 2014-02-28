package up.voteme.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: St1ch
 * Date: 27.02.14
 * Time: 13:06
 * Package name: up.voteme.domain
 * Project name: votemeup
 */
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
    @Column(name = "id")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Column(name = "user_id")
    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Column(name = "proposal_id")
    public Proposal getProposal()
    {
        return proposal;
    }

    public void setProposal(Proposal proposal)
    {
        this.proposal = proposal;
    }

    @Column(name = "date")
    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
}
