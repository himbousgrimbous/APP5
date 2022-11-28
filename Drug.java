package model;

public class Drug {
    public String ref;
    public String wording;
    public String descript;
    public int quantity;
    public float price;
    
    public Drug(String ref, String wording, String descript, int quantity, float price) {
        this.ref = ref;
        this.wording = wording;
        this.descript = descript;
        this.quantity = quantity;
        this.price = price;
    }
}
