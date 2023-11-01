import java.sql.*;
import java.util.Scanner;

public class App {
    static String[][] manager = {{"0","Rathabod","Khiaolee","manager","123","rathabodk64@nu.ac.th","2022-10-22","25000","3"}};
    static String[][] employee = {{"0","Rathabod","Khiaolee","employee","123","rathabodk64@nu.ac.th","2022-10-22","12000","3"}};
    static String[][] clients = {{"0","Rathabod","Khiaolee","client","123","rathabodk64@nu.ac.th","2022-10-22"}};

    static int indexUser;
    

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Welcome To Dessert CRUD");
        ///// LOGIN
        Login();

    }

    private static void Login() {
        Scanner sc = new Scanner(System.in);

        while (true) {
        System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Please login !");
        System.out.print("Username = ");
        String username = sc.nextLine();
        System.out.print("Password = ");
        String password = sc.nextLine();

        if (checkManager(username,password)) {
            System.out.println("You are manager");
            int salary = Integer.parseInt(manager[indexUser][7]);
            int level = Integer.parseInt(manager[indexUser][8]);
            Manager user = new Manager(manager[indexUser],salary , level);
            user.modeManager();
        }else if (checkEmployee(username, password)){
            System.out.println("You are employee");
            int salary = Integer.parseInt(employee[indexUser][7]);
            int level = Integer.parseInt(employee[indexUser][8]);
            Employee user = new Employee(employee[indexUser],salary , level);
            user.modeEmployee();
        }else if (checkClient(username,password)){
            Clients client = new Clients(clients[indexUser]);
            client.modeClients();
        }

        }

        
    }

    private static boolean checkManager(String username,String password){
        for(int i=0 ; i<manager.length ; i++){
                if (manager[i][3].equals(username) && manager[i][4].equals(password)) {
                    indexUser=i;
                    return true;
                }
            }
            return false;
    }

    private static boolean checkEmployee(String username,String password){
        for(int i=0 ; i<employee.length ; i++){
                if (employee[i][3].equals(username) && employee[i][4].equals(password)) {
                    indexUser=i;
                    return true;
                }
            }
            return false;
    }

    private static boolean checkClient(String username,String password){
        for(int i=0 ; i<clients.length ; i++){
                if (clients[i][3].equals(username) && clients[i][4].equals(password)) {
                    
                    indexUser=i;
                    return true;
                }
            }
            return false;
    }

}
