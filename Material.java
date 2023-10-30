import java.util.Scanner;

public class Material {
    int materialId;
    String name;
    int stockMaterial;
    String createDate;

    static String[][] dataMaterials = {
        {"0","Coconut Milk","5","2023-10-10"},
        {"1","Panda Leaf","5","2023-10-10"}
};

    static String[][] notifyMaterials = {
        {"0","0" ,"2023-12-12"}  //Idnotify //IdMatorial //
    };
    

    Material(int idMaterials){
        String[] material = dataMaterials[idMaterials];
        this.materialId = Integer.parseInt(material[0]);
        this.name = material[1];
        this.stockMaterial = Integer.parseInt(material[2]);
        this.createDate = material[3];
    }

    Material(){
        
    }

    static void getListMaterials(){
        for (int i = 0; i < dataMaterials.length; i++) {
            System.out.println("ID: "+dataMaterials[i][0]+", Name: "+dataMaterials[i][1]+", Stock: "+dataMaterials[i][2]);
        }
    }

    public static void addMaterial(String[] newMaterial) {

        // Calculate the new length of the dataMaterials array
        int newLength = dataMaterials.length + 1;
        // Create a new array with the updated length
        String[][] newDataMaterials = new String[newLength][];
        // Copy the old dataMaterials into the new array
        for (int i = 0; i < dataMaterials.length; i++) {
            newDataMaterials[i] = dataMaterials[i];
        }
        // Add the new material to the end of the new array
        newDataMaterials[newLength - 1] = newMaterial;
        // Update the dataMaterials reference
        dataMaterials = newDataMaterials;
    }

    public static void setMaterialId(String materialId ){
        Scanner scanner = new Scanner(System.in);
        int materialIndex = -1;

        for (int i = 0; i < dataMaterials.length; i++) {
            if (dataMaterials[i][0].equals(materialId)) {
                materialIndex = i;
                break;
            }
        }

        if (materialIndex != -1) {
            System.out.println("------------Old Material Data------------");
            System.out.println("ID: " + dataMaterials[materialIndex][0]);
            System.out.println("Name: " + dataMaterials[materialIndex][1]);
            System.out.println("Stock Material: " + dataMaterials[materialIndex][2]);
            System.out.println("Create Date: " + dataMaterials[materialIndex][3]);

            System.out.print("New Material Name: ");
            String name = scanner.nextLine();

            System.out.print("New Stock Material: ");
            int stockMaterial = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            System.out.print("New Create Date (YYYY-MM-DD): ");
            String createDate = scanner.nextLine();

            dataMaterials[materialIndex][1] = name;
            dataMaterials[materialIndex][2] = String.valueOf(stockMaterial);
            dataMaterials[materialIndex][3] = createDate;

            System.out.println("Material with ID " + materialId + " updated.");
        } else {
            System.out.println("Material with ID " + materialId + " not found.");
        }
    }

    public static void deleteMaterial(String materialId2){
        Scanner scanner = new Scanner(System.in);
        int materialIndex = -1;

        for (int i = 0; i < dataMaterials.length; i++) {
            if (dataMaterials[i][0].equals(materialId2)) {
                materialIndex = i;
                break;
            }
        }

        if (materialIndex != -1) {
            System.out.println("Are you sure you want to delete the material with ID " + materialId2 + " ?");
            System.out.println("1: Yes");
            System.out.println("2: No");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    dataMaterials = deleteRowById(dataMaterials, materialIndex);
                    System.out.println("Material with ID " + materialId2 + " deleted.");
                    return;
                case 2:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } else {
            System.out.println("Material with ID " + materialId2 + " not found.");
        }

        
    }
    public static String[][] deleteRowById(String[][] array, int rowIndex) {
        if (rowIndex >= 0 && rowIndex < array.length) {
            String[][] newArray = new String[array.length - 1][array[0].length];
            int destIndex = 0;
            for (int srcIndex = 0; srcIndex < array.length; srcIndex++) {
                if (srcIndex != rowIndex) {
                    System.arraycopy(array[srcIndex], 0, newArray[destIndex], 0, array[0].length);
                    destIndex++;
                }
            }
            return newArray;
        }
        return array;
    }

    public static void addNotifyMaterial(Scanner scanner) {
        String notifyId = notifyMaterials[notifyMaterials.length-1][0];
        getListMaterials();
        System.out.print("Enter Material ID: ");
        String materialId = scanner.nextLine();

        System.out.print("Enter Notification Date (YYYY-MM-DD): ");
        String notificationDate = scanner.nextLine();

        String[] newNotifyMaterial = {notifyId, materialId, notificationDate};

        // Calculate the new length of the notifyMaterials array
        int newLength = notifyMaterials.length + 1;

        // Create a new array with the updated length
        String[][] newNotifyMaterials = new String[newLength][];
        
        // Copy the old notifyMaterials into the new array
        for (int i = 0; i < notifyMaterials.length; i++) {
            newNotifyMaterials[i] = notifyMaterials[i];
        }
        
        // Add the new notify material to the end of the new array
        newNotifyMaterials[newLength - 1] = newNotifyMaterial;

        // Update the notifyMaterials reference
        notifyMaterials = newNotifyMaterials;

        System.out.println("Notify Material added successfully.");
    }
}
