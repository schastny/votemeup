package up.voteme.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import up.voteme.domain.Userd;
import up.voteme.model.GuestPageModel;



@Controller
@SessionAttributes("user")
@Scope("request")
public class UserController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	
	
	@ModelAttribute
	public Userd populateCurrentUser(){
		logger.info("populateCurrentUser()");
		return (Userd)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public String secure(Model model) {
		logger.info("/user/");
		Userd user = (Userd)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		return "userpage";
	}
	
}
