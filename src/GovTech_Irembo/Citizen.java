package GovTech_Irembo;

public abstract class Citizen {
    protected  String fullname;
    protected String phoneNumber;
    protected String email;

    public Citizen(String name, String phone, String Em){
        this.fullname=name;
        this.phoneNumber=phone;
        this.email=Em;
    }
public String getFullname(){
        return fullname;
}
public abstract String getNationalityType();
}
