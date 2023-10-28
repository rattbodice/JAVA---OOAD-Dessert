public class Material {
    int materialId;
    String name;
    int stockMaterial;
    String createDate;

    String[][] dataMaterials = {{"0","Coconut Milk","5","2023-10-10"}};
    

    Material(int idMaterials){
        String[] material = dataMaterials[idMaterials];
        this.materialId = Integer.parseInt(material[0]);
        this.name = material[1];
        this.stockMaterial = Integer.parseInt(material[2]);
        this.createDate = material[3];
    }

    
}
