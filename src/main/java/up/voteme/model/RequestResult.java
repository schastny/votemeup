package up.voteme.model;

import java.util.List;

import up.voteme.domain.Proposal;

// ~enum
public class RequestResult {
	public List<Proposal> list;
	long count;
	
	public RequestResult(long count, List<Proposal> list){
		this.count = count;
		this.list = list;
	}

	public RequestResult(List<Proposal> list) {
		
System.out.println("list.size() ================ "+list.size());		
		this.count = list.size();
		this.list = list;
	}

}
