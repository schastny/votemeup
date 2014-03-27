package up.voteme;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;







import org.springframework.web.servlet.ModelAndView;

import up.voteme.domain.Category;
import up.voteme.domain.City;
import up.voteme.domain.ProposalStatus;
import up.voteme.domain.Region;
import up.voteme.service.CategoryService;
import up.voteme.service.CityService;
import up.voteme.service.ProposalStatusService;
import up.voteme.service.RegionService;



/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class HomeController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CityService cityService;

	@Autowired
	private RegionService regionService;
	
	@Autowired
	private ProposalStatusService psService;
	
	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	
	public String index(Model model) {
		
		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	
	public String homePage(Model model) {
		List<Category> catList = categoryService.getAll();
		model.addAttribute("catList",catList);
		
		List<City> cityList = cityService.getAll();
		model.addAttribute("cityList",cityList);
		
		model.addAttribute("controllerMessage",
				"This is the message from the controller! "+new Date());
		
		
		return "home";
	}
	
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {

		List<Region> regList = regionService.getAllRegion();
		model.addAttribute("regList",regList);

		
		model.addAttribute("controllerMessage", "This is the message from the controller! "+new Date());
		return "about";
	}
	
	@RequestMapping(value = "/ps", method = RequestMethod.GET)
	public ModelAndView allPS() {
		
		ModelAndView modelAndView = new ModelAndView();

		List<ProposalStatus> psList = psService.getAllPS();
		modelAndView.addObject("psList", psList);
		modelAndView.setViewName("ps");
		
		
		return modelAndView;
	}

	
}
