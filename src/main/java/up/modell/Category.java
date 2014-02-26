package up.modell;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category implements Serializable {
	
	@Id
	private int categId;
	private int categName;
	
	public int getCategId() {
		return categId;
	}

	public void setCategId(int categId) {
		this.categId = categId;
	}

	public int getCategName() {
		return categName;
	}

	public void setCategName(int categName) {
		this.categName = categName;
	}

	
	
	

}
