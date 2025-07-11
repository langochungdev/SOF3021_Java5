package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.CartS;
import web.util.DB;

@Controller
public class CartC {
	@Autowired
	CartS cart;

	@RequestMapping("/cart/view")
	public String view(Model model) {
		model.addAttribute("cart", cart);
		return "cart/view";
	}

	@RequestMapping("/cart/add/{id}")
	public String add(@PathVariable("id") Integer id) {
		cart.add(id);
		return "redirect:/cart/view";
	}

	@RequestMapping("/cart/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cart.remove(id);
		return "redirect:/cart/view";
	}

	@PostMapping("/cart/update/{id}")
	public String update(@PathVariable("id") Integer id, @RequestParam("qty") Integer qty) {
	    cart.update(id, qty);
	    return "redirect:/cart/view";
	}

	@RequestMapping("/cart/clear")
	public String clear() {
	    cart.clear();
	    return "redirect:/cart/view";
	}
}
