package up.voteme.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import up.voteme.domain.Country;
import up.voteme.domain.Role;
import up.voteme.service.CountryService;
import up.voteme.service.RoleService;

@Controller
@RequestMapping("/api/countries")
public class CountryController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CountryController.class);
	@Autowired
	CountryService countryService;
	
	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Country> getCountriesInJSON() {   
        List<Country> countries = countryService.findAll();
        return countries; 
    }

}
