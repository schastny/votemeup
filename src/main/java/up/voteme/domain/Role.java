package up.voteme.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: St1ch
 * Date: 27.02.14
 * Time: 12:55
 * Package name: up.voteme.domain
 * Project name: votemeup
 */
@Entity
@Table(name = "role")
public class Role
{
    private int id;
    private String role;

    public Role()
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

    @Column(name = "role")
    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}
