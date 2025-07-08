package poly.edu.vn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.vn.entity.Category;
import poly.edu.vn.entity.Order;
import poly.edu.vn.entity.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Long>{

}
