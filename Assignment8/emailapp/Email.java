package emailapp;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Email {

    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String alternateEmail;
    private final String PASSWORD_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
    private String[] departments = new String[] {"Sales", "Development", "Accounting"};

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = this.randomPassword(this.defaultPasswordLength);
        this.department = this.SetDepartment();
    }

    public String getEmail() {
        if (!this.department.equals("none")) {
            return String.format("%s.%s@%s.%s",
                    this.firstName,
                    this.lastName,
                    this.department,
                    this.companySuffix);
        }
        return String.format("%s.%s@%s",
                this.firstName,
                this.lastName,
                this.companySuffix);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String email) {
        this.alternateEmail = email;
    }

    public String getName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    public int getMailboxCapacity() {
        return this.mailboxCapacity;
    }

    public String getDepartment() {
        return this.department;
    }

    public String showInfo() {
        return  String.format("DISPLAY NAME: %s\n", this.getName()) +
                String.format("Department: %s\n", this.getDepartment()) +
                String.format("COMPANY EMAIL: %s\n", this.getEmail()) +
                String.format("PASSWORD: %s\n", this.password) +
                String.format("MAILBOX CAPACITY: %dmb", this.getMailboxCapacity());
    }

    // Ask for the department
    private String SetDepartment() {
        System.out.printf("New Worker: %s. Department Codes:\n", this.getName());
        StringBuilder deptSb = new StringBuilder();
        for (int i = 0; i < this.departments.length; i++) {
            deptSb.append(String.format("%d for %s\n", i + 1, this.departments[i]));
        }
        deptSb.append("0 for none");
        System.out.println(deptSb.toString());

        Scanner deptScanner  = new Scanner(System.in);
        String department = "none";

        int index = 0;
        try {
            index= deptScanner.nextInt();
        } catch(Exception e) {
            this.department = department;
        }
        if (index > 0 && index < this.departments.length) {
            department = this.departments[index - 1];
        }
        this.department = department;
        return this.department;
    }

    // Generate a random password
    private String randomPassword(int length) {
        Random rand = new Random();
        int setLength = this.PASSWORD_SET.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(setLength);
            sb.append(PASSWORD_SET.charAt(index));
        }
        return sb.toString();
    }

}

