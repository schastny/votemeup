package up.voteme.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;



@Entity
public class Userd {
	private int userdId;
	private String firstName;
	private String secondName;
	private String lastName;
	private int birthYear;
	private String sex ;// "male", "female"
	private Date registrationDate;
	private String city;
	private String email;
	private String userLogin;
	private String userPassword;
	private Collection<Proposal> proposals = new HashSet<>();
	private Collection<Commentd> commentd = new HashSet<>();
	private Collection<Vote> votes = new HashSet<>();
	
	//many-to-many rel. join table: USERD_ROLE, FK: ROLES_ROLEID, USERS_USERDID 
	private Collection<Role> roles = new HashSet<>(); 
	
	@OneToMany (mappedBy = "userd")
	public Collection<Commentd> getCommentd() {
		return commentd;
	}
	public void setCommentd(Collection<Commentd> comments) {
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
	public int getUserdId() {
		return userdId;
	}
	public void setUserdId(int userdId) {
		this.userdId = userdId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
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
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
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
	
	@ManyToMany 
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}
