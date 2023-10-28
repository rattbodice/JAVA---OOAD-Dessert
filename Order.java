
public class Order {
    int orderId;
    int orderByClient;
    Dessert[] listOrder;
    String descripOrder;
    Float price;
    String typeOrder = "Offline";

    String[][] dataOrder;

    Order(int orderId){
        String[] arrayDataOrder = dataOrder[orderId];
        this.orderId = Integer.parseInt(arrayDataOrder[0]);
        this.orderByClient = Integer.parseInt(arrayDataOrder[1]);
        this.listOrder = setUpDataDessert(arrayDataOrder[2].split(","));
        this.descripOrder = arrayDataOrder[2];
        this.price = Float.parseFloat(arrayDataOrder[3]);
        if (dataOrder[4] != null){
            this.typeOrder = "Online";
        }
    }

    private Dessert[] setUpDataDessert(String[] dessert) {
        Dessert[] arrayStock = new Dessert[dessert.length];
        for(int i=0; i<dessert.length; i++){
            arrayStock[i] = new Dessert(Integer.parseInt(dessert[i]));
        }

        return arrayStock;
    }
    
}
