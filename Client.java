package model;

import java.util.ArrayList;

public class Client {

	    //Ceci est un test
	    public String firstName;
	    public String lastName;
	    public String socialNb;
	    public String phoneNb;
	    public String address;
	    public ArrayList<Drug> medicineList;
	    public Client(String socialNb, String firstName, String lastName, String phoneNb, String address) throws Exception {
	        if (socialNb.length() < 13) {
	            throw new Exception("The social number is too short !");
	        }
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.socialNb = socialNb;
	        this.phoneNb = phoneNb;
	        this.address = address;
	        this.medicineList = new ArrayList<Drug>();
	    }
	    public void addDrug(Drug medicine) {
	        medicineList.add(medicine);
	    }    
}
