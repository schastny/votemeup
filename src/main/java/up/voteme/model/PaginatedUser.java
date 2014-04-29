package up.voteme.model;

import java.util.List;


public class PaginatedUser {
	
	private List<SimpleUser> users;
	private int totalRecords;
	
	public List<SimpleUser> getUsers() {
		return users;
	}
	public void setUsers(List<SimpleUser> users) {
		this.users = users;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

}
