import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Functions functions = new Functions();      // Contains the methods to perform CRUD operations on the students table.

        try {
            // Establish Connection to the PostgreSQL server.
            Connection connection = functions.getConnection();
            System.out.println("Connected to the Final Project V2 server successfully.");

            // Make the user choose between logging in or signing up.
            System.out.println(
                    "Choose an option: \n " +
                            "1: Log in. \n " +
                            "2: Sign up. \n "
            );

            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            int option = Integer.valueOf(input);

            // Loop until the user chooses a valid option.
            while (option != 1 && option != 2) {
                System.out.println("Invalid option. Please choose again.");
                System.out.println(
                        "Choose an option: \n " +
                                "1: Log in. \n " +
                                "2: Sign up. \n "
                );
                input = in.nextLine();
                option = Integer.valueOf(input);
            }

            if (option == 1) {
                // Log in.
                if (!functions.logIn(connection)) {
                    return;
                }
            } else {
                // Sign up.
                if (!functions.signUp(connection)) {
                    return;
                }
            }

            // Show the user's information in a dashboard.

            // Initialize a few variables we'll need later.
            option = 1;


            // CODE STOPS HERE
//
//            // As long as the user doesn't choose to exit the program, keep asking for an option.
//            while (option > 0 && option < 5){
//                System.out.println(
//                        "\n Choose an option: \n " +
//                                "1: View/Update Personal Information. \n " +
//                                "2: View/Update Health Metrics. \n " +
//                                "3: View/Update Fitness Goals. \n " +
//                                "4: Register for a Personal Training Session / Group Fitness Class. \n " +
//                                "0: Log out and Exit. \n "
//                );
//
//                in = new Scanner(System.in);
//                input = in.nextLine();
//                option = Integer.valueOf(input);
//
//                // Perform the selected operation.
//                switch (option) {
//                    case 1:
//                    case 2:
//                    case 3:
//                    case 4:
//                    default:
//                        // Exit the program.
//                        System.out.println("Exiting the program.");
//                        functions.closeConnection(connection);
//                        return;
//                }
//            }
//            // Catch any exceptions that occur and alert the user.
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}