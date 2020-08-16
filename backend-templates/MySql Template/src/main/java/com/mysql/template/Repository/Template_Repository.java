package com.mysql.template.Repository;

import com.mysql.template.Models.Template_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//COMPULSORY: specify it as repository
public interface Template_Repository extends JpaRepository<Template_Model, Integer> {//COMPULSORY: pass model name and id's data type as parameter

    //OPTIONAL: create your own methods inside repository interface/////////////////////////


    Template_Model deleteById(int id);//EXAMPLE: this is a method which returns the relevant object while passing the id

    boolean findById(int id);
}
