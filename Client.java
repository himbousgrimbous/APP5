package model;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Client {


	    public String firstName;
	    public String lastName;
	    public String socialNb;
	    public String phoneNb;
	    public String address;
	    public float totalPrice;
	    public ArrayList<BoughtDrug> medicineList;
	    public String clientDisplayInfos() {
        	return ("Client's social number: "+ this.socialNb +
        		"\nClient's name: "+ this.lastName+ " "+this.firstName+
                "\nClient's phone number: "+this.phoneNb+
                "\nClient's address: "+this.address+
                "\nClient's total bill price: "+this.totalPrice+ " €"+
                "\nClient's drug(s) bought: ");
   		}

		public Client(String socialNb, String firstName, String lastName, String phoneNb, String address) throws Exception {
	        if (socialNb.length() < 13) {
	            throw new Exception("The social number is too short !");
	        }
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.socialNb = socialNb;
	        this.phoneNb = phoneNb;
	        this.address = address;
	        this.medicineList = new ArrayList<BoughtDrug>();
	    }
		
		public static String buildClientDrugPanel(Client client) {
			String textToDisplay = new String();
			
			if (!client.getMedicineList().isEmpty()) {
			for(BoughtDrug d : client.getMedicineList()) {
				textToDisplay += "\n- " + d.getWording() + ": " + d.getQuantity()+" units";
			}
			return textToDisplay;
		}
		return null;
	}
		
		public static void addTotalPrice(Client client, float priceToAdd) {
			client.setTotalPrice(client.getTotalPrice() + priceToAdd);;
		}
		
	    public void addDrug(BoughtDrug medicine) {
	        medicineList.add(medicine);
	    }

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getSocialNb() {
			return socialNb;
		}

		public void setSocialNb(String socialNb) {
			this.socialNb = socialNb;
		}

		public String getPhoneNb() {
			return phoneNb;
		}

		public void setPhoneNb(String phoneNb) {
			this.phoneNb = phoneNb;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public ArrayList<BoughtDrug> getMedicineList() {
			return medicineList;
		}

		public void setMedicineList(ArrayList<BoughtDrug> medicineList) {
			this.medicineList = medicineList;
		}

		public float getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(float totalPrice) {
			this.totalPrice = totalPrice;
		}
  
}
