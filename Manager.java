import java.util.Scanner;

public class Manager extends Employee{

    Manager(String[] dataUser,int salary, int level){
    super(dataUser,salary,level);
    }

    static void modeManager(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            System.out.println("-------------------------------------------------------");
            System.out.println("Menu:");
            System.out.println("1. History Sell");
            System.out.println("2. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    getHistoyrySell();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void getHistoyrySell() {
        Scanner scanner = new Scanner(System.in);
        int idSelect;
        Dessert dessert = new Dessert();
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.println(
                    "--------------------------------------------------------------------------------------------------------------");
        Receipt.fetchReceiptManager();
        while (true) {
            System.out.println(
                        "--------------------------------------------------------------------------------------------------------------");
                System.out.println("Do you want to do something ?");
                System.out.println("1: Print Receipt");
                System.out.println("2: Exit");
                System.out.print("Select an option:");
                int choice2 = scanner.nextInt();
                switch (choice2) {
                    case 1:
                    selectPrintReceipt();
                        return;
                    case 2:
    
                        continue;
    
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

    }

    private static void selectPrintReceipt() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        Receipt.fetchReceiptManager();
        System.out.print("Select ID receipt to print : ");
        int choice = scanner.nextInt();
        Receipt.printReceipt(choice);
        System.out.print("press Enter to continue...");
        scanner.nextLine();
    }
}