package poly.edu.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.vn.dao.CategoryDao;
import poly.edu.vn.entity.Category;



@Controller
public class HomeController {
	@Autowired
	CategoryDao dao;
	
	@RequestMapping("/home/index")
	public String index(Model model) {
		Category item = new Category();
		model.addAttribute("item", item);
		List<Category> items = dao.findAll();
		model.addAttribute("items", items);
		return "home/index";
	}

	@RequestMapping("/home/about")
	public String about() {
		return "home/about";
	}
}
