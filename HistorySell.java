public class HistorySell {
    int historyOrderId;
    Receipt receipt;
    int Price;
    String Date;

    String[][] dataHistory;

    HistorySell(int historyId){
        String[] arrayDataHistory = dataHistory[historyId];
        this.historyOrderId = Integer.parseInt(arrayDataHistory[0]);
        Receipt receipt = new Receipt(Integer.parseInt(arrayDataHistory[1]));
    }
}
