package up.voteme.model;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import up.voteme.domain.Proposal;
import up.voteme.service.ProposalService;

@Component
public class GuestPageModelImpl implements GuestPageModel {
	

	
	private long propCount;
	private List<Proposal> proposalList;	
	private Date creationDate;

	@Autowired
	ProposalService propServ;

	
	
	public  void initialize (Date date){
		this.creationDate = date;
		this.propCount = propServ.countAll();
		this.proposalList = propServ.getAll();
		
	}

	public GuestPageModelImpl(){
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
	 * @see up.voteme.model.GuestPageModel#getList()
	 */
	@Override
	public List<Proposal> getProposalList() {
		return proposalList;
	}

	/* (non-Javadoc)
	 * @see up.voteme.model.GuestPageModel#setList(java.util.List)
	 */
	@Override
	public void setProposalList(List<Proposal> list) {
		this.proposalList = list;
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

	
}