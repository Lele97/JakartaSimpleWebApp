package bean;
public class ProductID2 {

    private final int id;
    private final String title;
    private final String description;
    
    public ProductID2 (int id,String title, String description){
        this.id = id;
        this.title = title;
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
    public String getDescription(){
        return this.description;
    }
    public String setTitle(){
        return this.title;
    }
    public String setDescription(){
        return this.description;
    }
      
}
