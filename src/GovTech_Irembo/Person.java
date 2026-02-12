package GovTech_Irembo;

public  abstract class Person {
    protected String fullName;
    protected String PhoneNumber;
    protected String Email;
    public Person(String Fname,String pNumber,String email){
        this.fullName=Fname;
        this.PhoneNumber=pNumber;
        this.Email=email;
    }
    public String getFname(){
        return fullName;
    }
    public abstract String getIdentification();
}