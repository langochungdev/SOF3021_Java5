package poly.edu.vn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.vn.entity.Category;

public interface CategoryDao extends JpaRepository<Category, String>{

}