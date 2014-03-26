package up.voteme.model;

import java.util.Date;
import java.util.List;

import up.voteme.domain.Proposal;

public interface GuestPageModel {

	public abstract long getPropCount();

	public abstract void setPropCount(long propCount);

	public abstract List<Proposal> getProposalList();

	public abstract void setProposalList(List<Proposal> list);

	public abstract Date getCreationDate();

	public abstract void setCreationDate(Date creationDate);
	
	public abstract void initialize(Date date);

}