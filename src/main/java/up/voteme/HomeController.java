package up.voteme;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import up.voteme.dao.CategoryDAO;
import up.voteme.dao.CategoryDAOImpl;
import up.voteme.domain.Category;
import up.voteme.service.CategoryService;



/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class HomeController {

	@Autowired
	private CategoryService categoryService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	public String home(Model model) {
		logger.info("Welcome home!");
		
		List<Category> list = categoryService.getAll();

		//add all proposals as attribute to show on home.jsp 
		model.addAttribute("list",list);
	
		
		model.addAttribute("controllerMessage",
				"This is the message from the controller! "+new Date());
		return "home";
	}

}
