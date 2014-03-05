package up.voteme.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Roles")
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String roleName;
	private String roleDescrirtion;
	private Collection<User> user = new HashSet<>();
	
	@OneToMany(mappedBy = "Roles")
	public Collection<User> getUser() {
		return user;
	}

	public void setUser(Collection<User> user) {
		this.user = user;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescrirtion() {
		return roleDescrirtion;
	}

	public void setRoleDescrirtion(String roleDescrirtion) {
		this.roleDescrirtion = roleDescrirtion;
	}

}

