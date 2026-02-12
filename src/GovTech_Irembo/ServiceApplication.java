package GovTech_Irembo;

public class ServiceApplication {
    private static int counter=1;
private int applicantId;
private Person appliedperson;
private GovernmentService serv;
private ApplicationStatus stat;
public ServiceApplication(applicantp,Gvt service){
    this.applicantId=counter++;
    this.appliedperson=applicantp;
    this.serv=service
}
}
