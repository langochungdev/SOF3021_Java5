package web.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import web.model.Account;

public interface AccountDao extends JpaRepository<Account, String>{
}
