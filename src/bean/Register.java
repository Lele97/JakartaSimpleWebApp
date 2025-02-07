package com.project.local.jakartasimplewebapp.bean;

public class Register {
    private final String uname;
    private final String uemail;
    private final String upassword;
    


    public Register(String uname, String uemail, String upassword) {
        this.uname = uname;
        this.uemail = uemail;
        this.upassword = upassword;
        


    }
    
    public String getName() {
        return uname;
    }
    public String setName(){
        return this.uname;   
    }    
    
    public String getEmail() {
        return uemail;
    }
    
    public String setEmail(){
        return this.uemail;   
    }    
    
    public String getPassword() {
        return upassword;
    }
    
    public String setPassword(){
        return this.upassword;   
    }
        
    
}