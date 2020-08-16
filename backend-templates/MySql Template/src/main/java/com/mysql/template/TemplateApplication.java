package com.mysql.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }

    //Create a database name springboot in your php-admin local host
    //or change database name under src-->main-->-->resources-->application.properties according to your local host database

    //Run xampp / wamp in order to run the backend

    //create your models, repositories, controllers and services inside their relevant packages
    //Please use capital letters as the first letter for your models, repositories, controllers, services and function names
    //Please use simple letters as the first letters for all your variables for proper way of coding
}
