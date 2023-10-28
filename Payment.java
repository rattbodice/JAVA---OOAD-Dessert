public class Payment {
    int paymentId;
    String paymentBranch;
    String IDCard;
    String Date;
    
    String[][] dataPayment;

    Payment(int paymentId){
        String[] arrayDataPayment = dataPayment[paymentId];
        this.paymentId = Integer.parseInt(arrayDataPayment[0]);
        this.paymentBranch = arrayDataPayment[1];
        this.IDCard = arrayDataPayment[2];
        this.Date = arrayDataPayment[3];
    }
}
