package up.voteme.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
import up.voteme.service.DistrictService;
import up.voteme.service.ProposalService;
import up.voteme.service.ProposalStatusService;
import up.voteme.service.RegionService;

public interface GuestPageModel {

	public abstract void reset();

	public abstract ProposalService getPropServ();

	public abstract void setPropServ(ProposalService propServ);

	public abstract CategoryService getCategServ();

	public abstract void setCategServ(CategoryService categServ);

	public abstract ProposalStatusService getStatusServ();

	public abstract void setStatusServ(ProposalStatusService statusServ);

	public abstract RegionService getRegionServ();

	public abstract void setRegionServ(RegionService regionServ);

	public abstract CityService getCityServ();

	public abstract void setCityServ(CityService cityServ);

	public abstract DistrictService getDistrictServ();

	public abstract void setDistrictServ(DistrictService districtServ);

	public abstract List<ProposalStatus> getStatusList();

	public abstract void setStatusList(List<ProposalStatus> statusList);

	public abstract int getSelectedPropStatusId();

	public abstract void setSelectedPropStatusId(int selectedPropStatusId);

	public abstract List<ProposalLevel> getLevelList();

	public abstract void setLevelList(List<ProposalLevel> levelList);

	public abstract int getSelectedPropLevelId();

	public abstract void setSelectedPropLevelId(int selectedPropLevelId);

	public abstract List<Category> getCategoryList();

	public abstract void setCategoryList(List<Category> categoryList);

	public abstract int getSelectedCategoryId();

	public abstract void setSelectedCategoryId(int selectedCategoryId);

	public abstract List<Country> getCountryList();

	public abstract void setCountryList(List<Country> countryList);

	public abstract int getSelectedCountryId();

	public abstract void setSelectedCountryId(int selectedCountryId);

	public abstract List<Region> getRegionList();

	public abstract void setRegionList(List<Region> regionList);

	public abstract int getSelectedRegionId();

	public abstract void setSelectedRegionId(int selectedRegionId);

	public abstract List<City> getCityList();

	public abstract void setCityList(List<City> cityList);

	public abstract int getSelectedCityId();

	public abstract void setSelectedCityId(int selectedCityId);

	public abstract List<District> getDistrictList();

	public abstract void setDistrictList(List<District> districtList);

	public abstract int getSelectedDistrictId();

	public abstract void setSelectedDistrictId(int selectedDistrictId);

	public abstract HashMap<String, String> getConfigMap();

	public abstract void setConfigMap(HashMap<String, String> configMap);

	public abstract long getPropCount();

	public abstract void setPropCount(long propCount);

	public abstract List<Proposal> getProposalList();

	public abstract void setProposalList(List<Proposal> proposalList);

	public abstract Date getCreationDate();

	public abstract void setCreationDate(Date creationDate);
	
	public String getSortBy();



	public void setSortBy(String sortBy) ;
	
	public int getPageQuant();



	public void setPageQuant(int pageQuant) ;


	public int getPageNum() ;


	public void setPageNum(int pageNum) ;


	public String getFiltrOn() ;


	public void setFiltrOn(String filtrOn) ;
	
	public String getLoginMes() ;


	public void setLoginMes(String loginMes) ;
	
	public void update() ;
	public void clearFiltr() ;
	


}