package web.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, String> {
}
