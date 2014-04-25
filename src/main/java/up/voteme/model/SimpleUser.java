package up.voteme.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import up.voteme.domain.City;
import up.voteme.domain.Country;
import up.voteme.domain.District;
import up.voteme.domain.Region;
import up.voteme.domain.Role;
import up.voteme.domain.UserStatus;
import up.voteme.domain.Userd;
import up.voteme.service.UserdService;
import up.voteme.service.UserdServiceImpl;

@Component
public class SimpleUser implements Serializable  {
	
	
	private static final long serialVersionUID = 1L;
	private long userdId;
	private String firstName;
	private String lastName;
	private int birthYear;
	private String sex ;// "male", "female"
	private Date registrationDate;
	private String email;
	private String userLogin;
	private String userPassword;
	private String role; 
	private String userStatus;
	private String country;
	
	public SimpleUser(){}
	
	public SimpleUser (Userd user){
		this.userdId = user.getUserdId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.birthYear = user.getBirthYear();
		this.sex = user.getSex();
		this.registrationDate = user.getRegistrationDate();
		this.email = user.getEmail();
		this.userLogin = user.getUserLogin();
		this.userPassword = user.getUserPassword();
		this.role = user.getRole().getRoleName();
		this.userStatus = user.getUserStatus().getStatus();
		this.country = user.getCountry().getCountryName();
	}
	
	public boolean validate(){
		
		boolean isValid = false;
		if (firstName.length() >= 2 && firstName.length() <= 50) isValid = true;
		else return false;
		
		if (lastName.length() >= 2 && lastName.length()<=50) isValid = true;
		else return false;
		
		if (email.length() >= 2 && email.length()<=255) isValid = true;
		else return false;
		
		if (userLogin.length() >= 2 && userLogin.length()<=20) isValid = true;
		else return false;
		
		if (userPassword.length() == 40) isValid = true;
		else return false;
		
		Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date()); // your date
	    int curYear = cal.get(Calendar.YEAR);
	    int age = curYear - birthYear;
	    if (age >= 14 && age <= 120 ) isValid = true;
	    else return false;
		
	    if (sex.equals("муж")||sex.equals("жен")) isValid = true;
	    else return false;
	    

		return isValid;
	}
	
	public long getUserdId() {
		return userdId;
	}
	public void setUserdId(long userdId) {
		this.userdId = userdId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "SimpleUser [userdId=" + userdId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthYear=" + birthYear
				+ ", sex=" + sex + ", registrationDate=" + registrationDate
				+ ", email=" + email + ", userLogin=" + userLogin
				+ ", userPassword=" + userPassword + ", role=" + role
				+ ", userStatus=" + userStatus + ", country=" + country + "]";
	}
	
	

	
}
