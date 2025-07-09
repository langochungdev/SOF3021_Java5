package web.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import web.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
