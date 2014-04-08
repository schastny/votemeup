package up.voteme.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;










import up.voteme.HomeController;
import up.voteme.domain.Category;
import up.voteme.domain.City;
import up.voteme.domain.Comment;
import up.voteme.domain.District;
import up.voteme.domain.Document;
import up.voteme.domain.Proposal;
import up.voteme.domain.Region;
import up.voteme.domain.User;
import up.voteme.model.FiltrForm;
import up.voteme.model.GuestLogin;
import up.voteme.model.GuestPageModel;
import up.voteme.service.CategoryService;
import up.voteme.service.CityService;
import up.voteme.service.CommentService;
import up.voteme.service.DistrictService;
import up.voteme.service.DocumentService;
import up.voteme.service.ProposalService;
import up.voteme.service.RegionService;
import up.voteme.service.VoteService;




@Controller
@SessionAttributes({ "welcomeMes", "gpModel" })
@Scope("request")
public class GuestPageController {

	private static final Logger logger = LoggerFactory
			.getLogger(GuestPageController.class);
	@Autowired
	GuestPageModel gpModel;
	@Autowired
	ProposalService propServ;
	@Autowired
	VoteService voteServ;
	@Autowired
	CommentService commentServ;
	@Autowired
	DocumentService docServ;
	@Autowired
	CategoryService catServ;
	@Autowired
	RegionService regServ;
	@Autowired
	CityService cityServ;
	@Autowired
	DistrictService districtServ;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage(@RequestParam(value="sortBy", required = false) String sortBy, 
			@RequestParam(value="pageQuant", required = false) String pageQuant,
				@RequestParam(value="pageNum", required = false) String pageNum,
					@RequestParam(value="filtrOn", required = false) String filtrOn,
					Model model) {
		
		
		logger.info("GET method /");
		//mark new session to track
		if (!model.containsAttribute("gpModel")){
			Date date = new Date();
			gpModel.setCreationDate(date); 
			logger.info("GuestPageModel() creation date "+ date);
			model.addAttribute("gpModel",gpModel);
		}


		// request come without parameters
		if ((sortBy == null)||(pageQuant == null)||(pageNum == null)||(filtrOn == null)){
			gpModel.reset();
			logger.info("gpModel.reset()");
			return "guestpage";
		}
		
		gpModel.setSortBy(sortBy);
		gpModel.setPageQuant(Integer.parseInt(pageQuant));
		gpModel.setPageNum(Integer.parseInt(pageNum));
		gpModel.setFiltrOn(filtrOn);
		if (filtrOn.equals("false")){ //clear filtr form
			gpModel.clearFiltr();
		}
		gpModel.update();
		return "guestpage";
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String addContact(@ModelAttribute Model model) {

		session
		System.out.println("user.getAuthorities():" + user.getAuthorities());
		http://howtodoinjava.com/2013/04/16/custom-userdetailsservice-example-for-spring-3-security/

//		if (!name.equals("user")) {
//			model.addAttribute("fNameMes", "неверное!");
//		} else if (!password.equals("user")) {
//			model.addAttribute("fPassMes", "неверный!");
//		} else
//			model.addAttribute("welcomeMes", "Welcome: user");

		return "admin/admin";
	}
	
	@RequestMapping(value = "/filtr", method = RequestMethod.GET)
	public String filtr(@ModelAttribute FiltrForm fForm,
			BindingResult result, Model model) {
		logger.info("GET method /filtr");
		if (result.hasErrors()) {
			logger.info("Binding error");
		}

		gpModel.setFiltrOn("true");
		gpModel.setSortBy("noSort");
		gpModel.setPageNum(1);
		gpModel.setSelectedPropStatusId(fForm.getStatus());
		gpModel.setSelectedCategoryId(fForm.getCategory());
		gpModel.setSelectedPropLevelId(fForm.getLevel());
		gpModel.setSelectedCountryId(fForm.getCountry());
		gpModel.setSelectedRegionId(fForm.getRegion());
		gpModel.setSelectedCityId(fForm.getCity());
		gpModel.setSelectedDistrictId(fForm.getDistrict());
		gpModel.update();

		return "guestpage";
	}
	
	
	
	@RequestMapping(value = "/api/regions", method = RequestMethod.GET)
	public @ResponseBody
	List<Region> regionsForCountry(
			@RequestParam(value = "countryId", required = true) String countryId) {
		logger.debug("finding regions for country " + countryId);
		List<Region> list = regServ.getByCountryId(Long.parseLong(countryId));
		gpModel.setRegionList(list);
		gpModel.setCityList(new ArrayList<City>());
		gpModel.setDistrictList(new ArrayList<District>());
		//avoid infinite loops
		for (Region r : list){
			r.setCountry(null);
			r.setCities(null);
		}
		return list;
	}
	
	
	@RequestMapping(value = "/api/cities", method = RequestMethod.GET)
	public @ResponseBody
	List<City> citiesForRegion(
			@RequestParam(value = "regionId", required = true) String regionId) {
		logger.debug("finding cities for region " + regionId);
		List<City> list = cityServ.getByRegionId(Long.parseLong(regionId));
		gpModel.setCityList(list);
		gpModel.setDistrictList(new ArrayList<District>());
		//avoid infinite loops
		for (City c : list){
			c.setRegion(null);
			c.setDistricts(null);
		}
		return list;
	}
	
	
	@RequestMapping(value = "/api/districts", method = RequestMethod.GET)
	public @ResponseBody
	List<District> districtsForCity(
			@RequestParam(value = "cityId", required = true) String cityId) {
		logger.debug("finding districts for city " + cityId);
		List<District> list = districtServ.getByCityId(Long.parseLong(cityId));
		gpModel.setDistrictList(list);
		//avoid infinite loops
		for (District d : list){
			d.setCity(null);
		}
		return list;
	}
	
	
	
	
	
	

	@RequestMapping(value = "/proposal")
	public String proposalPage(@RequestParam(value="numberProposal", required=false) long numberProposal,Model model){
		//System.out.println("numberProposal = "+numberProposal);
		
		Proposal proposalMore=propServ.getById((Long) numberProposal);
		model.addAttribute("proposalMore", proposalMore);
		model.addAttribute("proposalMoreVoteYes", voteServ.getCountVoteByProposalYes((Long) numberProposal));
		model.addAttribute("proposalMoreVoteNo", voteServ.getCountVoteByProposalNo((Long) numberProposal));
		
		List<Comment> commentProposal = commentServ.getCommentByProposal((Long) numberProposal);
		model.addAttribute("commentProposal", commentProposal);
		model.addAttribute("countComment", commentServ.getCountComment((Long) numberProposal));
		
		List<Document> documentProposal = docServ.getDocumentByProposal((Long) numberProposal);
		model.addAttribute("documentProposal", documentProposal);
		model.addAttribute("countDoc", proposalMore.getDocuments().size());
		
		//List<Category> categoryProposal = catServ.getCategoryByProposal((Long) numberProposal);
		model.addAttribute("categoryProposal", proposalMore.getCategories());
		model.addAttribute("countCat", proposalMore.getCategories().size());
		
		
		
		return "proposal";
	}

	
	@RequestMapping(value = "/about")
	public String aboutPage(Model model){
		model.addAttribute("welcomeMes", "Welcome: user");
		return "about";
	}
	@RequestMapping(value = "/contact")
	public String contactPage(Model model){
		model.addAttribute("welcomeMes", "Welcome: user");
		return "contact";
	}
	@RequestMapping(value = "/help")
	public String helpPage(Model model){
		model.addAttribute("welcomeMes", "Welcome: user");
		return "help";
	}	
	
	

	
}
