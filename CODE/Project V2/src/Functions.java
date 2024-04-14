import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class Functions {
    // Establishes a connection to the PostgreSQL server.
    public Connection getConnection() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/Project_V2";
        String username = "postgres";
        String password = "TheAtaraxia";        // Change this to your own password, or change your password to "TheAtaraxia".
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    // Closes the connection to the PostgreSQL server.
    public void closeConnection(Connection connection) throws Exception {
        connection.close();
    }

    // Handle Logging In
    public boolean logIn(Connection connection) throws Exception {
        // Initialize a few variables we'll need later.
        String username;
        String password;

        // Ask the user to input their username and password.
        System.out.println("Enter your username (WARNING: This is case sensitive): ");
        Scanner in = new Scanner(System.in);
        username = in.nextLine();

        System.out.println("Enter your password (WARNING: This is case sensitive): ");
        in = new Scanner(System.in);
        password = in.nextLine();

        // Check if the username and password match with any record in the users table.
        if (checkUsername(connection, username) && checkPassword(connection, password)) {
            System.out.println("Welcome to THE ATARAXIA Health & Fitness, " + username + "!");
            return true;
        } else {
            System.out.println("Invalid username or password. Exiting the program.");
            closeConnection(connection);
            return false;
        }
    }

    // Handle Signing Up
    public boolean signUp(Connection connection) throws Exception {
        // Initialize a few variables we'll need later.
        String username;
        String password;
        String address;
        String email;
        String phone_num;
        String role;

        // Ask the user to input their username, password, address, email, and phone number.
        System.out.println("Enter the username you wish to use (This will be case-sensitive): ");
        Scanner in = new Scanner(System.in);
        username = in.nextLine();

        // Check if the username already exists in the users table.
        if (checkUsername(connection, username)) {
            System.out.println("Username already exists. Exiting the program.");
            closeConnection(connection);
            return false;
        }

        System.out.println("Enter the password you wish to use (This will be case-sensitive): ");
        in = new Scanner(System.in);
        password = in.nextLine();

        System.out.println("Enter your address: ");
        in = new Scanner(System.in);
        address = in.nextLine();

        System.out.println("Enter your email: ");
        in = new Scanner(System.in);
        email = in.nextLine();

        System.out.println("Enter your phone number: ");
        in = new Scanner(System.in);
        phone_num = in.nextLine();

        // Ask the user whether they wish to be a member, trainer, or admin.
        System.out.println(
                "Which account do you wish to create: \n " +
                        "1: Member. \n " +
                        "2: Trainer. \n " +
                        "3: Admin. \n "
        );
        in = new Scanner(System.in);
        String input = in.nextLine();
        int option = Integer.valueOf(input);

        // Loop until the user chooses a valid option.
        while (option != 1 && option != 2 && option != 3) {
            System.out.println("Invalid option. Please choose again.");
            System.out.println(
                    "Which account do you wish to create: \n " +
                            "1: Member. \n " +
                            "2: Trainer. \n " +
                            "3: Admin. \n "
            );
            input = in.nextLine();
            option = Integer.valueOf(input);
        }

        if (option == 1) {
            role = "member";
        } else if (option == 2) {
            role = "trainer";
        } else {
            role = "admin";
        }

        // Insert the new user record into the users table.
        addUser(connection, username, password, address, email, phone_num, role);
        System.out.println("Almost there! Please do not close the application.");
        System.out.println("Before you may proceed to use our services, please provide us with some additional information.");

        // Insert the new member, user, or admin record into the appropriate table.
        if (role.equals("member")) {
            System.out.println("Enter your full name: ");
            in = new Scanner(System.in);
            String name = in.nextLine();

            // Get the user_id of the user we just inserted into the users table.
            int user_id = getUserID(connection, username);
            // If the user_id is -1, something went wrong.
            if (user_id == -1) {
                System.out.println("Something went wrong... Exiting the program.");
                closeConnection(connection);
                return false;
            }
            // Add the new member record into the members table.
            addMember(connection, name, user_id);
        } else if (role.equals("trainer")) {
            System.out.println("Enter your full name: ");
            in = new Scanner(System.in);
            String name = in.nextLine();

            System.out.println("Enter your specialization: ");
            in = new Scanner(System.in);
            String specialization = in.nextLine();

            System.out.println("Enter your years experience (number only): ");
            in = new Scanner(System.in);
            int experience = in.nextInt();

            System.out.println("Enter a description about the type of training you can provide: ");
            in = new Scanner(System.in);
            String description = in.nextLine();

            // Get the user_id of the user we just inserted into the users table.
            int user_id = getUserID(connection, username);

            // If the user_id is -1, something went wrong.
            if (user_id == -1) {
                System.out.println("Something went wrong... Exiting the program.");
                closeConnection(connection);
                return false;
            }

            // Add the new trainer record into the trainers table.
            addTrainer(connection, name, specialization, experience, description, user_id);
        } else {
            System.out.println("Enter your full name: ");
            in = new Scanner(System.in);
            String name = in.nextLine();

            // Get the user_id of the user we just inserted into the users table.
            int user_id = getUserID(connection, username);

            // If the user_id is -1, something went wrong.
            if (user_id == -1) {
                System.out.println("Something went wrong... Exiting the program.");
                closeConnection(connection);
                return false;
            }

            // Add the new admin record into the admins table.
            addAdmin(connection, name, user_id);
        }

        System.out.println("Welcome to THE ATARAXIA Health & Fitness, " + username + "!");
        return true;
    }

    // Insert a new user record into the users table.
    public void addUser(Connection connection, String username, String password, String address, String email, String phone_num, String role) throws Exception {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Users (role, username, password, address, email, phone_num) VALUES ('" + role + "', '" + username + "', '" + password + "', '" + address + "', '" + email + "', '" + phone_num + "')");
    }

    // Adds a new member record into the members table.
    public void addMember(Connection connection, String full_name, int user_id) throws Exception {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO members (user_id, name) VALUES (" + user_id + ", '" + full_name + "')");
    }

    // Adds a new admin record into the admins table.
    public void addAdmin(Connection connection, String full_name, int user_id) throws Exception {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO admins (user_id, name) VALUES (" + user_id + ", '" + full_name + "')");
    }

    // Adds a new trainer record into the trainers table.
    public void addTrainer(Connection connection, String full_name, String specialization, int experience, String description, int user_id) throws Exception {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO trainers (user_id, name, specialization, experience, description) VALUES (" + user_id + ", '" + full_name + "', '" + specialization + "', " + experience + ", '" + description + "')");
    }

    // Inside the users table, check if there exists a column with the specified username.
    public boolean checkUsername(Connection connection, String username) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + username + "'");
        // If there is a record with the specified username, return true.
        if (resultSet.next()) {
            return true;
        }
        // If there is no record with the specified username, return false.
        return false;
    }

    // Inside the users table, check if there exists a column with the specified password.
    public boolean checkPassword(Connection connection, String password) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE password = '" + password + "'");
        // If there is a record with the specified password, return true.
        if (resultSet.next()) {
            return true;
        }
        // If there is no record with the specified password, return false.
        return false;
    }

    // Get a user's ID from the users table by their username.
    // If the username is not found, return -1.
    public int getUserID(Connection connection, String username) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT user_id FROM users WHERE username = '" + username + "'");
        if (resultSet.next()) {
            return resultSet.getInt("user_id");
        }
        return -1;
    }

    // Get a user's role from the users table by their username.
    // If the username is not found, return "not found".
    public String getUserRole(Connection connection, String username) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT role FROM users WHERE username = '" + username + "'");
        if (resultSet.next()) {
            return resultSet.getString("role");
        }
        return "not found";
    }
}