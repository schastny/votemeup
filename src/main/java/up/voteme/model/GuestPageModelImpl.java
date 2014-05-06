package up.voteme.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
import up.voteme.service.CityService;
import up.voteme.service.CountryService;
import up.voteme.service.DistrictService;
import up.voteme.service.ProposalLevelService;
import up.voteme.service.ProposalService;
import up.voteme.service.ProposalStatusService;
import up.voteme.service.RegionService;


@Component
@Scope("session")
public class GuestPageModelImpl implements GuestPageModel  {
	
	@Autowired
	ProposalService propServ;
	@Autowired
	CategoryService categServ;
	@Autowired
	ProposalStatusService statusServ;
	@Autowired
	ProposalLevelService levelServ;
	@Autowired
	CountryService countryServ;
	@Autowired
	RegionService regionServ;
	@Autowired
	CityService cityServ;
	@Autowired
	DistrictService districtServ;

	private static final Logger logger = LoggerFactory
			.getLogger(GuestPageModelImpl.class);
	
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
	
	private HashMap<String,String> configMap;
	private long propCount;
	private List<Proposal> proposalList;
	private String sortBy;
	private int pageQuant; // proposals to display - 5, 10, 15.
	private int pageNum;   // current page number.		
	private int pagesTotal; // total pages.
	private Date creationDate;
	private String filtrOn;
	private String loginMes;
	private String proposalActionMes;
	
	public GuestPageModelImpl(){
		logger.debug("GuestPageModel constructor");
	}


	@Override
	public  void reset(){

		//filtr form
		filtrOn = "false";
		statusList = statusServ.getAllPS();
		levelList = levelServ.findAll();					
		categoryList = categServ.getAll();
		countryList = countryServ.findAll();  
		regionList = new ArrayList<>();
		cityList = new ArrayList<>();
		districtList = new ArrayList<>();
		
		clearFiltr();
		
		// for database to retrieve RequestResult
		configMap = new HashMap<>();
		sortBy = "noSort";
		loginMes = "";
		proposalActionMes = "";
		pageNum = 1;
		pageQuant = 5;
		update();
	}
	
	@Override
	public void clearFiltr() {
		selectedPropStatusId = 0;	
		selectedPropLevelId = 0;
		selectedCategoryId = 0;
		selectedCountryId = 0;
		selectedRegionId = 0;
		selectedCityId = 0;
		selectedDistrictId = 0;
		regionList.clear();
		cityList.clear(); 
		districtList.clear();
	}

	
	public  void update(){

		configMap.put("sortBy", sortBy);
		configMap.put("pageNum", String.valueOf(pageNum));
		configMap.put("pageQuant", String.valueOf(pageQuant));
		configMap.put("filterByLevelId", String.valueOf(selectedPropLevelId));
		configMap.put("filterByStatusId", String.valueOf(selectedPropStatusId));
		configMap.put("filterByCategoryId", String.valueOf(selectedCategoryId));
		configMap.put("filterByCountryId", String.valueOf(selectedCountryId));
		configMap.put("filterByRegionId", String.valueOf(selectedRegionId));
		configMap.put("filterByCityId", String.valueOf(selectedCityId));
		configMap.put("filterByDistrictId", String.valueOf(selectedDistrictId));
		
		RequestResult result = propServ.findByParams(configMap);
		propCount = result.count;
		int num = (int) propCount/pageQuant;
		pagesTotal = (propCount % pageQuant != 0) ? (num + 1) : num;
		proposalList = result.list;
		propCount = propServ.countAll();
	}
	
	

