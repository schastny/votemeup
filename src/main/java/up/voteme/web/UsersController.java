package up.voteme.web;

import java.util.List;

import javax.ws.rs.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import up.voteme.domain.Comment;
import up.voteme.domain.UserStatus;
import up.voteme.domain.Userd;
import up.voteme.service.CommentService;
import up.voteme.service.UserStatusService;
import up.voteme.service.UserdService;

@Controller
@RequestMapping("/api/users")
public class UsersController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UsersController.class);
	
	@Autowired
	UserdService userdService;
	@Autowired
	UserStatusService userStatusService;
	@Autowired
	CommentService commentService;
	
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
	
	 /*@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	    @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public void update(@PathVariable(value = "userId") long userId, @RequestBody User user)*/
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public @ResponseBody String update(@PathVariable String id, @RequestBody Userd user) {
		logger.info("UPDATE api/users/{id}="+id);
		logger.info(user.toString());
		//userdService.store(user);
		return user.getUserLogin();
	}



}
