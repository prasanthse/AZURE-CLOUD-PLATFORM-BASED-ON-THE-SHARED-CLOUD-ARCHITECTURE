package com.mysql.template.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Template")
public class Template_Controller {

    @Autowired
    @PreAuthorize("hasRole('user')")
    @GetMapping("/")
    public String GetStudentId(){
        return "SE/2015/026";
    }
}