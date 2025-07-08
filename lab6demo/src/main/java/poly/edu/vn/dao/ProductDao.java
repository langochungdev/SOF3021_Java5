package poly.edu.vn.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.vn.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

    @Query("select o from Product o where o.price BETWEEN ?1 and ?2")
    List<Product> findByPrice(double minPrice, double maxPrice);

    @Query("select o from Product o where o.name like ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable);
}
