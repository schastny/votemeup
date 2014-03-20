package up.voteme.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;



@Entity
public class Userd {
	@Override
	public String toString() {
		return "Userd [userdId=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthYear=" + birthYear
				+ ", sex=" + sex + ", registrationDate=" + registrationDate
				+ ", email=" + email + ", userLogin=" + login
				+ ", userPassword=" + password + ", role=" + role.getRoleId()
				+ ", userStatus=" + status.getId() + ", country=" + country.getCountryId()
				+ ", region=" + region.getRegionId() + ", city=" + city.getCityId() + ", district="
				+ district.getDistrictId() + ", proposals=" + proposals.size() + ", commentd="
				+ commentd.size() + ", votes=" + votes.size() + "]";
	}
	private long id;
	private String firstName;
	private String lastName;
	private int birthYear;
	private String sex ;// "male", "female"
	private Date registrationDate;
	private String email;
	private String login;
	private String password;
	private Role role; 
	private UserStatus status;
	private Country country;
	private Region region;
	private City city;
	private District district;
	
	private Collection<Proposal> proposals = new HashSet<>();
	private Collection<Comment> commentd = new HashSet<>();
	private Collection<Vote> votes = new HashSet<>();
	
	
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
	@Column(name = "id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	@Temporal(value = TemporalType.DATE)
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "login")
	public String getLogin() {
		return login;
	}
	public void setLogin(String userLogin) {
		this.login = userLogin;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String userPassword) {
		this.password = userPassword;
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
	
	@ManyToOne
	@JoinColumn(name = "user_status_id")
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus userStatus) {
		this.status = userStatus;
	}
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	@ManyToOne
	@JoinColumn(name = "region_id")
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	@ManyToOne
	@JoinColumn(name = "district_id")
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}

}
