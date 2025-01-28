/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import admin.admin;
import instructor.instructor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import student.student;
/**
 *
 * @author pc
 */
public class LoginHandler {
      public static void performLogin(String emailx, String passx) {
        try {
            File filex = new File("C:\\Users\\pc\\Desktop\\Pl2Project.txt");
            Scanner scan = new Scanner(filex);
            scan.useDelimiter("[,\n]");

            boolean credentialsFound = false;

            while (scan.hasNext()) {
                String name = scan.next();
                String email = scan.next();
                String password = scan.next();
                String role = scan.next();

                if (emailx.equals(email.trim()) && passx.equals(password.trim())) {
                    handleLoggedIn(role.trim());
                    credentialsFound = true;
                    break;
                }
            }

            if (!credentialsFound) {
                JOptionPane.showMessageDialog(null, "Invalid data");
            }

            scan.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage());
        } catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(null, "Invalid file format: " + e.getMessage());
        }
    }
      public static void handleLoggedIn(String role) {
        switch (role) {
            case "admin":
                JOptionPane.showMessageDialog(null, "You are logged in as admin");
                admin a = new admin();
                a.setVisible(true);
                break;
            case "student":
                JOptionPane.showMessageDialog(null, "You are logged in as a student");
                student s = new student();
                s.setVisible(true);
                break;
            case "instructor":
                JOptionPane.showMessageDialog(null, "You are logged in as an instructor");
                instructor i = new instructor();
                i.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Unknown role: " + role);
                break;
        }
    }
    
}
