package up.voteme.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;



@Entity
public class Userd {
	private long userdId;
	private String firstName;
	private String lastName;
	private int birthYear;
	private String sex ;// "male", "female"
	private Date registrationDate;
	private String city;
	private String email;
	private String userLogin;
	private String userPassword;
	private Collection<Proposal> proposals = new HashSet<>();
	private Collection<Comment> commentd = new HashSet<>();
	private Collection<Vote> votes = new HashSet<>();
	private Role role; 
	
	@OneToMany (mappedBy = "userd")
	public Collection<Comment> getCommentd() {
		return commentd;
	}
	public void setCommentd(Collection<Comment> comments) {
		this.commentd = comments;
	}
	@OneToMany (mappedBy = "userd")
	public Collection<Proposal> getProposals() {
		return proposals;
	}
	public void setProposals(Collection<Proposal> proposals) {
		this.proposals = proposals;
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "userd_id")
	public long getUserdId() {
		return userdId;
	}
	public void setUserdId(long userdId) {
		this.userdId = userdId;
	}
	
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "birth_year")
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name = "registration_date")
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "user_login")
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	
	@Column(name = "user_password")
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	@OneToMany (mappedBy="userd")
	public Collection<Vote> getVotes() {
		return votes;
	}
	public void setVotes(Collection<Vote> votes) {
		this.votes = votes;
	}
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
