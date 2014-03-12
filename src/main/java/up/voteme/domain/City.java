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
public class City {
	
	private long cityId ;
	private Region region;
	private String cityName;
	private Collection<District> districts = new HashSet<>();
	
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column (name="city_id")
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "region_id")
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
	@Column (name = "city_name")
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@OneToMany (mappedBy = "city")
	public Collection<District> getDistricts() {
		return districts;
	}
	public void setDistricts(Collection<District> districts) {
		this.districts = districts;
	}
	
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", region=" + region.getRegionId() + ", cityName="
				+ cityName + ", districts.size()=" + districts.size() + "]";
	}
}
