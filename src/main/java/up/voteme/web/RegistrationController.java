package up.voteme.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import up.voteme.model.GuestPageModel;

@Controller
@SessionAttributes({"gpModel"})
@Scope("request")
public class RegistrationController {
	
	@Autowired
	GuestPageModel gpModel;
	
	
	@RequestMapping(value = "/registration")
	public String formPage(Model model){
		
		model.addAttribute("gpModel", gpModel);
		List<Integer> list = new ArrayList<>();
		list.add(1983);
		
		list.add(1983);
		list.add(1983);
		
		model.addAttribute("yearList", list);
		
		return "registration";
	}	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String save2(Model model){		
//	//	model.addAttribute("welcomeMes", "Welcome: user");
//		return "about";
//	}

}
