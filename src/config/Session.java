package config;

/**
 * Singleton class to manage user session information.
 */
public class Session {
    
    private static Session instance;
    private int id;
    private String u_fname;
    private String u_lname;
    private String u_email;
    private String u_username;
    private String type;
    private String cont;
    private String status;
    private String u_pass;
    private String SecurityQuestion;
    private String answer;
    private String PIN;
    private String image;   


    // Private constructor to prevent instantiation
    private Session() {
        // Initialize default values
        this.id = 0;
    }

    // Get the singleton instance of the Session
    public static synchronized Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

   

    // Check if the session instance is empty
    public static boolean isInstanceEmpty() {
        return instance == null || instance.id == 0;
    }

    // Getters and Setters for session attributes
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

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }

    public String getSecurityQuestion() {
        return SecurityQuestion;
    }

    public void setSecurityQuestion(String SecurityQuestion) {
        this.SecurityQuestion = SecurityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    // Reset session attributes to default values
    public void resetSession() {
        this.id = 0;
        this.u_fname = null;
        this.u_lname = null;
        this.u_email = null;
        this.u_username = null;
        this.type = null;
        this.status = null;
    }

    // Logout method to reset the session
    public void logout() {
        resetSession(); // Reset session attributes
    }

    // Method to set user details after successful login
    public void setUserDetails(int id, String fname, String lname, String email, String username, String type, String status) {
        this.id = id;
        this.u_fname = fname;
        this.u_lname = lname;
        this.u_email = email;
        this.u_username = username;
        this.type = type;
        this.status = status;
    }
}