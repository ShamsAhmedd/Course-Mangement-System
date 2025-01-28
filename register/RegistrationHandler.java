/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package register;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class RegistrationHandler {
     private static final String FILE_PATH = "C:\\Users\\pc\\Desktop\\Pl2Project.txt";

    public static boolean isEmailExists(String email) {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                if (fields.length >= 2 && email.trim().equals(fields[1].trim())) {
                    scanner.close();
                    return true; // Email already exists
                }
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace(); // Handle this exception properly in your application
        }

        return false; // Email does not exist
    }

    public static void registerUser(String name, String email, String password,String role) {
        try {
            if (!isEmailExists(email)) {
                // Append to the file
                FileWriter fileWriter = new FileWriter(FILE_PATH, true);
                PrintWriter printer = new PrintWriter(fileWriter);
                printer.println(name + "," + email + "," + password +","+role);
                                
                printer.close();
                JOptionPane.showMessageDialog(null, "Registration done");
            } else {
                JOptionPane.showMessageDialog(null, "Email already exists. Please choose another.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle this exception properly in your application
        }
    }
}