package web.model;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	Integer id;
	String name;
	double price;
	int qty=1;
}

