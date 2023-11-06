
public class Order {
    int orderId;
    int orderByClient;
    Dessert[] listOrder;
    int[] amountListOrder;
    String descripOrder;
    int price;
    String typeOrder = "Offline";
    String status = "Not Finish";

    static String[][] dataOrder = { { "0", "88", "0:3", "Client love this", "30", "Offline", "Not Finished" },};

    Order(int orderId) {
        String[] arrayDataOrder = dataOrder[orderId];
        this.orderId = Integer.parseInt(arrayDataOrder[0]);
        this.orderByClient = Integer.parseInt(arrayDataOrder[1]);
        this.listOrder = setUpDataDessert(arrayDataOrder[2].split(","));
        this.descripOrder = arrayDataOrder[2];
        this.price = Integer.parseInt(arrayDataOrder[3]);
        if (dataOrder[4] != null) {
            this.typeOrder = "Online";
        }
    }

    Order() {

    }

    public void addListOrder(String order) {
        ///// generate string to string array with ","
        String[] arrOrder = order.split(",");
        String[][] newArray2D = addRow(dataOrder, arrOrder);
        /// เพิ่ม order ใหม่เข้าไปในข้อมูล
        dataOrder = newArray2D;
        if (arrOrder[(arrOrder.length) - 2].equals("Offline")) {
            /// เพิ่มใบเสร็จ ส่ง ข้อมูลออเดอร์ กับ ราคารวมเข้าไป
            int sumprice = Integer.parseInt(dataOrder[dataOrder.length - 1][4]);
            Receipt.addReceipt(dataOrder[dataOrder.length - 1][2], sumprice);
            Receipt.printReceipt();
        }
        System.out.println(order);
    }

    public void addListOrderOnline(String order) {
        ///// generate string to string array with ","
        String[] arrOrder = order.split(",");
        String[][] newArray2D = addRow(dataOrder, arrOrder);
        /// เพิ่ม order ใหม่เข้าไปในข้อมูล
        dataOrder = newArray2D;
        
        System.out.println(order);
    }

    public static void getListOrder(int choice) {
        if (choice == 1) {
            for (int i = 0; i < dataOrder.length; i++) {

                
                    System.out.print("ID: " + dataOrder[i][0] + ", Dessert: ");
                    String[] array = dataOrder[i][2].split("\\|");
                    for (int h = 0; h < array.length; h++) {
                        String[] parts = array[h].split(":");
                        // for (int j = 0; j < array2.length; j+=2) {
                            if (parts.length == 2) {
                                if (h!=0) System.out.print(", ");
                                int id = Integer.parseInt(parts[0]);
                                int quantity = Integer.parseInt(parts[1]);
                                Dessert mat = new Dessert(id);
                                System.out.print(mat.dessertName+"|"+quantity);
                            }
                        // }
                    }
                System.out.print(", Dessert Description: " + dataOrder[i][3] + ", Price: " + dataOrder[i][4] + "  "
                        + dataOrder[i][5] + "  " + dataOrder[i][6]);
                System.out.println();

            }

        } else if (choice == 2) {
            for (int i = 0; i < dataOrder.length; i++) {
                if (dataOrder[i][dataOrder[0].length - 1].equals("Finished")) {
                    System.out.print("ID: " + dataOrder[i][0] + ", Dessert: ");
                    String[] array = dataOrder[i][2].split("\\|");
                    for (int h = 0; h < array.length; h++) {
                        String[] parts = array[h].split(":");
                        // for (int j = 0; j < array2.length; j+=2) {
                            if (parts.length == 2) {
                                if (h!=0) System.out.print(", ");
                                int id = Integer.parseInt(parts[0]);
                                int quantity = Integer.parseInt(parts[1]);
                                Dessert mat = new Dessert(id);
                                System.out.print(mat.dessertName+"|"+quantity);
                            }
                        // }
                    }
                    System.out.print(", Dessert Description: " + dataOrder[i][3] + ", Price: " + dataOrder[i][4] + "  "
                            + dataOrder[i][5] + "  " + dataOrder[i][6]);
                    System.out.println();
                }
            }
        } else if (choice == 3) {
            for (int i = 0; i < dataOrder.length; i++) {
                if (dataOrder[i][dataOrder[0].length - 1].equals("Not Finished")) {
                    System.out.print("ID: " + dataOrder[i][0] + ", Dessert: ");
                    String[] array = dataOrder[i][2].split("\\|");
                    for (int h = 0; h < array.length; h++) {
                        String[] parts = array[h].split(":");
                        // for (int j = 0; j < array2.length; j+=2) {
                            if (parts.length == 2) {
                                if (h!=0) System.out.print(", ");
                                int id = Integer.parseInt(parts[0]);
                                int quantity = Integer.parseInt(parts[1]);
                                Dessert mat = new Dessert(id);
                                System.out.print(mat.dessertName+"|"+quantity);
                            }
                        // }
                    }
                    System.out.print(", Dessert Description: " + dataOrder[i][3] + ", Price: " + dataOrder[i][4] + "  "
                            + dataOrder[i][5] + "  " + dataOrder[i][6]);
                    System.out.println();
                }
            }
        }

    }

    public static void setStatusOrder(int orderId) {
        for (int i = 0; i < dataOrder.length; i++) {
            if (dataOrder[i][0].equals(Integer.toString(orderId))) {
                // Assuming "Status" is the last element in the row
                int statusIndex = dataOrder[i].length - 1;
                dataOrder[i][statusIndex] = "Finished";
                Receipt.addReceipt(dataOrder[i][2], Integer.parseInt(dataOrder[i][4]));
                return; // Exit the loop after updating the status
            }
        }
        System.out.println("Order ID not found");
    }

    /// เซ็ต class dessert ด้วย id
    private Dessert[] setUpDataDessert(String[] dessert) {
        Dessert[] arrayStock = new Dessert[dessert.length];
        for (int i = 0; i < dessert.length; i++) {
            arrayStock[i] = new Dessert(Integer.parseInt(dessert[i]));
        }

        return arrayStock;
    }

    /// แอดข้อมูลเข้าอาเรย์ 1 แถว
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
    
}
