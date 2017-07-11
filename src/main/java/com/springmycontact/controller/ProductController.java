package com.springmycontact.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmycontact.domain.Product;
import com.springmycontact.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/product")
	public String index(Model model) {
		model.addAttribute("products", productService.findAll());
		return "list/productList";
	}

	@GetMapping("/product/create")
	public String create(Model model) {
		model.addAttribute("product", new Product());
		return "form/productForm";
	}

	@PostMapping("/product/save")
	public String save(@Valid Product product, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form/productForm";
		}
		productService.save(product);
		redirect.addFlashAttribute("success", "Saved product successfully!");
		return "redirect:/product";
	}

	@GetMapping("/product/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("product", productService.findOne(id));
		return "form/productForm";
	}

	@GetMapping("/product/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		productService.delete(id);
		redirect.addFlashAttribute("success", "Deleted product successfully!");
		return "redirect:/product";
	}

	@GetMapping("/product/search")
	public String search(@RequestParam("q") String q, Model model) {
		if (q.equals("")) {
			return "redirect:/product";
		}

		model.addAttribute("products", productService.search(q));
		return "list/productList";
	}
}
