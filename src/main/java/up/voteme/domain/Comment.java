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
 * Time: 13:04
 * Package name: up.voteme.domain
 * Project name: votemeup
 */
public class Comment
{
    private int id;

    private User author;
    private Proposal proposal;

    private String content;
    private Date publicationDate;

    public Comment()
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

    @Column(name = "date")
    public Date getPublicationDate()
    {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate)
    {
        this.publicationDate = publicationDate;
    }

    @Column(name = "user_id")
    public User getAuthor()
    {
        return author;
    }

    public void setAuthor(User author)
    {
        this.author = author;
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

    @Column(name = "content")
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
}
