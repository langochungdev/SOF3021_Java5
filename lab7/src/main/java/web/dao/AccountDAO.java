package web.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, String> {

}
