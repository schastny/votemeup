package up.voteme.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import up.voteme.domain.Category;
import up.voteme.domain.Proposal;
import up.voteme.domain.ProposalStatus;
import up.voteme.service.CategoryService;
import up.voteme.service.ProposalService;

@Component
public class GuestPageModelImpl implements GuestPageModel{
	
	@Autowired
	ProposalService propServ;
	
	@Autowired
	CategoryService categServ;
	
	private long propCount;
	private List<Proposal> proposalList;	
	private Date creationDate;
	private List<String> statusList;
	private List<String> categoryList = new ArrayList();
	private List<String> levelList;
	private List<String> countryList;
	private List<String> regionList;
	private List<String> cityList;
	private List<String> districtList;
	
	
	

	
	
	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#initialize(java.util.Date)
	 */
	@Override
	public  void initialize (Date date){
		this.creationDate = date;
		this.propCount = propServ.countAll();
		this.proposalList = propServ.getAll();
		for (Category c: categServ.getAll() ){
			categoryList.add(c.getCategName()) ;
		}
		for (String s: categoryList){
			System.out.println(s);
		}
		
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

	

	public GuestPageModelImpl(){
	}
	
	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getPropCount()
	 */
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
	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setPropCount(long)
	 */

	@Override
	public void setPropCount(long propCount) {
		this.propCount = propCount;
	}

	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getList()
	 */
	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getProposalList()
	 */
	
	@Override
	public List<Proposal> getProposalList() {
		return proposalList;
	}

	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setList(java.util.List)
	 */
	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setProposalList(java.util.List)
	 */
	
	@Override
	public void setProposalList(List<Proposal> list) {
		this.proposalList = list;
	}
	
	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#getCreationDate()
	 */
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
	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setCreationDate(java.util.Date)
	 */

	@Override
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public List<String> getCategoryList() {
		return categoryList;
	}

	@Override
	public void setCategoryList(List<String> countryList) {
		this.categoryList = countryList;
		
	}

	
}