package up.voteme.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import up.voteme.domain.Country;
import up.voteme.domain.Role;
import up.voteme.domain.UserStatus;
import up.voteme.domain.Userd;
import up.voteme.model.GuestPageModel;
import up.voteme.model.RegistrationForm;
import up.voteme.service.UserdService;

@Controller
@SessionAttributes({ "gpModel" })
@Scope("request")
public class RegistrationController {

	private static final Logger logger = LoggerFactory
			.getLogger(RegistrationController.class);

	int currentYear;

	@Autowired
	UserdService userDao;

	@Autowired
	GuestPageModel gpModel;

	@RequestMapping(value = "/registration")
	public String formPage(Model model) {

		List<Integer> list = new ArrayList<>();
		Calendar date = Calendar.getInstance();
		currentYear = date.get(Calendar.YEAR);
		for (int i = currentYear - 14; i >= 1918; i--) {
			list.add(i);
		}

		model.addAttribute("yearList", list);
		model.addAttribute("gpModel", gpModel);
		return "registration";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute RegistrationForm regForm,
			BindingResult result, Model model) {
		logger.info("POST method /save");
		if (result.hasErrors()) {
			logger.info("Binding error");
		}

		Role userRole = new Role();
		userRole.setRoleId(1);

		UserStatus userStatus = new UserStatus();
		userStatus.setId(1);

		Country country = new Country();
		country.setCountryId(regForm.getCountry());

		Userd newUser = new Userd();

		newUser.setFirstName(regForm.getFirstName());
		newUser.setLastName(regForm.getLastName());
		newUser.setBirthYear(regForm.getBirthdate());
		newUser.setSex(regForm.getGender());
		newUser.setEmail(regForm.getEmail());
		newUser.setUserLogin(regForm.getUserLogin());

		String securePassword = getShaPassword(regForm.getPassword());
		newUser.setUserPassword(securePassword);

		newUser.setUserStatus(userStatus);
		newUser.setRole(userRole);
		newUser.setCountry(country);

		userDao.store(newUser);

		/*
		 * logger.info("----------"+regForm.getFirstName());
		 * logger.info("----------"+regForm.getLastName());
		 * logger.info("----------"+regForm.getBirthdate());
		 * logger.info("----------"+ regForm.getCountry());
		 */

		return "registration";
	}

	//Хеширование пароля(SHA-1)
	private static String getShaPassword(String passwordToHash) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			passwordToHash = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return passwordToHash;
	}

}