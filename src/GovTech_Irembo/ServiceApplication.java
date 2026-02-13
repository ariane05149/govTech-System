package GovTech_Irembo;

public class ServiceApplication {
    private static int counter = 1;
    private int applicantId;
    private Citizen applicant;
    private GovernmentService serv;
    private ApplicationStatus stat;

    public ServiceApplication(Citizen Capplicant, GovernmentService service) {
        this.applicantId = counter++;
        this.applicant = Capplicant;
        this.serv = service;
        this.stat=ApplicationStatus.Pending;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public ApplicationStatus getStat() {
        return stat;
    }

    public GovernmentService getserv() {
        return serv;
    }

    public void approve()
            throws InvalidStatusException {
        if (stat== ApplicationStatus.Approved) {
            throw new InvalidStatusException("Already Approved");
        }
        stat=ApplicationStatus.Approved;
        }
        @Override
    public String toString(){
        return applicantId+","+
                applicant.getFullname()+ "," +
                applicant.getIdentificationNumber()+ ","+
                serv.getServiceName()+","+serv.getServiceFee()+","+
                stat;
    }
}
