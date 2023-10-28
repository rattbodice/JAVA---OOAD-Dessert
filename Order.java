
public class Order {
    int orderId;
    int orderByClient;
    Dessert[] listOrder;
    int[] amountListOrder;
    String descripOrder;
int price;
    String typeOrder = "Offline";

    static String[][] dataOrder = {{"0","88","0:3","Client love this","30.00","Offline"},
{"1","88","0:3","Client love this","30.00","Offline"}};

    Order(int orderId){
        String[] arrayDataOrder = dataOrder[orderId];
        this.orderId = Integer.parseInt(arrayDataOrder[0]);
        this.orderByClient = Integer.parseInt(arrayDataOrder[1]);
        this.listOrder = setUpDataDessert(arrayDataOrder[2].split(","));
        this.descripOrder = arrayDataOrder[2];
        this.price = Integer.parseInt(arrayDataOrder[3]);
        if (dataOrder[4] != null){
            this.typeOrder = "Online";
        }
    }

    Order(){

    }

    
    
    public void addListOrder(String order){
        ///// generate string to string array with ","
        String[] arrOrder = order.split(",");
        String[][] newArray2D = addRow(dataOrder,arrOrder);
        /// เพิ่ม order ใหม่เข้าไปในข้อมูล
        dataOrder = newArray2D;
        if(arrOrder[(arrOrder.length)-1].equals("Offline")){
            /// เพิ่มใบเสร็จ ส่ง ข้อมูลออเดอร์ กับ ราคารวมเข้าไป
            int sumprice = Integer.parseInt(dataOrder[dataOrder.length-1][4]);
            Receipt.addReceipt(dataOrder[dataOrder.length-1][2],sumprice);
            Receipt.printReceipt();
        }
        System.out.println(order);
    }
    
    /// เซ็ต class dessert ด้วย id
    private Dessert[] setUpDataDessert(String[] dessert) {
        Dessert[] arrayStock = new Dessert[dessert.length];
        for(int i=0; i<dessert.length; i++){
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
