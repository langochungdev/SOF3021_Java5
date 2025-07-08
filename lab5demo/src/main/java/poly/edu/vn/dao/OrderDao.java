package poly.edu.vn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.vn.entity.Category;
import poly.edu.vn.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long>{

}
