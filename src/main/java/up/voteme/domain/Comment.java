package up.voteme.domain;


import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: St1ch
 * Date: 27.02.14
 * Time: 13:04
 * Package name: up.voteme.domain
 * Project name: votemeup
 */
@Entity
@Table(name = "comment")
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Column(name = "author")
    public User getAuthor()
    {
        return author;
    }

    public void setAuthor(User author)
    {
        this.author = author;
    }

    @Column(name = "proposal")
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

    @Column(name = "publication_date")
    @Temporal(value= TemporalType.DATE)
    public Date getPublicationDate()
    {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate)
    {
        this.publicationDate = publicationDate;
    }
}
