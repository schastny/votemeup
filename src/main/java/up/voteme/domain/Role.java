package up.voteme.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Role {
	
	private long roleId;
	private String roleName;
	private String roleDescr;
	private Collection<Userd> users = new HashSet<>();
	
	@OneToMany(mappedBy="role")
	public Collection<Userd> getUsers() {
		return users;
	}
	public void setUsers(Collection<Userd> users) {
		this.users = users;
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "role_id")
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	@Column(name = "role_name")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Column(name = "role_description")
	public String getRoleDescr() {
		return roleDescr;
	}
	public void setRoleDescr(String roleDescr) {
		this.roleDescr = roleDescr;
	}
	
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", roleDescr=" + roleDescr + ", users=" + users.size() + "]";
	}

}
