package up.voteme.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import up.voteme.domain.Comment;
import up.voteme.domain.UserStatus;
import up.voteme.domain.Userd;
import up.voteme.model.SimpleUser;
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
    public @ResponseBody List<SimpleUser> getUsersInJSON() {   
        List<SimpleUser> sUsers = userdService.findAllSimple();
        return sUsers; 
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
	

	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT) 
	 @ResponseStatus(HttpStatus.NO_CONTENT) 
	 public void update(@PathVariable Long id, @RequestBody final SimpleUser sUser) {
		logger.info("UPDATE api/users/{id}="+id);
		logger.info(sUser.toString());
		Userd u = userdService.findById(sUser.getUserdId());
		userdService.store(sUser.update(u));
		
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		logger.info("DELETE api/users/{id}="+id);
		userdService.delete(id);
	}



}
