package up.voteme.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import up.voteme.domain.Userd;
import up.voteme.model.CurrentAdmUser;
import up.voteme.model.PaginatedUser;
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
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity<PaginatedUser> getUsersInJSON(@RequestParam("page") int pageNumber, @RequestParam("per_page") int perPage) {   
		logger.debug("GET api/users, pageNumber:" + pageNumber + "  perPage:" + perPage);
		long items = userdService.countAll();
		if (pageNumber * perPage < 1){
			if (((pageNumber-1) * perPage + 1) > items){
				return new ResponseEntity<PaginatedUser>(HttpStatus.BAD_REQUEST);
			};
		}
		try{
			PaginatedUser pUser = userdService.findPaginated(pageNumber, perPage);
			return new ResponseEntity<PaginatedUser>(pUser, HttpStatus.OK);
		} catch (Exception e){
			logger.warn("Exception catched: " +e.toString());
			return new  ResponseEntity<PaginatedUser>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
    }
	
	@RequestMapping(value = "/current", method = RequestMethod.GET)
    public @ResponseBody CurrentAdmUser getCurrentAdmin() {   
       Userd userd = (Userd)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       CurrentAdmUser currentAdmin = new CurrentAdmUser(userd);  

       return currentAdmin; 
    }
	

	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT) 
	 public @ResponseBody ResponseEntity<String>  update(@PathVariable Long id, @RequestBody final SimpleUser sUser) {
		logger.debug("UPDATE api/users/{id}="+id);
		logger.debug(sUser.toString());
		if (!userdService.validate(sUser)) {
			logger.warn("Data validation failed");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST );
		}
		try{
			userdService.updateUserdAndStore(sUser);
			logger.debug("Database updated");
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e){
			logger.warn("Exception catched: " +e.toString());
			return new  ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}



}
