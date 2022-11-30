package model;
import javax.swing.JOptionPane;

public class socialNumberException extends Exception{
	
	public socialNumberException(String errorMessage) {
		//call constructer
		JOptionPane.showMessageDialog(null, "Error : The customer security number must be more than 13 characters");
	}
}
