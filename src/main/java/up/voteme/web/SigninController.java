package up.voteme.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SigninController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(SigninController.class);
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin() {
		logger.info("/signin");
		return "user/signin";
	}
	
	@RequestMapping(value = "/signin-failure", method = RequestMethod.GET)
	public String signinFailure() {
		logger.info("/signin-failure");
		return "user/signin_failure";
	}
	
}
