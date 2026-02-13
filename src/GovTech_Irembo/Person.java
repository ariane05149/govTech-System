package GovTech_Irembo;

public  abstract class Person {
    protected String fullName;
    protected String PhoneNumber;
    protected String email;
    public Person(String Fname,String pNumber,String email){
        this.fullName=Fname;
        this.PhoneNumber=pNumber;
        this.email=email;
    }
    public String getFname(){
        return fullName;
    }
    public abstract String getIdentification();
}