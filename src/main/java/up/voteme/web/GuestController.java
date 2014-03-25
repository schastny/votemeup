package up.voteme.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import up.voteme.domain.District;
import up.voteme.service.DistrictService;

@Controller
@RequestMapping(value = "/guest") 
public class GuestController {
	@Autowired
	DistrictService districtService;
	
	@RequestMapping(value = "/about") 
	public ModelAndView showAbout(){
		 ModelAndView mav = new ModelAndView();
	        mav.setViewName("about");
	        mav.addObject("message", "Hello World!");
	        District district = districtService.findById(9L);
	        mav.addObject("district", district);
	        return mav;
	}

}
