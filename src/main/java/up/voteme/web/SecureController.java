package up.voteme.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import up.voteme.domain.Userd;



@Controller
public class SecureController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(SecureController.class);
	
	@ModelAttribute
	public Userd populateCurrentUser(){
		return (Userd)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public String secure(Model model) {
		logger.info("/secure/");
		Userd user = (Userd)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		
		return "userpage";
	}
	
}
