package up.voteme.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import up.voteme.domain.Category;
import up.voteme.domain.Proposal;
import up.voteme.service.CategoryService;
import up.voteme.service.ProposalService;

public interface GuestPageModel {

	public abstract void reset();

	public abstract ProposalService getPropServ();

	public abstract void setPropServ(ProposalService propServ);

	public abstract CategoryService getCategServ();

	public abstract void setCategServ(CategoryService categServ);

	public abstract long getPropCount();

	public abstract void setPropCount(long propCount);

	public abstract List<Proposal> getProposalList();

	public abstract void setProposalList(List<Proposal> proposalList);

	public abstract Date getCreationDate();

	public abstract void setCreationDate(Date creationDate);

	public abstract List<String> getStatusList();

	public abstract void setStatusList(List<String> statusList);

	public abstract List<Category> getCategoryList();

	public abstract void setCategoryList(List<Category> categoryList);

	public abstract int getSelectedCategoryId();

	public abstract void setSelectedCategoryId(int selectedCategoryId);

	public abstract List<String> getLevelList();

	public abstract void setLevelList(List<String> levelList);

	public abstract List<String> getCountryList();

	public abstract void setCountryList(List<String> countryList);

	public abstract List<String> getRegionList();

	public abstract void setRegionList(List<String> regionList);

	public abstract List<String> getCityList();

	public abstract void setCityList(List<String> cityList);

	public abstract List<String> getDistrictList();

	public abstract void setDistrictList(List<String> districtList);

	public abstract Map<String, String> getConfigMap();

	public abstract void setConfigMap(Map<String, String> configMap);

}