public class Payment {
    int paymentId;
    String paymentBranch;
    String IDCard;
    String Date;
    
    static String[][] dataPayment = {{"0","Krungthai","6120216618","2023-10-10"}};

    Payment(int paymentId){
        String[] arrayDataPayment = dataPayment[paymentId];
        this.paymentId = Integer.parseInt(arrayDataPayment[0]);
        this.paymentBranch = arrayDataPayment[1];
        this.IDCard = arrayDataPayment[2];
        this.Date = arrayDataPayment[3];
    }

    Payment(){

    }

    public static void fetchPayment(){
        for (int i = 0; i < dataPayment.length; i++) {
            System.out.println("ID: "+dataPayment[i][0]+" , Name: "+dataPayment[i][1]+" , IDCard: "+dataPayment[i][2]);
        }
    }
}
