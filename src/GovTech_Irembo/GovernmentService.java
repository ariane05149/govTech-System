package GovTech_Irembo;

public  abstract class GovernmentService {
   protected String serviceName;
   protected int ServiceFee;

    public GovernmentService(String N, int F) {
        this.serviceName = N;
        this.ServiceFee = F;
    }

    public int getServiceFee() {
        return ServiceFee;
    }
    ;
}