package com.mysql.template.Service;

import com.mysql.template.Models.Template_Model;
import com.mysql.template.Repository.Template_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//COMPULSORY: specify it as service
public class Template_Service {

    @Autowired
    private Template_Repository template_repository;//COMPULSORY: create object for your repository

    public List<Template_Model> GetAllModels(){
        return template_repository.findAll();//EXAMPLE: method to get all the data
    }

    public void InsertModel(Template_Model template_model){
        template_repository.save(template_model);//EXAMPLE: method to save an object of data
    }

    public void DeleteSelectedModel(int id){
        template_repository.deleteById(id);//EXAMPLE: method to delete specific data
    }

    public void DeleteAllModels(){
        template_repository.deleteAll();//EXAMPLE: method to delete all data
    }
}
