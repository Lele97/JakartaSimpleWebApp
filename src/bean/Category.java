package com.project.local.jakartasimplewebapp.bean;
public class Category {

    
    private final String code;
    private final String description;
    
    public Category(String code, String description){
        
        this.code = code;        
        this.description = description;
        
    }
    public String getCode(){
        return this.code;
    }
      public String getDescription(){
        return this.description;
    }
    public String setCode(){
        return this.code;
    }
      public String setDescription(){
        return this.description;
    }  
      
}
