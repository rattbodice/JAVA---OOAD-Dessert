public class Receipt {
    int receiptId;
    Order listMenu;
    int sumPrice;
    Payment payBy;
    Employee doBy;
    String createDate;
    Clients clientId;

    String[][] dataReceipt;

    Receipt(int idReceipt) {
        String[] arrayDataReceipt = dataReceipt[idReceipt];
        this.receiptId = Integer.parseInt(arrayDataReceipt[0]);
        this.listMenu = new Order(Integer.parseInt(arrayDataReceipt[1]));
        this.payBy = new Payment(Integer.parseInt(arrayDataReceipt[2]));
        this.doBy = new Employee(arrayDataReceipt, idReceipt, idReceipt);
        this.createDate = createDate;
        this.clientId = new Clients(arrayDataReceipt);
    }
}
