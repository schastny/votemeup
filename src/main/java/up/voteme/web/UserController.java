package up.voteme.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import up.voteme.service.UserService;
import up.voteme.domain.Userd;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	// show all users
	@RequestMapping(value = "/users") // { "/", "/index", "/users" }
	public String listAllUsers(Model model) {					
        List<Userd> users = userService.showAll(); 
        model.addAttribute("users", users);            
        return "users";
	}
	
	// add some new users
	@RequestMapping(value = "/addusers") // { "/", "/index", "/users" }
	public String addRandomUsers(Model model) {
		
		userService.addRandomUsers();	               
	    return listAllUsers(model);
	        
	}
	
	/*@RequestMapping(value = "/users")
	public ModelAndView listAllUsers() {
		
		Map<String, Object> model = new HashMap<String, Object>();       
        List<Userd> users = userService.showAll();        
        model.put("users", users);               
        return new ModelAndView("users", model);
	}*/
	
}
