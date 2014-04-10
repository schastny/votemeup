package up.voteme.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import up.voteme.model.GuestPageModel;

@Controller
@Scope("request")
public class SigninController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(SigninController.class);
	@Autowired
	GuestPageModel gpModel;
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin() {
		logger.info("/signin");
		gpModel.setLoginMes("Вход не выполнен");
		return "guestpage";
	}
	
	@RequestMapping(value = "/signin-failure", method = RequestMethod.GET)
	public String signinFailure() {
		logger.info("/signin-failure");
		gpModel.setLoginMes("Неверные данные");
		return "guestpage";
	}
	
	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String defaultAfterLogin(HttpServletRequest request) {
		logger.info("/default");
		if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/";
        }
		if (request.isUserInRole("ROLE_USER")) {
            return "redirect:/user/";
        }
		
		return "guestpage";
	}
	
	
	
}
