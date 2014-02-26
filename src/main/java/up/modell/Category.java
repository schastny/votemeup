package up.modell;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "category" )
public class Category  {
	private int categId;
	private String categName;
	
	public Category () {};
	
	//constructor to create instance for test purposes
	public Category (String categName){
		this.categName = categName;
	}
	
	@Override
	public String toString() {
		return "Category [categId=" + categId + ", categName=" + categName
				+ "]";
	}

	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	
	public int getCategId() {
		return categId;
	}

	public void setCategId(int categId) {
		this.categId = categId;
	}

	public String getCategName() {
		return categName;
	}

	public void setCategName(String categName) {
		this.categName = categName;
	}

	
	
	

}
