package controller;
import java.io.*;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import model.Student;

@Controller
@RequestMapping("student")
public class StudentController {
    @RequestMapping("form")
    public String form(@ModelAttribute("sv") Student s) {
        return "b1";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("sv") Student s, Errors er, Model m) {
        MultipartFile photo = s.getPhoto();
        if (photo != null && !photo.isEmpty()) {
            try {
                String uploadDir = "E:/uploads/";
                File uploadFile = new File(uploadDir + photo.getOriginalFilename());
                new File(uploadDir).mkdirs();
                photo.transferTo(uploadFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (er.hasErrors()) {
            m.addAttribute("message", "Vui lòng sửa các lỗi sau:");
            m.addAttribute("sv", s);
            return "b1";
        } else {
            m.addAttribute("message", "Chúc mừng, bạn đã nhập đúng");
            return "b1";
        }
    }

    @ModelAttribute("genders")
    public Map<Boolean, String> getGenders(){
        Map<Boolean, String> map = new HashMap<>();
        map.put(true, "Male");
        map.put(false, "Female");
        return map;
    }

    @ModelAttribute("faculties")
    public List<String> getFaculties(){
        return Arrays.asList("CNTT", "DLNHKS", "QTDN");
    }

    @ModelAttribute("hobbies")
    public Map<String, String> getHobbies(){
        Map<String, String> map = new HashMap<>();
        map.put("T", "Travelling");
        map.put("M", "Music");
        map.put("F", "Food");
        map.put("O", "Other");
        return map;
    }
}
