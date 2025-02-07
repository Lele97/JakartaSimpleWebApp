package com.project.local.jakartasimplewebapp.bean;
public class CategoryID {

    private final int id;
    public final String code;
    public final String description;
    
    public CategoryID(int id, String code, String description){
        this.id = id;
        this.code = code;        
        this.description = description;
        
    }
    public int getId() {
		return id;
	}
    public String getCode(){
        return this.code;
    }
      public String getDescription(){
        return this.description;
    }
    public int setId() {
		return id;
	}
    public String setCode(){
        return this.code;
    }
      public String setDescription(){
        return this.description;
    }  
      
}
