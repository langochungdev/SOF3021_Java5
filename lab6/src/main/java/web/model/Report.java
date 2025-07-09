package web.model;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Report implements Serializable {
	@Id
	private Serializable group;
	private Double sum;
	private Long count;
}
