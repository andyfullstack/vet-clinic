package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String PASSWORD = "default";
    public static Scanner SCANNER = new Scanner(System.in);
    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "^[a-zA-Z]{3,}(-?[a-zA-Z]{3,})?";;

    public static void main(String[] args) {
        run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }
    }

    static boolean auth() {
        boolean accepted = false;
        for(int i=0; i<3; i++) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();
            if(PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }
        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked.");
        return accepted;
    }//auth()

    static void registerNewClient() {
        System.out.println("Please provide client details.");

        System.out.print("Email: ");
        String email = SCANNER.nextLine();
        if (!isEmailValid(email)) {
            System.out.println("Provided email is invalid.");
            return;
        }

        System.out.print("First name: ");
        String firstName = SCANNER.nextLine();
        if (!isNameValid(firstName)) {
            System.out.println("Provided first nam is invalid.");
            return;
        }

        System.out.print("Last name: ");
        String lastName = SCANNER.nextLine();
        if (isNameValid(lastName)) {
            Client client = buildClient(email, firstName, lastName);
            System.out.println("New client: " + client.firstName + " " + client.lastName + " (" +client.email + ")");
        } else {
            System.out.println("Provided last nam is invalid.");
        }

    }//registerNewClient()

     static Client buildClient(String email, String firstName, String lastName) {
         Client client = new Client();
         client.email = email;
         client.firstName = firstName;
         client.lastName = lastName;
         return client;
     }//buildClient()

     static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }//isEmailValid()

    static boolean isNameValid(String Name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(Name);
        return  matcher.matches();
    }//isNameValid()

}//class Main()

