package poly.edu.vn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties.Listener.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import poly.edu.vn.dao.ProductDao;
import poly.edu.vn.entity.Product;
import poly.edu.vn.service.SessionService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	@Autowired
	ProductDao dao;

	@Autowired
	SessionService session;

	@RequestMapping("/product/searchPage")
	public String searchPage(Model model, @RequestParam("keywords") Optional<String> kw
		, @RequestParam("p") Optional<Integer> p) {
			String kwords = kw.orElse(session.getKeywords());
			session.setKeywords(kwords);
			Pageable pageable = PageRequest.of(p.orElse(0), 5);
			Page<Product> page = dao.findByKeywords("%"+kwords+"%", pageable);
			model.addAttribute("page", page);
	    return "product/searchpage";
	}

	@RequestMapping("/product/search")
	public String search(Model model, @RequestParam("min") Optional<Double> min,
			@RequestParam("max") Optional<Double> max) {
		double minPrice = min.orElse(Double.MIN_VALUE);
		double maxPrice = max.orElse(Double.MAX_VALUE);
		List<Product> items = dao.findByPrice(minPrice, maxPrice);
		model.addAttribute("items", items);
		return "product/search";
	}

	@RequestMapping("/product/sort")
	public String sort(Model model, @RequestParam("field") Optional<String> field) {
		Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
		model.addAttribute("field", field.orElse("price").toUpperCase());
		List<Product> items = dao.findAll(sort);
		model.addAttribute("items", items);
		return "product/sort";
	}

	@RequestMapping("/product/page")
	public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Product> page = dao.findAll(pageable);
		model.addAttribute("page", page);
		return "product/page";
	}
}
