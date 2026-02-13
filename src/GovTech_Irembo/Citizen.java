package GovTech_Irembo;

public abstract class Citizen {
    protected  String fullname;
    protected String phoneNumber;
    protected String emailAddress;

    public Citizen(String fname, String phone, String mail){
        this.fullname=fname;
        this.phoneNumber=phone;
        this.emailAddress=mail;
    }
public String getFullname(){
        return fullname;
}
public abstract String getIdentificationNumber();
}
