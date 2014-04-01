package up.voteme.model;

import java.util.List;

import up.voteme.domain.Proposal;

// ~enum
public class RequestResult {
	public List<Proposal> list;
	long count;
	
	public RequestResult(int count, List<Proposal> list){
		this.count = count;
		this.list = list;
	}

}
