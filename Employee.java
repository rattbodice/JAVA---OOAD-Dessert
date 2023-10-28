import java.sql.*;
import java.util.Scanner;

public class Employee extends User {
    private static int salary;
    private static int level;

    Employee(String[] dataUser, int salary2, int level2) {
        super(dataUser);
        salary = salary2;
        level = level2;
    }

    public static void modeEmployee() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Menu:");
            System.out.println("1. Dessert");
            System.out.println("2. Materials");
            System.out.println("3. Order");
            System.out.println("4. Receipt");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    toDessertMode();
                    break;
                case 2:
                    toMaterialsMode();
                    break;
                case 3:
                    toOrderMode();
                    break;
                case 4:
                    toReceiptMode();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static int getSalary() {
        return salary;
    }

    public static int getLevel() {
        return level;
    }

    //////////////////////////////// InterfaceZone

    private static void toDessertMode() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------");
            System.out.println("Dessert Manangement:");
            System.out.println("1. Sell Dessert");
            System.out.println("2. Add Dessert");
            System.out.println("3. Edit Dessert");
            System.out.println("4. Delete Dessert");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sellDessert();
                    break;
                case 2:
                    addDessert();
                    break;
                case 3:
                    editDessert();
                    break;
                case 4:
                    deleteDessert();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    modeEmployee();
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void toMaterialsMode() {

    }

    private static void toOrderMode() {

    }

    private static void toReceiptMode() {

    }

    /////////////// function dessert mode

    private static void sellDessert() {
        try {
            
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------");
            Scanner scanner = new Scanner(System.in);
            Dessert dessert = new Dessert();
            dessert.fetchAllMenuDessert();
            while (true) {
                System.out.println();
                System.out.print("Please select ID dessert :");
                int choice = scanner.nextInt();
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.println("Your Order |V|");
                
                System.out.println("1 : Have more");
                System.out.println("2 : Check Bill");
                System.out.println("3 : Exit");
                System.out.print("Select an option: ");
                int choice2 = scanner.nextInt();

                switch (choice2) {
                    case 1:
                    continue;
                    case 2:
                        
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

        } catch (Exception e) {
            System.out.println("SQL DESSERT ERROR");
        }

    }

    private static void checkBill(int[] idDesserts,int countSelect) {

    }

    // private static String generateMaterials(String materialsDessert){
    // String[] indexMat = materialsDessert.split(",");
    // Connection connection = db.getConnection();
    // try {
    // Statement statement = connection.createStatement();
    // ResultSet resultSet = statement.executeQuery("SELECT * FROM material");
    // } catch (Exception e) {
    // // TODO: handle exception
    // }
    // }

    private static void addDessert() {

    }

    private static void editDessert() {

    }

    private static void deleteDessert() {

    }
}
