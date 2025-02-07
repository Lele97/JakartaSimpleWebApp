package bean;

public class Login {

    private final int iduser;
    private final String uemail;
    private final String upassword;
    private final String uname;
    public Login(String uemail, String upassword, String uname, int iduser) {
        
        this.uemail = uemail;
        this.upassword = upassword;
        this.uname = uname;
        this.iduser = iduser;
    }
    

    public String getEmail() {
        return this.uemail;
    }

    public String getPassword() {
        return this.upassword;
    }
    
    public String getName() {
        return this.uname;
    }
    
    public String setEmail() {
        return this.uemail;
    }

    public String setPassword() {
        return this.upassword;
    }
    
    public String setName() {
        return this.uname;
    }
    
    public int getId() {
        return this.iduser;
    }
    
    public int setId() {
        return this.iduser;
    }

}
