import java.sql.*;
import java.util.Scanner;
import java.util.Date;

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
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            System.out.println("-------------------------------------------------------");
            System.out.println("Menu:");
            System.out.println("1. Dessert");
            System.out.println("2. Materials");
            System.out.println("3. Order");
            System.out.println("4. Exit");
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

    public static int getEmployeeId() {
        return userId;
    }

    public static String getName() {
        return fname + lname;
    }

    public static String getUserName() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getEmail() {
        return email;
    }

    public static Date getCreateDate() {
        return createDate;
    }

    public static void setName(String name2) {
    }
    public static void setUsername(String username2){
        username = username2;
    }
    public static void setPassword(String password2){
        password = password2;
    }
    public static void setEmail(String email2){
        email = email2;
    }
    public static void setCreateDate(Date createDate2){
        createDate = createDate2;
    }

    //////////////////////////////// InterfaceZone

    private static void toDessertMode() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------");
            System.out.println("Dessert Manangement:");
            System.out.println("1. Sell Dessert");
            System.out.println("2. Add Dessert");
            System.out.println("3. Edit Dessert");
            System.out.println("4. Delete Dessert");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Select an option: ");

            int choiceMenu = scanner.nextInt();

            switch (choiceMenu) {
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
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void toMaterialsMode() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------");
            System.out.println("Materials Manangement:");
            System.out.println("1. Fetch Materials");
            System.out.println("2. Add Material");
            System.out.println("3. Edit Material");
            System.out.println("4. Delete Material");
            System.out.println("5. Notyfy empty material");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Select an option: ");

            int choiceMenu = scanner.nextInt();

            switch (choiceMenu) {
                case 1:
                    fetchMaterial();
                    break;
                case 2:
                    addMaterials();
                    break;
                case 3:
                    editMaterials();
                    break;
                case 4:
                    deleteMaterials();
                    break;
                case 5:
                    notifyMaterial();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void toOrderMode() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------");
            System.out.println("Orders Manangement:");
            System.out.println("1. Fetch Order");
            System.out.println("2. Finish Order");
            System.out.println("3. Print receipt order");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Select an option: ");

            int choiceMenu = scanner.nextInt();

            switch (choiceMenu) {
                case 1:
                    fetchOrder();
                    break;
                case 2:
                    finisheOrder();
                    break;
                case 3:
                    printReceipt();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void toReceiptMode() {

    }

    /////////////// function dessert mode

    private static void sellDessert() {

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
            System.out.println("Selling Dessert");
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
            int mostId = Integer.parseInt(order.dataOrder[order.dataOrder.length - 1][0]);
            String orderToString;
            //// generate String Array to String 88 is Offline
            orderToString = "" + mostId + "," + "88" + ",";
            for (int i = 0; i < amountSelect; i++) {
                if (i != 0) {
                    orderToString = orderToString + "|";
                }
                orderToString = orderToString + orderDessert[i].dessertId + ":" + amountOrderDessert[i];
            }
            orderToString = orderToString + "," + "Front Shop" + "," + sumprice + "," + "Offline" + "," + "Finished";
            order.addListOrder(orderToString);

            return;
            // int mostId = Integer.parseInt(order.dataOrder[order.dataOrder.length-1][0]);
            // System.out.println("************************************************************************************************************");
            // System.out.println("Date : "+currentDate.toString());
            // System.out.println("Purchase : "+(mostId+1));

        }

    }

    private static void addDessert() {
        Scanner scanner = new Scanner(System.in);

        String dessertName, dessertDes, dessertPrice, dessertStock, dessertMat = "", dessertExpi;
        Material mat = new Material();
        String[][] dataMaterials = mat.dataMaterials;
        int[] stockIdSelect = new int[10];
        int countSelect = 0;
        Dessert dessert = new Dessert();
        String mostId = Integer.toString(Integer.parseInt(dessert.dataArrayDessert[dessert.dataArrayDessert.length - 1][0]) + 1);

        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------");
            System.out.println("Add Dessert");
            System.out.print("Dessert Name : ");
            dessertName = scanner.nextLine();
            System.out.print("Dessert Description : ");
            dessertDes = scanner.nextLine();
            System.out.print(" Dessert Price : ");
            dessertPrice = scanner.nextLine();
            System.out.print("Dessert Expiration Date (Example | yyyy-mm-dd): ");
            dessertExpi = scanner.nextLine();
            System.out.print("Dessert Stock : ");
            dessertStock = scanner.nextLine();
            System.out.println("Materials of Dessert");
            int choice = 99;
            while (true) {
                for (int i = 0; i < dataMaterials.length; i++) {

                    System.out.print("ID : " + dataMaterials[i][0]);
                    System.out.print(" , Name : " + dataMaterials[i][1]);
                    System.out.print(" , Stock : " + dataMaterials[i][2]);

                    System.out.println();
                }
                System.out.println();
                try {
                    System.out.print("Please input ID of Material : ");
                    if (choice != 99) {
                        dessertMat += ":";
                    }
                    choice = scanner.nextInt();

                    stockIdSelect[countSelect] = choice;
                    dessertMat += choice;

                    countSelect++;

                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid ID." + e);
                }
                System.out.println("----------------------------------");
                System.out.print("Dessert Materials : ");

                for (int j = 0; j < countSelect; j++) {
                    for (int k = 0; k < dataMaterials.length; k++) {
                        if (Integer.parseInt(dataMaterials[k][0]) == stockIdSelect[j]) {
                            if (j != 0) {
                                System.out.print(",");
                            }
                            System.out.print(dataMaterials[k][1]);

                        }
                    }

                }

                System.out.println("\n1 : Have more");
                System.out.println("2 : Complete");
                System.out.print("Select an option:");
                int choice2 = scanner.nextInt();

                switch (choice2) {
                    case 1:
                        dessertMat += ":";
                        continue;
                    case 2:
                        String[] newDessert = { mostId, dessertName, dessertDes, dessertPrice, dessertStock, dessertMat,
                                dessertExpi, dessertExpi };
                        Dessert.addDessert(newDessert);
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }

            }

        }

    }

    private static void editDessert() {
        Scanner scanner = new Scanner(System.in);
        int idSelect;
        Dessert dessert = new Dessert();
        String nameDes, descripDes, priceDes, stockDes, dessertMat = "";
        Material mat = new Material();
        String[][] dataMaterials = mat.dataMaterials;
        int[] stockIdSelect = new int[10];
        int countSelect = 0;

        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------");
            System.out.println("Edit Dessert");
            Dessert.getListItemDessert();
            System.out.print("Please input ID do you want to edit : ");
            idSelect = scanner.nextInt();
            Dessert oldDessert = new Dessert(idSelect);
            System.out.println("Old Dessert Name : " + oldDessert.dessertName);
            System.out.print("New Dessert Name : ");
            scanner.nextLine(); // Consume the newline
            nameDes = scanner.nextLine();
            System.out.println("Old Dessert Description : ");
            System.out.print("New Dessert Description : ");
            descripDes = scanner.nextLine();
            System.out.println("Old Dessert Price : " + oldDessert.price);
            System.out.print("New Dessert Price : ");
            priceDes = scanner.nextLine();
            System.out.println("Old Dessert Stock : " + oldDessert.stockDessert);
            System.out.print("New Dessert Stock : ");
            stockDes = scanner.nextLine();

            int choice = 99;
            while (true) {
                System.out.print("Old Dessert Materials : ");
                oldDessert.getMaterials();
                for (int i = 0; i < dataMaterials.length; i++) {

                    System.out.print("ID : " + dataMaterials[i][0]);
                    System.out.print(" , Name : " + dataMaterials[i][1]);
                    System.out.print(" , Stock : " + dataMaterials[i][2]);

                    System.out.println();
                }
                System.out.println();
                try {
                    System.out.print("Please input ID of Material : ");
                    if (choice != 99) {
                        dessertMat += ":";
                    }
                    choice = scanner.nextInt();

                    stockIdSelect[countSelect] = choice;
                    dessertMat += choice;

                    countSelect++;

                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid ID." + e);
                }
                System.out.println("----------------------------------");
                System.out.print("Dessert Materials : ");

                for (int j = 0; j < countSelect; j++) {
                    for (int k = 0; k < dataMaterials.length; k++) {
                        if (Integer.parseInt(dataMaterials[k][0]) == stockIdSelect[j]) {
                            if (j != 0) {
                                System.out.print(",");
                            }
                            System.out.print(dataMaterials[k][1]);

                        }
                    }

                }

                System.out.println("\n1 : Have more");
                System.out.println("2 : Complete");
                System.out.print("Select an option:");
                int choice2 = scanner.nextInt();

                switch (choice2) {
                    case 1:
                        dessertMat += ":";
                        continue;
                    case 2:
                        String[] arrayNewDessert = { Integer.toString(oldDessert.dessertId), nameDes, descripDes,
                                priceDes, stockDes, dessertMat, oldDessert.expirationDate, oldDessert.expirationDate };
                        dessert.setDessert(arrayNewDessert, oldDessert.dessertId);
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }

            }
        }

    }

    private static void deleteDessert() {
        Scanner scanner = new Scanner(System.in);
        Dessert dessert = new Dessert();
        int idSelect = 99;
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        while (true) {
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------");
            System.out.println("Delete dessert");
            Dessert.getListItemDessert();
            System.out.print("\n Please input ID do you want to delete : ");
            idSelect = scanner.nextInt();
            System.out.println("Are you want to delete ID " + idSelect + " ?");
            System.out.println("1: Yes");
            System.out.println("2: No");
            System.out.print("Select an option:");
            int choice2 = scanner.nextInt();
            switch (choice2) {
                case 1:
                    dessert.deleteDessert(idSelect);
                    return;
                case 2:

                    continue;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }

    /////// funtion material
    private static void fetchMaterial() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        Material.getListMaterials();
        System.out.print(" press Enter to continue...");
        scanner.nextLine();
    }

    private static void addMaterials() {
        Material mat = new Material();
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------");
        System.out.println("Add Meterial");
        Scanner scanner = new Scanner(System.in);
        int materialId = Integer.parseInt(mat.dataMaterials[mat.dataMaterials.length - 1][0] + 1);

        System.out.print("Material Name: ");
        String name = scanner.nextLine();

        System.out.print("Stock Material: ");
        int stockMaterial = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Create Date (YYYY-MM-DD): ");
        String createDate = scanner.nextLine();
        String[] newMaterial = {
                String.valueOf(materialId),
                name,
                String.valueOf(stockMaterial),
                createDate
        };
        Material.addMaterial(newMaterial);
    }

    private static void editMaterials() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        Material.getListMaterials();
        System.out.print("Enter Material ID to update: ");
        String materialId = scanner.nextLine();
        Material.setMaterialId(materialId);
    }

    private static void deleteMaterials() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        Material.getListMaterials();
        System.out.print("Enter Material ID to delete: ");
        String materialId = scanner.nextLine();

        Material.deleteMaterial(materialId);
    }

    private static void notifyMaterial() {
        Scanner scanner = new Scanner(System.in);
        Material.addNotifyMaterial(scanner);
    }

    //// Order Zone
    private static void fetchOrder() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        Order.getListOrder(1);
        System.out.print(" press Enter to continue...");
        scanner.nextLine();
    }

    private static void finisheOrder() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        Order.getListOrder(3);
        System.out.print("Input ID order to finish status : ");
        int idOrder = scanner.nextInt();
        System.out.println("Are you sure to finish this order id " + idOrder);
        System.out.println("1.Yes");
        System.out.println("2.No");
        System.out.print("Select an option:");
        int choice2 = scanner.nextInt();

        switch (choice2) {
            case 1:
                Order.setStatusOrder(idOrder);
                break;
            case 2:
                return;

            default:
                break;
        }

    }

    private static void printReceipt() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        Receipt.fetchReceipt();
        System.out.print("Enter Order ID to print receipt: ");
        int materialId = scanner.nextInt();
        Receipt.printReceipt(materialId);
    }

}
