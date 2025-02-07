package com.project.local.jakartasimplewebapp.bean;
public class CategoryDrop {

    private final int id;
    private final String code;
    
    
    public CategoryDrop(int id, String code){
        this.id = id;
        this.code = code;        
        
        
    }
    public int getId() {
		return id;
	}
    public String getCode(){
        return this.code;
    }
public int setId() {
		return id;
	}
    public String setCode(){
        return this.code;
    }
}
