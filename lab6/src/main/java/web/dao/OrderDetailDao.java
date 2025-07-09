package web.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import web.model.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Long>{

}
