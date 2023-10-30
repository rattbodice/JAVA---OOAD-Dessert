import java.util.Arrays;

public class Dessert {
    int dessertId;
    String dessertName;
    String describeDessert;
    int price;
    int stockDessert;
    static Material[] material;
    String expirationDate;
    String createDate;

    static String[][] dataArrayDessert = {{"0","Khanom Krok","","25","5","0:1","2022-10-10","2022-10-10"}};


    Dessert(){

    }

    Dessert(int dessertId){
        String[] dataDessert = dataArrayDessert[dessertId];
        this.dessertId = Integer.parseInt(dataDessert[0]);
        this.dessertName = dataDessert[1];
        this.describeDessert = dataDessert[2];
        this.price = Integer.parseInt(dataDessert[3]);
        this.stockDessert = Integer.parseInt(dataDessert[4]);
        this.material = setUpArrayMaterials(dataDessert[5]);
        this.expirationDate = dataDessert[6];
        this.createDate = dataDessert[7];
    }

    public int getId(){
        return this.dessertId;
    }

    public String getName(){
        return this.dessertName;
    }

    public int getStockDessert(){
        return this.stockDessert;
    }

    public int getPrice(){
        return this.price;
    }

    public static void addDessert(String[] arrayDessert){
        int mostId = Integer.parseInt(dataArrayDessert[dataArrayDessert.length-1][0]);
        String[][] newArray2D = addRow(dataArrayDessert, arrayDessert);
        dataArrayDessert = newArray2D;
        System.out.println(Arrays.toString(dataArrayDessert));
    }

    public static void setDessert(String[] newDessert,int id){
        dataArrayDessert[id] = newDessert;
    }
    
    static void deleteDessert(int id){
        String[][] updateArray = deleteRowById(dataArrayDessert, id);
        dataArrayDessert = updateArray;
    }

    static void getListItemDessert(){
        for(int i=0;i<dataArrayDessert.length;i++){
                System.out.print("ID: "+dataArrayDessert[i][0]+", Name: "+dataArrayDessert[i][1]+", Price: "+dataArrayDessert[i][3]+", Stock: "+dataArrayDessert[i][4]+
                ", Expiration Date: "+dataArrayDessert[i][6]+"\n");

                

        }
    }

    static void getMaterials(){
        for (int i = 0; i < material.length; i++) {
            if (i!=0) System.out.print(","); 
            System.out.print(material[i].name);
        }
        System.out.println();
    }

    private Material[] setUpArrayMaterials(String materialsString) {
        String[] idMaterials2 = materialsString.split(":");
        Material[] Array = new Material[idMaterials2.length];

        for(int i=0; i<Array.length; i++){
            Array[i] = new Material(Integer.parseInt(idMaterials2[i]));
        }
        return Array;
    }

    // ลบข้อมูลแถว
    public static String[][] deleteRowById(String[][] dataArray, int id) {
        int rows = dataArray.length;
        int cols = dataArray[0].length;
        
        // Count the number of rows that won't be deleted
        int count = 0;
        for (int i = 0; i < rows; i++) {
            if (!dataArray[i][0].equals(Integer.toString(id))) {
                count++;
            }
        }
        
        // Create a new array with the rows that are not deleted
        String[][] newArray = new String[count][cols];
        int newIndex = 0;
        
        for (int i = 0; i < rows; i++) {
            if (!dataArray[i][0].equals(Integer.toString(id))) {
                for (int j = 0; j < cols; j++) {
                    newArray[newIndex][j] = dataArray[i][j];
                }
                newIndex++;
            }
        }
        
        return newArray;
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
