package up.voteme.web;

import java.util.Date;
import java.util.HashMap;

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
import up.voteme.domain.Proposal;
import up.voteme.model.FiltrForm;
import up.voteme.model.GuestLogin;
import up.voteme.model.GuestPageModel;
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
		logger.info("GET method");
		if (!model.containsAttribute("gpModel")){
			gpModel.initialize(new Date());
			model.addAttribute("gpModel",gpModel);
			model.addAttribute("tab", 1);
			
			logger.info("new GuestPageModel() created");
		}
		if (showType!=null){
			if (showType.equals("all")){
				logger.info("showType = all");
				model.addAttribute("tab", 1);
				
				HashMap<String, String> map = new HashMap<>();
				map.put("sortBy", "creationDate");
						
				gpModel.setProposalList(propServ.getByParams(map));
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
		}
		
		model.addAttribute("filtrform", new FiltrForm());
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
		logger.info("GET method");
		if (result.hasErrors()) {
			logger.info("Binding error");
		}
		logger.info(fForm.getCategory());
		logger.info(fForm.getCity());

	

		return "guestpage";
	}

	@RequestMapping(value = "/about")
	public String aboutPage(Model model){
		model.addAttribute("welcomeMes", "Welcome: user");
		return "about";
	}
	@RequestMapping(value = "/contact")
	public String contactPage(Model model){
		model.addAttribute("welcomeMes", "Welcome: user");
		return "contact";
	}
	@RequestMapping(value = "/help")
	public String helpPage(Model model){
		model.addAttribute("welcomeMes", "Welcome: user");
		return "help";
	}

	@RequestMapping(value = "/proposal")
	public String helpPage(@RequestParam(value="numberProposal", required=false) long numberProposal,Model model){
		//System.out.println("numberProposal = "+numberProposal);
		Proposal proposalMore=propServ.getById((Long) numberProposal);
		model.addAttribute("proposalMore", proposalMore);
		model.addAttribute("proposalMoreVoteYes", propServ.getCountVoteYes((Long) numberProposal));
		model.addAttribute("proposalMoreVoteNo", propServ.getCountVoteNo((Long) numberProposal));
		
		
		
		
		return "proposal";
	}
	
}
