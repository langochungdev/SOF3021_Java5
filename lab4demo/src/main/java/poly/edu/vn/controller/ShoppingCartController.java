package poly.edu.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import poly.edu.vn.service.ShoppingCartService;
import poly.edu.vn.untity.DB;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingCartController {

	@Autowired
	ShoppingCartService cart;

//	@RequestMapping("/cart")
//	public String list(Model model) {
//		model.addAttribute("items", DB.items.values());
//		model.addAttribute("Count", cart.getCount());
//		return "cart/index";
//	}

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

	@RequestMapping(value = "/cart/remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable("id") Integer id) {
		cart.remove(id);
		return "redirect:/cart/view";
	}

	@RequestMapping("/cart/update/{id}")
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
