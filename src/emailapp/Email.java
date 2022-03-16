package emailapp;

import java.util.Scanner;

public class Email {
    private String fristName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLenght = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    // Constructor to recelve the frist name and last name
    public Email(String fristName, String lastName) {
        this.fristName = fristName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.fristName + " " + this.lastName);

        // call a method asking for the department - return the department
        this.department = setDeparment();

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLenght);
        System.out.println(" Your password is: " + this.password);

        // Combine elements to generate email
        email = fristName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Ask for the department
    private String setDeparment(){
        System.out.println("New Worker: " + fristName + " , Department Codes:\n1 for Sales\n2 for development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        }
        else if (depChoice == 2) {
            return "dev";
        }
        else if (depChoice == 3) {
            return "acct";
        }
        else {
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i =0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mallbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){ return mailboxCapacity; }
    public String getAlternateEmail(){ return alternateEmail; }
    public String getPassword() { return  password; }

    public String showInfo(){
        return "\nDISPLAY NAME: " + fristName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
