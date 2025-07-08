package poly.edu.vn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.vn.entity.Account;

public interface AccountDao extends JpaRepository<Account, String>{

	Account findByUsername(String username);

}
