package up.voteme.domain;


import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: St1ch
 * Date: 27.02.14
 * Time: 13:08
 * Package name: up.voteme.domain
 * Project name: votemeup
 */
@Entity
@Table(name = "category")
public class Category
{
    private int id;
    private String title;

    public Category()
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

    @Column(name = "title")
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