	public String getSortBy() {
		return sortBy;
	}



	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
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
	 * @see up.voteme.model.GuestPageModel#getStatusServ()
	 */
	@Override
	public ProposalStatusService getStatusServ() {
		return statusServ;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setStatusServ(up.voteme.service.ProposalStatusService)
	 */
	@Override
	public void setStatusServ(ProposalStatusService statusServ) {
		this.statusServ = statusServ;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getRegionServ()
	 */
	@Override
	public RegionService getRegionServ() {
		return regionServ;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setRegionServ(up.voteme.service.RegionService)
	 */
	@Override
	public void setRegionServ(RegionService regionServ) {
		this.regionServ = regionServ;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getCityServ()
	 */
	@Override
	public CityService getCityServ() {
		return cityServ;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setCityServ(up.voteme.service.CityService)
	 */
	@Override
	public void setCityServ(CityService cityServ) {
		this.cityServ = cityServ;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getDistrictServ()
	 */
	@Override
	public DistrictService getDistrictServ() {
		return districtServ;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setDistrictServ(up.voteme.service.DistrictService)
	 */
	@Override
	public void setDistrictServ(DistrictService districtServ) {
		this.districtServ = districtServ;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getStatusList()
	 */
	@Override
	public List<ProposalStatus> getStatusList() {
		return statusList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setStatusList(java.util.List)
	 */
	@Override
	public void setStatusList(List<ProposalStatus> statusList) {
		this.statusList = statusList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getSelectedPropStatusId()
	 */
	@Override
	public int getSelectedPropStatusId() {
		return selectedPropStatusId;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setSelectedPropStatusId(int)
	 */
	@Override
	public void setSelectedPropStatusId(int selectedPropStatusId) {
		this.selectedPropStatusId = selectedPropStatusId;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getLevelList()
	 */
	@Override
	public List<ProposalLevel> getLevelList() {
		return levelList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setLevelList(java.util.List)
	 */
	@Override
	public void setLevelList(List<ProposalLevel> levelList) {
		this.levelList = levelList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getSelectedPropLevelId()
	 */
	@Override
	public int getSelectedPropLevelId() {
		return selectedPropLevelId;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setSelectedPropLevelId(int)
	 */
	@Override
	public void setSelectedPropLevelId(int selectedPropLevelId) {
		this.selectedPropLevelId = selectedPropLevelId;
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
	 * @see up.voteme.model.GuestPageModel#getCountryList()
	 */
	@Override
	public List<Country> getCountryList() {
		return countryList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setCountryList(java.util.List)
	 */
	@Override
	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getSelectedCountryId()
	 */
	@Override
	public int getSelectedCountryId() {
		return selectedCountryId;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setSelectedCountryId(int)
	 */
	@Override
	public void setSelectedCountryId(int selectedCountryId) {
		this.selectedCountryId = selectedCountryId;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getRegionList()
	 */
	@Override
	public List<Region> getRegionList() {
		return regionList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setRegionList(java.util.List)
	 */
	@Override
	public void setRegionList(List<Region> regionList) {
		this.regionList = regionList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getSelectedRegionId()
	 */
	@Override
	public int getSelectedRegionId() {
		return selectedRegionId;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setSelectedRegionId(int)
	 */
	@Override
	public void setSelectedRegionId(int selectedRegionId) {
		this.selectedRegionId = selectedRegionId;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getCityList()
	 */
	@Override
	public List<City> getCityList() {
		return cityList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setCityList(java.util.List)
	 */
	@Override
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getSelectedCityId()
	 */
	@Override
	public int getSelectedCityId() {
		return selectedCityId;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setSelectedCityId(int)
	 */
	@Override
	public void setSelectedCityId(int selectedCityId) {
		this.selectedCityId = selectedCityId;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getDistrictList()
	 */
	@Override
	public List<District> getDistrictList() {
		return districtList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setDistrictList(java.util.List)
	 */
	@Override
	public void setDistrictList(List<District> districtList) {
		this.districtList = districtList;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getSelectedDistrictId()
	 */
	@Override
	public int getSelectedDistrictId() {
		return selectedDistrictId;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setSelectedDistrictId(int)
	 */
	@Override
	public void setSelectedDistrictId(int selectedDistrictId) {
		this.selectedDistrictId = selectedDistrictId;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getConfigMap()
	 */
	@Override
	public HashMap<String, String> getConfigMap() {
		return configMap;
	}



	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setConfigMap(java.util.Map)
	 */
	@Override
	public void setConfigMap(HashMap<String, String> configMap) {
		this.configMap = configMap;
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



	

	public String getFiltrOn() {
		return filtrOn;
	}



	public void setFiltrOn(String filtrOn) {
		this.filtrOn = filtrOn;
	}


	public ProposalLevelService getLevelServ() {
		return levelServ;
	}


	public void setLevelServ(ProposalLevelService levelServ) {
		this.levelServ = levelServ;
	}


	public CountryService getCountryServ() {
		return countryServ;
	}


	public void setCountryServ(CountryService countryServ) {
		this.countryServ = countryServ;
	}


	public int getPageQuant() {
		return pageQuant;
	}


	public void setPageQuant(int pageQuant) {
		this.pageQuant = pageQuant;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getPagesTotal() {
		return pagesTotal;
	}


	public void setPagesTotal(int pagesTotal) {
		this.pagesTotal = pagesTotal;
	}


	public String getLoginMes() {
		return loginMes;
	}


	public void setLoginMes(String loginMes) {
		this.loginMes = loginMes;
	}


	public String getProposalActionMes() {
		return proposalActionMes;
	}


	public void setProposalActionMes(String proposalActionMes) {
		this.proposalActionMes = proposalActionMes;
	}


}