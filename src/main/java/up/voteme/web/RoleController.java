package up.voteme.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import up.voteme.domain.Role;


@Controller
@RequestMapping("/api/roles")
public class RoleController {


	private static final Logger logger = LoggerFactory
			.getLogger(RoleController.class);
	
	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<String> getUsersInJSON() {   
      //  List<Role> roles = roleService.findAllSimple();
        return null; 
    }
}
