
public class BasketShop {
    int basketId;
    int forUserID;
    String createDate;
    Dessert[] dessert;
    float price;
    int quanlity;

    BasketShop(String[] dataBasket,Dessert[] listDessert){
        this.basketId = Integer.parseInt(dataBasket[0]);
        this.forUserID = Integer.parseInt(dataBasket[1]);
        this.createDate = dataBasket[2];
        this.dessert = listDessert;
        this.price = Float.parseFloat(dataBasket[3]);
        this.quanlity = Integer.parseInt(dataBasket[4]);
    }
    public Dessert[] getListDressert(){
        return dessert;
    }
    public Dessert[] setListDressert(Dessert[] dessert2){
        return dessert = dessert2;
    }
    
}
