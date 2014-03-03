package up.voteme.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: St1ch
 * Date: 27.02.14
 * Time: 13:02
 * Package name: up.voteme.domain
 * Project name: votemeup
 */
@Entity
@Table(name = "attachment")
public class Attachment
{
    private int id;

    private Proposal proposal;
    private String url;
    private String path;

    public Attachment()
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

    @Column(name = "url")
    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    @Column(name = "path")
    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
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
}
