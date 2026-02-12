package GovTech_Irembo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private List<User> Use = new ArrayList<>();

    public UserManager() throws IOException {
        loadUsersFromFile();
    }

    private void loadUsersFromFile() throws IOException {
        File f = new File("users.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        try (Scanner reader = new Scanner(f)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Use.add(new User(parts[0], parts[1]));
                }
            }
        }
    }

    public void signUp(User user) throws IOException {
        for (User u : Use) {
            if (u.getUsername().equals(user.getUsername())) {
                throw new RuntimeException("Username already exists");
            }
        }
        Use.add(user);
        try (FileWriter w = new FileWriter("users.txt", true)) {
            w.write(user.getUsername() + "," + user.getPassword() + "\n");
        }
    }

    public void login(String username, String password) {
        for (User u : Use) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return;
            }
        }
        throw new RuntimeException("Invalid credentials");
    }
}