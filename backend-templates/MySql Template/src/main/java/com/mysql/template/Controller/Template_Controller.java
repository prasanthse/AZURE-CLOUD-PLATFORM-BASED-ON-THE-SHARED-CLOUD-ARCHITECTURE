package com.mysql.template.Controller;

import com.mysql.template.Models.Template_Model;
import com.mysql.template.Repository.Template_Repository;
import com.mysql.template.Service.Template_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//COMPULSORY: specify it as controller
@RequestMapping("/Template")//COMPULSORY: specify a word which is worked as your api entry to this controller
public class Template_Controller {

    //COMPULSORY: Use Try-Catch methods and handle exceptions///////////////////////////////////////
    //IMPORTANT: Use Headers if you need for the relevant places Ex: see post request below

    @Autowired
    private Template_Service template_service;//COMPULSORY: create object for your service
    public Template_Repository template_repository;

    //EXAMPLE: get request and specify a word which is worked as your api entry to this function
    @GetMapping("/getAll")//COMPULSORY: get request cannot accept body of data
    public List<Template_Model> GetAllModels(){
        return template_service.GetAllModels();
    }

    //EXAMPLE: post request and specify a word which is worked as your api entry to this function
    @PostMapping(value = "/insertModel", headers = "content-type=application/json")//COMPULSORY: post request needs body of data
    public void InsertModel(@RequestBody Template_Model template_model){//COMPULSORY: @RequestBody needs to specify in order to get the body of data
        System.out.println("Save data: " + template_model.toString());
        template_service.InsertModel(template_model);
    }

    //EXAMPLE: delete request and specify a word which is worked as your api entry to this function
    @DeleteMapping("/deleteModel/{id}")
    public void DeleteSelectedModel(@PathVariable int id){//COMPULSORY: @PathVariable needs if you want a variable as parameter
        if(template_repository.findById(id)){
            template_service.DeleteSelectedModel(id);
        }
    }

    //EXAMPLE: delete request and specify a word which is worked as your api entry to this function
    @DeleteMapping("/deleteAll")
    public void DeleteAllModels(){
        template_service.DeleteAllModels();
    }
}