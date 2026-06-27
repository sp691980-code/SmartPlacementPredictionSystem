import java.util.Scanner;

public class Login {

    public static boolean login() {

        Scanner sc = new Scanner(System.in);

        String username = "Shubham Pandey";
        String password = "272202";

          System.out.println("==========================================");
           System.out.println("     SMART PLACEMENT PREDICTION SYSTEM");
           System.out.println("==========================================");
           System.out.println("           LOGIN PORTAL");
           System.out.println("==========================================");
           
           System.out.print("Username : ");
           String u = sc.nextLine();
           
           System.out.print("Password : ");
           String p = sc.nextLine();

        if(u.equals(username) && p.equals(password))
        {
            System.out.println("\nLogin Successful!");
            return true;
        }
        else
        {
            System.out.println("\nInvalid Username or Password!");
            return false;
        }
    }
}