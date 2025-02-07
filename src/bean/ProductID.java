package com.project.local.jakartasimplewebapp.bean;
public class ProductID {

    private final int id;
    private final String title;
    private final String category;
    private final String description;
    
    public ProductID(int id,String title, String category, String description){
        this.id = id;
        this.title = title;
        this.category = category;        
        this.description = description;
        
    }
    public int getId() {
		return id;
	}
    public int setId() {
		return id;
	}
    public String getTitle(){
        return this.title;
    }
     public String getCategory(){
        return this.category;
    }
      public String getDescription(){
        return this.description;
    }
    public String setTitle(){
        return this.title;
    }
     public String setCategory(){
        return this.category;
    }
      public String setDescription(){
        return this.description;
    }
      
}
