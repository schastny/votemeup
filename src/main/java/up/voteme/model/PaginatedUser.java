package up.voteme.model;

import java.util.List;


public class PaginatedUser {
	
	private List<SimpleUser> users;
	private long totalRecords;
	
	public List<SimpleUser> getUsers() {
		return users;
	}
	public void setUsers(List<SimpleUser> users) {
		this.users = users;
	}
	public long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

}
