import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Receipt {
    static int receiptId;
    static Order listMenu;
    static int sumPrice;
    static Payment payBy;
    static String doBy;
    static String createDate;
    static Clients clientId;

    static String[][] dataReceipt = { { "0", "0:2|0:1", "75", "Client", "Employee", "2022-10-10", "0" } };

    Receipt(int idReceipt) {
        String[] arrayDataReceipt = dataReceipt[idReceipt];
        this.receiptId = Integer.parseInt(arrayDataReceipt[0]);
        this.listMenu = new Order(Integer.parseInt(arrayDataReceipt[1]));
        this.payBy = new Payment(Integer.parseInt(arrayDataReceipt[2]));
        this.doBy ="employee";
        this.createDate = createDate;
        this.clientId = new Clients(arrayDataReceipt);
    }

    Receipt() {

    }

    public static void fetchReceiptManager() {
        int sumPrice = 0;
        for (int i = 0; i < dataReceipt.length; i++) {

            System.out.print("ID: " + dataReceipt[i][0] + " , ");
            String[] array = dataReceipt[i][1].split("\\|");
            for (int h = 0; h < array.length; h++) {
                String[] parts = array[h].split(":");
                // for (int j = 0; j < array2.length; j+=2) {
                if (parts.length == 2) {
                    if (h != 0)
                        System.out.print(", ");
                    int id = Integer.parseInt(parts[0]);
                    int quantity = Integer.parseInt(parts[1]);
                    Dessert mat = new Dessert(id);
                    System.out.print(mat.dessertName + "|" + quantity);
                }
                // }
            }
            System.out.print(" Price: " + dataReceipt[i][2]);
            sumPrice += Integer.parseInt(dataReceipt[i][2]);
            System.out.println();

        }
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------");
        System.out.println("All Price :" + sumPrice);
    }

    public static void fetchReceipt() {
        for (int i = 0; i < dataReceipt.length; i++) {
            System.out.print("ID: " + dataReceipt[i][0] + " , ");
            String[] array = dataReceipt[i][1].split("\\|");
            for (int h = 0; h < array.length; h++) {
                String[] parts = array[h].split(":");
                // for (int j = 0; j < array2.length; j+=2) {
                if (parts.length == 2) {
                    if (h != 0)
                        System.out.print(", ");
                    int id = Integer.parseInt(parts[0]);
                    int quantity = Integer.parseInt(parts[1]);
                    Dessert mat = new Dessert(id);
                    System.out.print(mat.dessertName + "|" + quantity);
                }
                // }
            }
            System.out.print(" Price: " + dataReceipt[i][2]);
            System.out.println();
        }
    }

    public static void printReceipt() {
        String[] arr = dataReceipt[dataReceipt.length - 1];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        System.out.println("*****************************************");
        System.out.println("      Date : " + arr[5]);
        System.out.println("      Purchase ID : " + arr[0]);
        System.out.println("*****************************************");
        String[] orderAmount = arr[1].split("\\|");
        // System.out.println(Arrays.toString(orderAmount));
        int sumprice = 0;
        for (int i = 0; i < orderAmount.length; i++) {
            String[] orderAmountInt = orderAmount[i].split(":");
            Dessert dessert = new Dessert(Integer.parseInt(orderAmountInt[0]));
            int amount = Integer.parseInt(orderAmountInt[1]);
            sumprice += dessert.price * amount;
            System.out.println((i + 1) + ". " + dessert.dessertName + " Amount: " + amount + " Price: "
                    + (dessert.price * amount));
        }
        System.out.println("*****************************************");
        System.out.println("      Sub Total : " + sumprice);
        System.out.println("      Tex       : 0");
        System.out.println("      Order Total :" + sumprice);
        System.out.println("*****************************************");
        System.out.print("Press Enter to continue...");
        scanner.nextLine(); // Wait for the user to press Enter
    }

    static void printReceipt(int receiptId) {
        String[] arr = dataReceipt[receiptId];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        System.out.println("*****************************************");
        System.out.println("      Date : " + arr[5]);
        System.out.println("      Purchase ID : " + arr[0]);
        System.out.println("*****************************************");
        String[] orderAmount = arr[1].split("\\|");
        // System.out.println(Arrays.toString(orderAmount));
        int sumprice = 0;
        for (int i = 0; i < orderAmount.length; i++) {
            String[] orderAmountInt = orderAmount[i].split(":");
            Dessert dessert = new Dessert(Integer.parseInt(orderAmountInt[0]));
            int amount = Integer.parseInt(orderAmountInt[1]);
            sumprice += dessert.price * amount;
            System.out.println((i + 1) + ". " + dessert.dessertName + " Amount: " + amount + " Price: "
                    + (dessert.price * amount));
        }
        System.out.println("*****************************************");
        System.out.println("      Sub Total : " + sumprice);
        System.out.println("      Tex       : 0");
        System.out.println("      Order Total :" + sumprice);
        System.out.println("*****************************************");
        System.out.print("Press Enter to continue...");
        scanner.nextLine(); // Wait for the user to press Enter
    }

    public static void addReceipt(String dataOrder, int sumprice) {
        int mostId = Integer.parseInt(dataReceipt[dataReceipt.length - 1][0]) + 1;
        /// เอาเวลาตอนนี้
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        /////

        String[] newReceipt = { Integer.toString(mostId), dataOrder, Integer.toString(sumprice), "Client", "Employee",
                formattedDate, "0" };
        // System.out.println(newReceipt);
        String[][] newArray2D = addRow(dataReceipt, newReceipt);
        dataReceipt = newArray2D;
        // System.out.println(Arrays.deepToString(dataReceipt));
    }

    // เพิ่ม แถวข้อมูล
    public static String[][] addRow(String[][] originalArray, String[] newRow) {
        int numRows = originalArray.length;
        int numCols = originalArray[0].length;

        String[][] newArray = new String[numRows + 1][numCols];

        // Copy existing data
        for (int i = 0; i < numRows; i++) {
            System.arraycopy(originalArray[i], 0, newArray[i], 0, numCols);
        }

        // Add the new row
        System.arraycopy(newRow, 0, newArray[numRows], 0, numCols);

        return newArray;
    }

    public static int getReceiptld(){
        return receiptId;
    }
    public static Order getListMenu(){
        return listMenu;
    }
    public static int getSumPrice(){
        return sumPrice;
    }
    public static Payment getPayBy(){
        return payBy;
    }
    public static String getDoBy(){
        return doBy;
    }
    public static String getCreateDate(){
        return createDate;
    }
    public static Clients getClientId(){
        return clientId;
    }
    public static void setListMenu(Order ListMenu2){
        listMenu = ListMenu2;
    }
    public static void setSumPrice(int SumPrice2){
        sumPrice=SumPrice2;
    }
    public static void setPayBy(Payment PayBy2){
        payBy = PayBy2;
    }
    public static void setDoby(String DoBy2){
        doBy = DoBy2;
    }
    public static void setCreateDate(String CreateDate2){
        createDate = CreateDate2;
    }
}
