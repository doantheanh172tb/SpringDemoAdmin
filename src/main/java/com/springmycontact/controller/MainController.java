package com.springmycontact.controller;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmycontact.domain.Role;
import com.springmycontact.domain.User;
import com.springmycontact.repository.RoleRepository;
import com.springmycontact.repository.UserRepository;

@Controller
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

	@PostMapping("/register")
	public String register(@Valid User user, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			redirect.addFlashAttribute("error", "Register error!");
		}
		logger.info("--------------Info user");
		logger.info(ToStringBuilder.reflectionToString(user));
		if (user.getEmail() == "" || user.getPassword() == "") {
			redirect.addFlashAttribute("error", "Email or Password empty!");
		} else {
			if (userRepository.findByEmail(user.getEmail()) == null) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				HashSet<Role> roles = new HashSet<>();
				roles.add(roleRepository.findByName("ROLE_MEMBER"));
				user.setRoles(roles);
				userRepository.save(user);
				redirect.addFlashAttribute("success", "Register successfully!");
			} else {
				logger.error("Email already exists!");
				redirect.addFlashAttribute("error", "Email already exists!");
			}
		}
		return "redirect:/login";
	}

}
