package web.model;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Data 
@NoArgsConstructor
@AllArgsConstructor
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
