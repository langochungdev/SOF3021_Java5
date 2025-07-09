package web.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import web.model.Order;

public interface OrderDao extends JpaRepository<Order, Long>{

}
