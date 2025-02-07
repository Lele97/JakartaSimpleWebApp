package bean;
public class Product {
	
	
    private final String title;
    private final String category;
    private final String description;
    public Product(String title, String category, String description){
    	
        this.title = title;
        this.category = category;
        this.description = description;        
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

