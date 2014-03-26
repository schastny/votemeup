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
import up.voteme.model.GuestLogin;
import up.voteme.model.GuestPageModel;
import up.voteme.model.GuestPageModelImpl;
import up.voteme.service.ProposalService;

@Controller
@SessionAttributes("gp")
public class GuestPageController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	@Autowired
	GuestPageModel gpModel;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage(@RequestParam(value="showType", required=false) String showType, Model model) {
		logger.info("Welcome GuestPageController GET method!");
		if (!model.containsAttribute("gpModel")){
			gpModel.initialize(new Date());
			model.addAttribute("gpModel",gpModel);
			logger.info("new GuestPageModel() created");
		}

		
		
		return "guestpage";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public String addContact(@ModelAttribute
                            GuestLogin guest, BindingResult result, Model model) {
		if (result.hasErrors()){
    		//return ... - error handling
			System.out.println("Binding error");
    	} 
		
        String name =  guest.getName();
        String password =  guest.getPassword();
        System.out.println("Name:" + name);
        System.out.println("Password:" + password);
        
        if (Math.random()*100 < 40){
        	model.addAttribute("tMes", "Добро пожаловать: "+name);
        }else{
        	model.addAttribute("tMes", "Ошибка ввода данных");
        }
        
       // model.addAttribute("amount", propServ.countAll());
		//model.addAttribute("proposalList", propServ.getAll());
        return "guestpage";
    }


}
