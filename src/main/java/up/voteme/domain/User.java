package up.voteme.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: St1ch
 * Date: 27.02.14
 * Time: 1:20
 * Package name: up.voteme.domain
 * Project name: votemeup
 */
@Entity
@Table(name = "USER")
public class User
{
    private int id;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String city;

    private String login;
    private String password;
    private String email;

    private Role role;
    private Set<Proposal> proposals = new HashSet<>();
    private Set<Comment> comments = new HashSet<>();
    private Set<Vote> votes = new HashSet<>();

    public User()
    {
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Column(name = "date_of_birth")
    @Temporal(value = TemporalType.DATE)
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "city")
    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    @Column(name = "login")
    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    @Column(name = "password")
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Column(name = "email")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    @OneToMany(mappedBy = "author")
    public Set<Proposal> getProposals()
    {
        return proposals;
    }

    public void setProposals(Set<Proposal> proposals)
    {
        this.proposals = proposals;
    }

    @OneToMany(mappedBy = "author")
    public Set<Comment> getComments()
    {
        return comments;
    }

    public void setComments(Set<Comment> comments)
    {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "user")
    public Set<Vote> getVotes()
    {
        return votes;
    }

    public void setVotes(Set<Vote> votes)
    {
        this.votes = votes;
    }
}
