package up.voteme.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String FirstName;
	private String LastName;
	private String login;
	private String password;
	private String email;
	private String city;
	private String gender;
	private Collection<Proposal> proposal = new HashSet<>();
	private Collection<Comment> comment = new HashSet<>();
	private Collection<Vote> vote = new HashSet<>();
    private Roles role;
	
    @ManyToOne
	public Roles getRoles() {
		return role;
	}

	public void setURoles(Roles role) {
		this.role = role;
	}
    
    
	@OneToMany(mappedBy = "User")
	public Collection<Proposal> getProposal() {
		return proposal;
	}

	public void setProposal(Collection<Proposal> proposal) {
		this.proposal = proposal;
	}

	@OneToMany(mappedBy = "User")
	public Collection<Comment> getComment() {
		return comment;
	}

	public void setComment(Collection<Comment> comment) {
		this.comment = comment;
	}

	@OneToMany(mappedBy = "User")
	public Collection<Vote> getVote() {
		return vote;
	}

	public void setVote(Collection<Vote> vote) {
		this.vote = vote;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

