package up.voteme.domain;

/**
 * Created with IntelliJ IDEA.
 * User: St1ch
 * Date: 27.02.14
 * Time: 13:08
 * Package name: up.voteme.domain
 * Project name: votemeup
 */
public class Category
{
    private int id;

    private String title;

    public Category()
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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
