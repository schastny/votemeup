package up.voteme.domain;


import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: St1ch
 * Date: 27.02.14
 * Time: 13:00
 * Package name: up.voteme.domain
 * Project name: votemeup
 */
@Entity
@Table(name = "proposal")
public class Proposal
{
    private int id;

    private User author;
    private String title;
    private String content;

    private Date publicationDate;
    private Date dueDate;

    private Attachment attachment;

    public Proposal()
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

    @Column(name = "title")
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
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

    @Column(name = "pulication_date")
    @Temporal(value=TemporalType.DATE)
    public Date getPublicationDate()
    {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate)
    {
        this.publicationDate = publicationDate;
    }

    @Column(name = "due_date")
    @Temporal(value=TemporalType.DATE)
    public Date getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }

    @Column(name = "attachment")
    public Attachment getAttachment()
    {
        return attachment;
    }

    public void setAttachment(Attachment attachment)
    {
        this.attachment = attachment;
    }
}
