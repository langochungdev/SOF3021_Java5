package poly.edu.vn.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "Accounts")
public class Account implements Serializable{
	@Id
	String username;
	String password;
	String fullname;
	String email;
	String photo;
	Boolean activated;
	Boolean admin;
	@OneToMany(mappedBy = "account")
	List<Order> orders;
}
