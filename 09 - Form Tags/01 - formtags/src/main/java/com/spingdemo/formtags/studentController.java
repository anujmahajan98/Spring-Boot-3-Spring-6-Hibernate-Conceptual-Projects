package com.spingdemo.formtags;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class studentController {

    @RequestMapping("/showForm")
    public String ShowForm(Model theModel){
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "student-form";
    }
}
