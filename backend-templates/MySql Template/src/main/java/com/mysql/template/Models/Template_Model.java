package com.mysql.template.Models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "Template")//COMPULSORY: specify the table name that need to work with this model
public class Template_Model {

    @Id//COMPULSORY: specify only for the primary key column
    @GeneratedValue(strategy = GenerationType.AUTO)//OPTIONAL: if need to generate primary key automatically
    @Column(name = "id")//OPTIONAL: if need to change column name
    private int id;
    @NotEmpty//OPTIONAL: if need a not empty column
    private String name;
    private String password;

    //COMPULSORY: create empty constructor or else will get error while create object
    public Template_Model() {
    }

    //COMPULSORY: Do not specify the primary key if it is an auto generated attribute inside parameterize constructor
    public Template_Model(String name, String password) {
        this.name = name;
        this.password = password;
    }

    //COMPULSORY: create getter and setter for all the attributes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //OPTIONAL: For developers to test the data
    @Override
    public String toString() {
        return "Template_Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
