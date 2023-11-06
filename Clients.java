import java.util.Date;
import java.util.Scanner;

public class Clients extends User{
    
    Clients(String[] dataUser){
        super(dataUser);
    }

    static void modeClients(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            System.out.println("-------------------------------------------------------");
            System.out.println("                         On : 5.00 AM - 9.00 AM |Close all monday and sunday :)");
            System.out.println("Menu:");
            System.out.println("1. Dessert");
            System.out.println("2. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    toDessertMode();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void toDessertMode() {

        int[] orderId = new int[10];
        Dessert[] desserOrder = new Dessert[10];
        int[] amountDessertOrder = new int[10];
        int amountSelect = 0;
        Scanner scanner = new Scanner(System.in);
        Dessert dessert = new Dessert();

        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------");
            System.out.println("Dessert");
            dessert.getListItemDessert();
            System.out.println();
            System.out.print("Please select ID dessert :");
            int choice = scanner.nextInt();
            System.out.print("Please input amount of Dessert :");
            int amount = scanner.nextInt();
            orderId[amountSelect] = choice;
            amountDessertOrder[amountSelect] = amount;
            amountSelect++;

            for (int i = 0; i < 10; i++) {
                System.out.println();
            }

            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------");
            System.out.println("Your Order |V|");
            for (int i = 0; i < amountSelect; i++) {
                desserOrder[i] = new Dessert(orderId[i]);
                System.out.println("Order " + (i + 1) + " | ID: " + desserOrder[i].getId() + ", Name: "
                        + desserOrder[i].getName() + ", Price: " + desserOrder[i].getPrice() + " Bath" + ", Amount : "
                        + amountDessertOrder[i]);
            }
            System.out.println();
            System.out.println("1 : Have more");
            System.out.println("2 : Check Bill");
            System.out.println("3 : Exit");
            System.out.print("Select an option: ");
            int choice2 = scanner.nextInt();

            switch (choice2) {
                case 1:
                    continue;
                case 2:
                    checkBill(desserOrder, amountDessertOrder, amountSelect);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            return;
        }
    }

    private static void checkBill(Dessert[] orderDessert, int[] amountOrderDessert, int amountSelect) {
        int sumprice = 0;
        int allamount = 0;

        for (int i = 0; i < amountSelect; i++) {
            sumprice = sumprice + (orderDessert[i].getPrice() * amountOrderDessert[i]);
            allamount = allamount + amountOrderDessert[i];
        }
        Date currentDate = new Date();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------");
            System.out.println("Bill : " + currentDate);
            for (int i = 0; i < amountSelect; i++) {
                System.out.println((i + 1) + ". " + orderDessert[i].dessertName + "   " + orderDessert[i].price
                        + " Bath" + "   Amount " + amountOrderDessert[i]);
            }
            System.out.println("Total : " + sumprice + " Bath.");
            System.out.println("1 : Confirm Order");
            System.out.println("2 : Cancle");
            System.out.print("Select an option: ");
            int choice2 = scanner.nextInt();

            switch (choice2) {
                case 1:
                    break;
                case 2:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            Order order = new Order();
            Payment payment = new Payment();
            Payment.fetchPayment();
            System.out.println("1 : Confirm Payment");
            System.out.println("2 : Cancle");
            System.out.print("Select an option: ");
            switch (choice2) {
                case 1:
                    break;
                case 2:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            int choice =  scanner.nextInt();
            int mostId = Integer.parseInt(Order.dataOrder[Order.dataOrder.length - 1][0])+1;
            String orderToString;
            //// generate String Array to String 88 is Offline
            orderToString = "" + mostId + "," + "88" + ",";
            for (int i = 0; i < amountSelect; i++) {
                if (i != 0) {
                    orderToString = orderToString + "|";
                }
                orderToString = orderToString + orderDessert[i].dessertId + ":" + amountOrderDessert[i];
            }
            orderToString = orderToString + "," + "Front Shop" + "," + sumprice + "," + "Online"+ ","+"Not Finished";
            order.addListOrderOnline(orderToString);

            return;        

        }

    }

    public static int getClientId(){
        return userId;
    }

    public static String getName(){
        return fname+lname;
    }

    public static String  getUsername(){
        return username;
    }

    public static String getEmail(){
        return email;
    }

    public static Date getCreateDate(){
        return createDate;
    }

    public static void setName(String newName){
        fname = newName;
    }

    public static void setUsername(String newUsername){
        username=newUsername;
    }

    public static void setPassword(String newPassword){
        password=newPassword;
    }

    public static void setEmail(String newEmail){
        email=newEmail;
    }

    public static void setCreateDate(Date newDate){
        createDate = newDate;
    }

}
