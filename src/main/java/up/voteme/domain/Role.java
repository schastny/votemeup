package up.voteme.domain;

/**
 * Created with IntelliJ IDEA.
 * User: St1ch
 * Date: 27.02.14
 * Time: 12:55
 * Package name: up.voteme.domain
 * Project name: votemeup
 */
public class Role
{
    private int id;
    private String role;

    public Role()
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

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}
