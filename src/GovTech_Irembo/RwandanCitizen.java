package GovTech_Irembo;

public class RwandanCitizen extends Citizen {

    private String nationalId;

    public RwandanCitizen(String nameValue,
                          String phoneValue,
                          String emailValue,
                          String idValue) {

        super(nameValue, phoneValue, emailValue);

        if (idValue.length() != 16) {
            throw new IllegalArgumentException("Id must be 16 digits long");
        }

        this.nationalId = idValue;
    }

    @Override
    public String getIdentificationNumber() {
        return nationalId;
    }
}
