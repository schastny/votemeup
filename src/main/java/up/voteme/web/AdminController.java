package up.voteme.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import up.voteme.domain.Userd;

@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);
	@RequestMapping(value = "/admin/", method = RequestMethod.GET)
	public String admin(Model model) {
		logger.info("/admin/");
		Userd user = (Userd)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		return "adminpage";
	}
	
}
