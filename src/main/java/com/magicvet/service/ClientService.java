package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import static main.java.com.magicvet.Main.SCANNER;

public class ClientService {
    private static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static String NAME_PATTERN = "^[a-zA-Z]{3,}(-? ?[a-zA-Z]{3,})?";;

    public Client registerNewClient() {
        Client client = null;
        System.out.println("Please provide client details.");

        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();
        if (!isEmailValid(email)) {
            System.out.println("Provided email is invalid.");
            return client;
        }

        System.out.print("First name: ");
        String firstName = Main.SCANNER.nextLine();
        if (!isNameValid(firstName)) {
            System.out.println("Provided first nam is invalid.");
            return client;
        }

        System.out.print("Last name: ");
        String lastName = Main.SCANNER.nextLine();
        if (isNameValid(lastName)) {
            client = buildClient(email, firstName, lastName);
            System.out.println("New client: " + client.getFirstName() + " "
                    + client.getLastName() + " ("
                    + client.getEmail() + ")");
        } else {
            System.out.println("Provided last nam is invalid.");
        }
        return client;
    }//registerNewClient()

    private static Client buildClient(String email, String firstName, String lastName) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        return client;
    }//buildClient()

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }//isEmailValid()

    private static boolean isNameValid(String Name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(Name);
        return  matcher.matches();
    }//isNameValid()

}//class ClientService
