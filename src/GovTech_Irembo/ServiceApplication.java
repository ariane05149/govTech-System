package GovTech_Irembo;

public class ServiceApplication {
    private static int counter = 1;
    private int applicantId;
    private Citizen applicant;
    private GovernmentService serv;
    private ApplicationStatus stat;
    private String payment;

    public ServiceApplication(Citizen Capplicant, GovernmentService service) {
        this.applicantId = counter++;
        this.applicant = Capplicant;
        this.serv = service;
        this.stat = ApplicationStatus.Pending;
        this.payment = "NOT_PAID";
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

    public void makePayment(double amount) throws Exception {
        if (amount != serv.getServiceFee()) {
            throw new Exception("payment must be " + serv.getServiceFee());
        }
        payment = "PAID";
    }

    public void approve() throws Exception {
        if (!payment.equals("PAID")) {
            throw new Exception("payment not completed");
        }
        if (stat != ApplicationStatus.Pending) {
            throw new Exception("only approval for pending applicants");
        }
        stat = ApplicationStatus.Approved;
    }

    public void reject() throws Exception {
        if (stat != ApplicationStatus.Pending) {
            throw new Exception("Only pending applications can be rejected.");
        }
        stat = ApplicationStatus.Rejected;
    }

    @Override
    public String toString() {
        return applicantId + "," + applicant.getFullname() + "," + applicant.getIdentificationNumber() + "," + serv.getServiceName() + "," + serv.getServiceFee() + "," + stat + "," + payment;
    }
}