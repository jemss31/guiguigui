/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author admin
 */
public class Session {
    
    private static Session instance;
    private int id;
    private String u_fname;
    private String u_lname;
    private String u_email;
    private String u_username;
    private String type;
    private String status;
    
    
    private Session(){
    }


    public static synchronized Session getInstance() {
        if (instance == null){
            instance = new Session();
        }
        return instance;
    }

    public static boolean isInstanceEmpty() {
        return instance == null;
    }

        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getU_fname() {
        return u_fname;
    }

    public void setU_fname(String u_fname) {
        this.u_fname = u_fname;
    }

    public String getU_lname() {
        return u_lname;
    }

    public void setU_lname(String u_lname) {
        this.u_lname = u_lname;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_username() {
        return u_username;
    }

    public void setU_username(String u_username) {
        this.u_username = u_username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

}
