package up.voteme.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import up.voteme.domain.UserStatus;
import up.voteme.service.UserStatusService;

@Controller
@RequestMapping("/api/userStatuses")
public class UserStatusController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserStatusController.class);
	
	@Autowired
	UserStatusService userStatusService;
	
	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<UserStatus> getUserStatusesInJSON() {   
        List<UserStatus> statuses = userStatusService.findAll();
        return statuses; 
    }

}
