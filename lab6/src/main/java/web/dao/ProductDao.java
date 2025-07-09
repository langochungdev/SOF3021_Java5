package web.dao;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import web.model.Product;
import web.model.Report;

public interface ProductDao extends JpaRepository<Product, Integer>{

    @Query("select o from Product o where o.price BETWEEN ?1 and ?2")
    List<Product> findByPrice(double minPrice, double maxPrice);

    @Query("select o from Product o where o.name like ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable);
    
    @Query("SELECT new web.model.Report(o.category, SUM(o.price), COUNT(o)) "
            + "FROM Product o "
            + "GROUP BY o.category "
            + "ORDER BY SUM(o.price) DESC")
       List<Report> getInventoryByCategory();
}
