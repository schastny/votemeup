package up.voteme.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Region {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column (name="region_id")
	private long regionId ;

	
	@Column (name = "region_name")
	private String regionName;

	@ManyToOne
	@JoinColumn (name = "country_id")
	private Country country;

	
	@OneToMany (mappedBy = "region")
	private Collection<City> cities = new HashSet<>();
	
	public long getRegionId() {
		return regionId;
	}
	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}
	
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Collection<City> getCities() {
		return cities;
	}
	public void setCities(Collection<City> cities) {
		this.cities = cities;
	}
	
	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionName=" + regionName
				+ ", country=" + country.getCountryId() + ", cities=" + cities.size() + "]";
	}

}
