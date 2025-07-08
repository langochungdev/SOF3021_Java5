package model;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @NotBlank(message = "{NotBlank.student.name}")
    private String name;

    @NotBlank(message = "{NotBlank.student.email}")
    @Email(message = "{Email.student.email}")
    private String email;
    
    @NotNull(message = "{NotNull.student.marks}")
    @Min(value = 0, message = "{Min.student.marks}")
    @Max(value = 10, message = "{Max.student.marks}")
    private Double marks;

    @NotNull(message = "{NotNull.student.gender}")
    private Boolean gender;

    @NotBlank(message = "{NotBlank.student.faculty}")
    private String faculty;

    @NotEmpty(message = "{NotEmpty.student.hobbies}")
    private List<String> hobbies;
    
    @NotNull(message = "{NotNull.student.photo}")
    private MultipartFile photo;
}

