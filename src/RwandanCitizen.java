import GovTech_Irembo.Citizen;
import GovTech_Irembo.Person;

public class RwandanCitizen extends Citizen {
private String NationalId;
public RwandanCitizen(String name, String phone,String Em,String NId){
    super(name,phone,Em);
  if(NId.length()!=16){
      throw new IllegalArgumentException(("Id must be 16 digits long"));
  }
  this.NationalId=NId;
}

    @Override
    public String getNationalityType() {
        return "Rwandan";
    }
}
