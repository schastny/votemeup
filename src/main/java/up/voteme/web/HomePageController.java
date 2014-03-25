package up.voteme.web;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import up.voteme.HomeController;
import up.voteme.model.GuestLogin;
import up.voteme.service.ProposalService;

@Controller
public class HomePageController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	@Autowired
	ProposalService propServ;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage(Model model) {
		logger.info("Welcome user!");
		model.addAttribute("amount", propServ.countAll());
		model.addAttribute("proposalList", propServ.getAll());
		return "homepage";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("logIn")
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
        
        model.addAttribute("amount", propServ.countAll());
		model.addAttribute("proposalList", propServ.getAll());
        return "homepage";
    }


}
