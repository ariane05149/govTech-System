package GovTech_Irembo;

public class User {
    private String username;
    private String password;
    public User(String uname, String psd) {
        this.username = uname;
        this.password = psd;
    }
public String getUsername(){
    return username;
        }
        public String getPassword(){
        return  password;
    }
 @Override
public String toString() {
    return username + "," + password;
}
}
