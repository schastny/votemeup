package up.voteme.model;

import java.util.Date;
import java.util.List;

import up.voteme.domain.Proposal;
import up.voteme.service.ProposalService;

public interface GuestPageModel {

	public abstract List<String> getStatusList();

	public abstract void setStatusList(List<String> statusList);

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

	public abstract ProposalService getPropServ();

	public abstract void setPropServ(ProposalService propServ);

	public abstract void initialize(Date date);
	
	public abstract List<String> getCategoryList();

	public abstract void setCategoryList(List<String> countryList);

	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getPropCount()
	 */
	public abstract long getPropCount();

	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setPropCount(long)
	 */
	public abstract void setPropCount(long propCount);

	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getList()
	 */
	public abstract List<Proposal> getProposalList();

	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setList(java.util.List)
	 */
	public abstract void setProposalList(List<Proposal> list);

	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getCreationDate()
	 */
	public abstract Date getCreationDate();

	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setCreationDate(java.util.Date)
	 */
	public abstract void setCreationDate(Date creationDate);

}