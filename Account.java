import java.util.Scanner;

public class Account {
    
    //declare variables
    private String passwordHint;

    //constructor
    public Account(String passwordHint) {
        //attributes
        this.passwordHint = passwordHint;
    }

    //method
    public void displayHint() {
        System.out.println(passwordHint);
    }

    //main method 
    public static void main(String[] args) {
        System.out.println("Login");

        @SuppressWarnings("resource")
        Scanner myScanner = new Scanner(System.in);
        String username;
        String password;

        boolean isValidUsername = false;
        boolean isValidPassword = false;

        Account account = new Account("Cow and.....");

        while(!isValidUsername) {
            System.out.println("Enter username: ");
            username = myScanner.nextLine();

            if (username.equals("test")) {
                isValidUsername = true;
                
                while(!isValidPassword) {

                    System.out.println("Enter password or type 'hint' for a password hint: ");
                    password = myScanner.nextLine();

                    if(password.equals("Chicken")) {
                        System.out.println("Login to account " + username + " has been successful");
                        isValidPassword = true;
                    } else if (password.equalsIgnoreCase("hint")) {  
                        System.out.println("Hint: ");
                        account.displayHint();
                    } else {
                        System.out.println("Incorrect password, try again...");
                    }
                }

            } else {
                System.out.println("Incorrect username, try again...");
            }

        }
    }

}
