package up.voteme.domain;

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

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Proposal getProposal()
    {
        return proposal;
    }

    public void setProposal(Proposal proposal)
    {
        this.proposal = proposal;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
}
