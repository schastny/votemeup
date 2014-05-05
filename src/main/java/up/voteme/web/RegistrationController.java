package up.voteme.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	@Autowired
	UserdService userDao;

	@Autowired
	GuestPageModel gpModel;

	int currentYear;
	String firstNameError = "";
	String lastNameError = "";
	String birthdateError = "";
	String genderError = "";
	String countryError = "";
	String loginError = "";
	String emailError = "";
	String passwordError = "";
	String confirmPasswordError = "";

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

		List<Integer> list = new ArrayList<>();
		Calendar date = Calendar.getInstance();
		currentYear = date.get(Calendar.YEAR);
		for (int i = currentYear - 14; i >= 1918; i--) {
			list.add(i);
		}

		model.addAttribute("yearList", list);

		resetFields();

		Userd newUser = new Userd();

		boolean isError = false;
		/* валидация фамилии */
		if ((regForm.getFirstName().length() <= 1)
				|| (regForm.getFirstName().length() >= 51)) {
			isError = true;
			firstNameError = "Это поле должно иметь длину от 2 до 50 символов и не содержать специальные символы или цифры!";
			model.addAttribute("firstNameError", firstNameError);
		} else {
			if (!checkNameWithRegExp(regForm.getFirstName())) {
				isError = true;
				firstNameError = "Это поле не может содержать специальные символы,цифры или начинаться со знака тире(-)";
				model.addAttribute("firstNameError", firstNameError);
			}
		}

		/* валидация имени */
		if ((regForm.getLastName().length() <= 1)
				|| (regForm.getLastName().length() >= 51)) {
			isError = true;
			lastNameError = "Это поле должно иметь длину от 2 до 50 символов и не содержать специальные символы или цифры!";
			model.addAttribute("lastNameError", lastNameError);
		} else {
			if (!checkNameWithRegExp(regForm.getLastName())) {
				isError = true;
				lastNameError = "Это поле не может содержать специальные символы,цифры или начинаться со знака тире(-)";
				model.addAttribute("lastNameError", lastNameError);
			}
		}

		/* валидация год рождения */
		if (regForm.getBirthdate() < 1917) {
			isError = true;
			birthdateError = "Укажите пожалуйста год своего рождения!";
			model.addAttribute("birthdateError", birthdateError);

		}

		/* валидация пола */
		if (regForm.getGender() == null) {
			isError = true;
			genderError = "Укажите пожалуйста свой пол!";
			model.addAttribute("genderError", genderError);
		}

		/* валидация страны */
		if (regForm.getCountry() <= 0) {
			isError = true;
			countryError = "Укажите страну, в которой Вы проживаете!";
			model.addAttribute("countryError", countryError);
		}

		/* валидация логина */
		if ((regForm.getUserLogin().length() <= 2)
				|| (regForm.getUserLogin().length() >= 21)) {
			isError = true;
			loginError = "Это поле обязательно для заполнения и должно сожержать от 3 до 20 символов!";
			model.addAttribute("loginError", loginError);
		} else {
			if (!checkLoginWithRegExp(regForm.getUserLogin())) {
				isError = true;
				loginError = "Это поле  должно сожержать только символы латинского алфавита, цифры и символы '-', '_', '.'!";
				model.addAttribute("loginError", loginError);
			} else {
				if (userDao.findByLogin(regForm.getUserLogin()) != null) {
					isError = true;
					loginError = "Пользователь с таким логином уже зарегистрирован в системе!";
					model.addAttribute("loginError", loginError);
				}

			}
		}

		/* валидация email */
		if (regForm.getUserEmail().length() <= 4) {
			isError = true;
			emailError = "Укажите пожалуйства свой e-mail адрес!";
			model.addAttribute("emailError", emailError);
		} else {
			if (!checEmailWithRegExp(regForm.getUserEmail())) {
				isError = true;
				emailError = "Укажите корректный e-mail адрес!";
				model.addAttribute("emailError", emailError);
			} else {
				if (userDao.findByEmail(regForm.getUserEmail()) != null) {
					isError = true;
					emailError = "Пользователь с таким e-mail адресом уже зарегистрирован в системе!";
					model.addAttribute("emailError", emailError);
				}
			}
		}

		/* валидация пароля */
		if ((regForm.getPassword().length() <= 4)
				|| (regForm.getPassword().length() >= 256)) {
			isError = true;
			passwordError = "Это поле обязательно для заполнения и должно сожержать от 5 до 255 символов!";
			model.addAttribute("passwordError", passwordError);
		} else {
			if (!checPassWithRegExp(regForm.getPassword())) {
				isError = true;
				passwordError = "Это поле  содержать только символы латинского или русского алфавита, цифры, символы '-' '_' '.' !";
				model.addAttribute("passwordError", passwordError);
			}
		}
		/* валидация пароля2 */
		if ((regForm.getConfirmPassword().length() <= 4)
				|| (regForm.getConfirmPassword().length() >= 256)) {
			isError = true;
			confirmPasswordError = "Это поле обязательно для заполнения и должно сожержать от 5 до 255 символов!";
			model.addAttribute("confirmPasswordError", confirmPasswordError);
		} else {
			if (!(regForm.getPassword().equals(regForm.getConfirmPassword()))) {
				isError = true;
				confirmPasswordError = "Введенные пароли не совпадают!";
				model.addAttribute("confirmPasswordError", confirmPasswordError);
			}
		}

		if (!isError) {

			newUser.setFirstName(regForm.getFirstName());
			newUser.setLastName(regForm.getLastName());
			newUser.setBirthYear(regForm.getBirthdate());
			newUser.setSex(regForm.getGender());
			newUser.setEmail(regForm.getUserEmail());
			newUser.setUserLogin(regForm.getUserLogin());

			String securePassword = getShaPassword(regForm.getPassword());
			newUser.setUserPassword(securePassword);

			Role userRole = new Role();
			userRole.setRoleId(1);

			UserStatus userStatus = new UserStatus();
			userStatus.setId(1);

			Country country = new Country();
			country.setCountryId(regForm.getCountry());

			newUser.setUserStatus(userStatus);
			newUser.setRole(userRole);
			newUser.setCountry(country);

			userDao.store(newUser);

			return "successRegistration";
		} else {

			return "registration";
		}

	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public @ResponseBody
	String checkUser(@RequestParam("userLogin") String userLogin, Model model) {
		logger.info(userLogin);
		if (userDao.findByLogin(userLogin) != null) {
			logger.info("fail");
			return "fail";
		} else {
			logger.info("ok");
			return "ok";
		}
	}

	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
	public @ResponseBody
	String checkEmail(@RequestParam("userEmail") String userEmail, Model model) {
		logger.info(userEmail);
		if (userDao.findByEmail(userEmail) != null) {
			logger.info("fail");
			return "fail";
		} else {
			logger.info("ok");
			return "ok";
		}
	}

	public static boolean checkNameWithRegExp(String userData) {
		Pattern p = Pattern.compile("^([A-Za-zА-Яа-я]+[ -]*)+$");
		Matcher m = p.matcher(userData);
		return m.matches();
	}

	public static boolean checkLoginWithRegExp(String userLogin) {
		Pattern p = Pattern.compile("^[(\\w)+[\\._-]*(\\w)+]+$");
		Matcher m = p.matcher(userLogin);
		return m.matches();
	}

	public static boolean checEmailWithRegExp(String userEmail) {
		Pattern p = Pattern
				.compile("^\\w+([\\._-]*\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,10})+$");
		Matcher m = p.matcher(userEmail);
		return m.matches();
	}

	public static boolean checPassWithRegExp(String userPass) {
		Pattern p = Pattern.compile("^[A-Za-zА-Яа-я\\d-_\\.]+$");
		Matcher m = p.matcher(userPass);
		return m.matches();
	}

	public void resetFields() {
		firstNameError = "";
		lastNameError = "";
		birthdateError = "";
		genderError = "";
		countryError = "";
		loginError = "";
		emailError = "";
		passwordError = "";
		confirmPasswordError = "";
	}

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