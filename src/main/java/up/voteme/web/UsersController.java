package up.voteme.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import up.voteme.domain.Userd;
import up.voteme.service.UserdService;

@Controller
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	UserdService userdService;
	
	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Userd> getUsersInJSON() {   
        List<Userd> users = userdService.findAll();
        for (Userd u: users){
    		u.setCommentd(null);
        	u.getCountry().setRegions(null);
        	u.getRegion().setCities(null);
        	u.getCity().setDistricts(null);
         	u.setProposals(null);
        	u.setVotes(null);
        	u.getRole().setUsers(null);
        }
        return users; 
    }
	
	@RequestMapping(value = "/current", method = RequestMethod.GET)
    public @ResponseBody Userd getCurrentAdmin() {   
       Userd u = (Userd)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    		u.setCommentd(null);
        	u.getCountry().setRegions(null);
        	u.setRegion(null);
        	u.setCity(null);
        	u.setDistrict(null);
         	u.setProposals(null);
        	u.setVotes(null);
        	u.getRole().setUsers(null);

        return u; 
    }
/*	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Userd findById(@PathVariable Long id) {
		Userd u = userdService.findById(id);
		u.setCommentd(null);
    	u.getCountry().setRegions(null);
    	u.getRegion().setCities(null);
    	u.getCity().setDistricts(null);
    	u.setDistrict(null);
    	u.setProposals(null);
    	u.setVotes(null);
    	u.getRole().setUsers(null);
		return  u;
	}
*/

}
