package up.voteme.web;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@SessionAttributes({ "welcomeMes", "gpModel", "tab" })
public class GuestPageController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	@Autowired
	GuestPageModel gpModel;

	@Autowired
	ProposalService propServ;
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage(@RequestParam(value="showType", required=false) String showType, Model model) {
		logger.info("GET method /");
		if (!model.containsAttribute("gpModel")){// new session
			gpModel.setCreationDate(new Date()); // for debug purposes to track session
			model.addAttribute("gpModel",gpModel);
			logger.info("new GuestPageModel() created");
		//	model.addAttribute("filtrform", new FiltrForm());
		}
		
		// request come without parameters
		if (showType == null){
			gpModel.reset();
			return "guestpage";
		};
		
		if (showType.equals("all")){
			logger.info("showType = all");
			model.addAttribute("tab", 1);
			gpModel.setProposalList(propServ.getAll());
		}else if (showType.equals("popular")){
			logger.info("showType = popular");
			model.addAttribute("tab", 2);
			gpModel.setProposalList(propServ.getAllbyVoteNum());
		}else if (showType.equals("last")){
			logger.info("showType = last");
			model.addAttribute("tab", 3);
			gpModel.setProposalList(propServ.getAllbyDate());
		}else if (showType.equals("commented")){
			logger.info("showType = commented");
			model.addAttribute("tab", 4);
			//gpModel.setProposalList(propServ.getAllbyDate());
		}else {
			logger.info("showType==null");
		}
		
		
		
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
		logger.info(fForm.getCategory());
		logger.info(fForm.getCity());

	

		return "guestpage";
	}

}
