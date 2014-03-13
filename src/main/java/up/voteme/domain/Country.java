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
public class Country {
	
	private long countryId;
	private String countryName;
	private Collection<Region> regions = new HashSet<>();
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column (name="country_id")
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	
	@Column (name = "country_name")
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	@OneToMany (mappedBy = "country")
	public Collection<Region> getRegions() {
		return regions;
	}
	public void setRegions(Collection<Region> regions) {
		this.regions = regions;
	}
	
	@Override
	public String toString() {
		//return "Country [countryId=" + countryId + ", countryName="
		//		+ countryName + ", regions.size()=" + regions.size() + "]";

		return "Country [countryId=" + countryId + ", countryName="+ countryName+ "]";
	
	}

}
