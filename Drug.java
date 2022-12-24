package model;

public class Drug {
    public String ref;
    public String wording;
    public String descript;
    public int quantity;
    public float price;
    
    public String drugDisplayInfos() {
        return ("Drug reference social number: "+ this.ref +
        		"\nDrug wording: "+ this.wording+
                "\nDrug description: "+this.descript+
                "\nDrug quantity: "+this.quantity+
                "\nDrug price: "+this.price+" €");
        		
    }

    public Drug(String ref, String wording, String descript, int quantity, float price) {
        this.ref = ref;
        this.wording = wording;
        this.descript = descript;
        this.quantity = quantity;
        this.price = price;
    }
    
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
    
}
    
