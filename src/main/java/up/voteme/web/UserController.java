package up.voteme.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import up.voteme.service.UserService;
import up.voteme.domain.Userd;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	// show all users
	@RequestMapping(value = "/users")
	public ModelAndView listAllUsers() {
		
		Map<String, Object> params = new HashMap<String, Object>();       
        List<Userd> users = userService.showAll();        
        params.put("users", users);               
        return new ModelAndView("users", params);
	}
	
}
