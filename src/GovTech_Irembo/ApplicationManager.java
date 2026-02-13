package GovTech_Irembo;

import java.io.*;
import java.util.ArrayList;

public class ApplicationManager {

    private ArrayList<ServiceApplication> appList =
            new ArrayList<>();

    private final String FILE_NAME = "applications.txt";

    public void addApplication(ServiceApplication app)
            throws IOException {

        appList.add(app);
        saveToFile();
    }

    public void approveApplication(int id)
            throws ApplicationNotFoundException,
            InvalidStatusException {

        for (ServiceApplication app : appList) {

            if (app.getApplicantId() == id) {
                app.approve();
                return;
            }
        }

        throw new ApplicationNotFoundException("Application not found.");
    }

    public double calculateRevenue() {

        double total = 0;

        for (ServiceApplication app : appList) {
            if (app.getStat() == ApplicationStatus.Approved) {
                total += app.getserv().getServiceFee();
            }
        }

        return total;
    }

    private void saveToFile() throws IOException {

        BufferedWriter writer =
                new BufferedWriter(new FileWriter(FILE_NAME));

        for (ServiceApplication app : appList) {
            writer.write(app.toString());
            writer.newLine();
        }

        writer.close();
    }

}
