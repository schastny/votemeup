package up.voteme.web;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import up.voteme.HomeController;
import up.voteme.model.FiltrForm;
import up.voteme.model.GuestLogin;
import up.voteme.model.GuestPageModel;
import up.voteme.model.GuestPageModelImpl;
import up.voteme.service.ProposalService;

@Controller
@SessionAttributes({ "welcomeMes", "gpModel" })
@Scope("request")
public class GuestPageController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	@Autowired
	GuestPageModel gpModel;

	@Autowired
	ProposalService propServ;
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage(@RequestParam(value="sortBy", required = false) String sortBy, 
			@RequestParam(value="pageQuant", required = false) String pageQuant,
				@RequestParam(value="pageNum", required = false) String pageNum,
					@RequestParam(value="filtrOn", required = false) String filtrOn,
						Model model) {
		logger.info("GET method /");
		// new session
		if (!model.containsAttribute("gpModel")){
			Date date = new Date();
			gpModel.setCreationDate(date); // for debug purposes to track session
			logger.info("GuestPageModel() creation date "+ date);
			model.addAttribute("gpModel",gpModel);
			
		}
		
		// request come without parameters
		if ((sortBy == null)||(pageQuant == null)||(pageNum == null)||(filtrOn == null)){
			gpModel.reset();
			logger.info("gpModel.reset()");
			gpModel.update();
			return "guestpage";
		}
		logger.info(" sortBy="+sortBy+" pageQuant="+pageQuant+" pageNum="+pageNum+" filtrOn="+filtrOn);
		gpModel.setSortBy(sortBy);
		gpModel.setPageQuant(pageQuant);
		gpModel.setPageNum(pageNum);
		gpModel.setFiltrOn(filtrOn);
		if (filtrOn.equals("false")){ //clear filtr form
			gpModel.clearFiltr();
		}
		gpModel.update();
		return "guestpage";
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String addContact(@ModelAttribute GuestLogin guest,
			BindingResult result, Model model) {
		logger.info("POST method");
		if (result.hasErrors()) {
			logger.info("Binding error");
		}
		String name = guest.getName();
		String password = guest.getPassword();
		logger.info("Name:" + name);
		logger.info("Password:" + password);

		if (!name.equals("user")) {
			model.addAttribute("fNameMes", "неверное!");
		} else if (!password.equals("user")) {
			model.addAttribute("fPassMes", "неверный!");
		} else
			model.addAttribute("welcomeMes", "Welcome: user");

		return "guestpage";
	}
	
	@RequestMapping(value = "/filtr", method = RequestMethod.GET)
	public String filtr(@ModelAttribute FiltrForm fForm,
			BindingResult result, Model model) {
		logger.info("GET method /filtr");
		if (result.hasErrors()) {
			logger.info("Binding error");
		}
		logger.info(""+fForm.getStatus()+fForm.getCategory()+fForm.getLevel()+fForm.getCity()+ fForm.getDistrict());
		
		gpModel.setFiltrOn("true");
		gpModel.setSortBy("noSort");
		gpModel.setPageNum("1");
		
		gpModel.setSelectedPropStatusId(fForm.getStatus());
		gpModel.setSelectedCategoryId(fForm.getCategory());
		gpModel.setSelectedPropLevelId(fForm.getLevel());
		gpModel.setSelectedCountryId(fForm.getCountry());
		gpModel.setSelectedRegionId(fForm.getRegion());
		gpModel.setSelectedCityId(fForm.getCity());
		gpModel.setSelectedDistrictId(fForm.getDistrict());

		gpModel.update();

		return "guestpage";
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String homepage(@RequestParam(value="terName", required = false) String terName, 
			@RequestParam(value="id", required = false) String terId,
				 Model model) {
		logger.info("GET method /select");
		
		
		
		return "guestpage";
	}
}
