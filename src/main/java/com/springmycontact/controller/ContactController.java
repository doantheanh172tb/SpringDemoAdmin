package com.springmycontact.controller;

import javax.validation.Valid;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmycontact.domain.Contact;
import com.springmycontact.service.ContactService;

@Controller
public class ContactController {
	
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ContactService contactService;

	@GetMapping("/contact")
	public String index(Model model) {
//		logger.debug("Debug message");
//        logger.info("Info message");
//        logger.warn("Warn message");
//        logger.error("Error message");
		model.addAttribute("contacts", contactService.findAll());
		return "list/contact";
	}

	@GetMapping("/contact/create")
	public String create(Model model) {
		model.addAttribute("contact", new Contact());
		return "form/contact";
	}

	@PostMapping("/contact/save")
	public String save(@Valid Contact contact, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form/contact";
		}
		contactService.save(contact);
		redirect.addFlashAttribute("success", "Saved contact successfully!");
		return "redirect:/contact";
	}

	@GetMapping("/contact/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("contact", contactService.findOne(id));
		return "form/contact";
	}

	@GetMapping("/contact/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		contactService.delete(id);
		redirect.addFlashAttribute("success", "Deleted contact successfully!");
		return "redirect:/contact";
	}

	@GetMapping("/contact/search")
	public String search(@RequestParam("q") String q, Model model) {
		if (q.equals("")) {
			return "redirect:/contact";
		}

		model.addAttribute("contacts", contactService.search(q));
		return "list/contact";
	}

}
