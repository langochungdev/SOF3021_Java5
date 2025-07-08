package poly.edu.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.vn.service.ShoppingCartService;
import poly.edu.vn.untity.DB;


@Controller
public class ItemController {
	@Autowired
	ShoppingCartService cart;
	
	@RequestMapping("/item/index")
	public String list(Model model) {
		model.addAttribute("items", DB.items.values());
//		model.addAttribute("Count", cart.getCount());
		return "item/index";
	}
}
