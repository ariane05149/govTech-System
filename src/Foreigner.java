import GovTech_Irembo.Citizen;
import GovTech_Irembo.Person;

public class Foreigner extends Citizen {
    private String PassportNumber;
    public Foreigner(String name,String Phone,String Em, String PassNumber){
        super(name,Phone,Em);
        this.PassportNumber=PassNumber;

    }

    @Override
    public String getNationalityType() {
        return "Foreigner";
    }
}
