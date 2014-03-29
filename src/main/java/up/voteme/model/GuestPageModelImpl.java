package up.voteme.model;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import up.voteme.domain.Category;
import up.voteme.domain.City;
import up.voteme.domain.Country;
import up.voteme.domain.District;
import up.voteme.domain.Proposal;
import up.voteme.domain.ProposalLevel;
import up.voteme.domain.ProposalStatus;
import up.voteme.domain.Region;
import up.voteme.service.CategoryService;
import up.voteme.service.ProposalService;
import up.voteme.service.ProposalStatusService;

@Component
public class GuestPageModelImpl implements GuestPageModel {
	
	@Autowired
	ProposalService propServ;
	@Autowired
	CategoryService categServ;
	@Autowired
	ProposalStatusService statusServ;
	

	private List<ProposalStatus> statusList;
	private int selectedPropStatusId;
	private List<ProposalLevel> levelList;
	private int selectedPropLevelId;
	private List<Category> categoryList;
	private int selectedCategoryId;
	private List<Country> countryList;
	private int selectedCountryId;
	private List<Region> regionList;
	private int selectedRegionId;
	private List<City> cityList;
	private int selectedCityId;
	private List<District> districtList;
	private int selectedDistrictId;
	
	private Map<String,String> configMap;
	private long propCount;
	private List<Proposal> proposalList;	
	private Date creationDate;
	
	
	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#reset()
	 */
	@Override
	public  void reset(){
		propCount = propServ.countAll();
		proposalList = propServ.getAll();
		
		// for database to retrieve List<Proposal>
		configMap = new HashMap<>();
		
		//filtr form
		statusList = statusServ.getAllPS();
		selectedPropStatusId = 0;
		private List<ProposalLevel> levelList;
		private int selectedPropLevelId;
		private List<Category> categoryList;
		private int selectedCategoryId;
		private List<Country> countryList;
		private int selectedCountryId;
		private List<Region> regionList;
		private int selectedRegionId;
		private List<City> cityList;
		private int selectedCityId;
		private List<District> districtList;
		private int selectedDistrictId;
		
		
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getPropServ()
	 */
	@Override
	public ProposalService getPropServ() {
		return propServ;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setPropServ(up.voteme.service.ProposalService)
	 */
	@Override
	public void setPropServ(ProposalService propServ) {
		this.propServ = propServ;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getCategServ()
	 */
	@Override
	public CategoryService getCategServ() {
		return categServ;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setCategServ(up.voteme.service.CategoryService)
	 */
	@Override
	public void setCategServ(CategoryService categServ) {
		this.categServ = categServ;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getPropCount()
	 */
	@Override
	public long getPropCount() {
		return propCount;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setPropCount(long)
	 */
	@Override
	public void setPropCount(long propCount) {
		this.propCount = propCount;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getProposalList()
	 */
	@Override
	public List<Proposal> getProposalList() {
		return proposalList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setProposalList(java.util.List)
	 */
	@Override
	public void setProposalList(List<Proposal> proposalList) {
		this.proposalList = proposalList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getCreationDate()
	 */
	@Override
	public Date getCreationDate() {
		return creationDate;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setCreationDate(java.util.Date)
	 */
	@Override
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getStatusList()
	 */
	@Override
	public List<String> getStatusList() {
		return statusList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setStatusList(java.util.List)
	 */
	@Override
	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getCategoryList()
	 */
	@Override
	public List<Category> getCategoryList() {
		return categoryList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setCategoryList(java.util.List)
	 */
	@Override
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getSelectedCategoryId()
	 */
	@Override
	public int getSelectedCategoryId() {
		return selectedCategoryId;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setSelectedCategoryId(int)
	 */
	@Override
	public void setSelectedCategoryId(int selectedCategoryId) {
		this.selectedCategoryId = selectedCategoryId;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getLevelList()
	 */
	@Override
	public List<String> getLevelList() {
		return levelList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setLevelList(java.util.List)
	 */
	@Override
	public void setLevelList(List<String> levelList) {
		this.levelList = levelList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getCountryList()
	 */
	@Override
	public List<String> getCountryList() {
		return countryList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setCountryList(java.util.List)
	 */
	@Override
	public void setCountryList(List<String> countryList) {
		this.countryList = countryList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getRegionList()
	 */
	@Override
	public List<String> getRegionList() {
		return regionList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setRegionList(java.util.List)
	 */
	@Override
	public void setRegionList(List<String> regionList) {
		this.regionList = regionList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getCityList()
	 */
	@Override
	public List<String> getCityList() {
		return cityList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setCityList(java.util.List)
	 */
	@Override
	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getDistrictList()
	 */
	@Override
	public List<String> getDistrictList() {
		return districtList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setDistrictList(java.util.List)
	 */
	@Override
	public void setDistrictList(List<String> districtList) {
		this.districtList = districtList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getConfigMap()
	 */
	@Override
	public Map<String, String> getConfigMap() {
		return configMap;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setConfigMap(java.util.Map)
	 */
	@Override
	public void setConfigMap(Map<String, String> configMap) {
		this.configMap = configMap;
	}

}