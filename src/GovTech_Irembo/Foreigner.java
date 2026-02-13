package GovTech_Irembo;

public class Foreigner extends Citizen {

    private String passportNumber;

    public Foreigner(String name,
                     String phone,
                     String email,
                     String passNo) {

        super(name, phone, email);
        this.passportNumber = passNo;
    }

    @Override
    public String getIdentificationNumber() {
        return passportNumber;
    }
}
