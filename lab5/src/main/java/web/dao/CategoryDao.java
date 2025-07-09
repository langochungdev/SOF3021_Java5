package web.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import web.model.Category;

public interface CategoryDao extends JpaRepository<Category, String>{

}