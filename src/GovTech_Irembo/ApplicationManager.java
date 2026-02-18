package GovTech_Irembo;

import java.io.*;
import java.util.ArrayList;

public class ApplicationManager {
    private ArrayList<ServiceApplication> applications;
    private int counter = 1;

    public ApplicationManager() {
        applications = new ArrayList<>();
    }

    public ServiceApplication createApplication(Citizen citizen, GovernmentService service) {
        ServiceApplication app = new ServiceApplication(citizen, service);
        applications.add(app);
        return app;
    }

    public void approve(int id) throws Exception {
        for (ServiceApplication app : applications) {
            if (app.getApplicantId() == id) {
                app.approve();
                return;
            }
        }
        throw new Exception("Application not found.");
    }

    public void reject(int id) throws Exception {
        for (ServiceApplication app : applications) {
            if (app.getApplicantId() == id) {
                app.reject();
                return;
            }
        }
        throw new Exception("Application not found.");
    }

    public double calculateRevenue() {
        double total = 0;
        for (ServiceApplication app : applications) {
            if (app.getStat() == ApplicationStatus.Approved && app.getserv().getServiceFee() > 0) {
                total += app.getserv().getServiceFee();
            }
        }
        return total;
    }
}