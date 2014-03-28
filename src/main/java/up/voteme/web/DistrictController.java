package up.voteme.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import up.voteme.domain.District;
import up.voteme.service.DistrictService;

@Controller
public class DistrictController {
	@Autowired
	DistrictService districtService;

       
	@RequestMapping(value = "/district") 
	public String listAllDistrict(Model model) {					
        List<District>  district = districtService.findAll(); 
        model.addAttribute("district", district);            
        return "district";
	}
}
