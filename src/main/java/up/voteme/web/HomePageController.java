package up.voteme.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import up.voteme.HomeController;

@Controller
public class HomePageController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	public String homepage(Model model) {
		logger.info("Welcome user!");
		model.addAttribute("amount", Math.round(Math.random()*100));
		return "homepage";
	}

}
