import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Drug;
import model.Client;

public class Main {

	public static void main(String[] args) {

		/**
		 * Data
		 */

		ArrayList<Client> clientArrayList = new ArrayList<>();
		ArrayList<Drug> drugArrayList = new ArrayList<>();

		// Set up Frame
		JFrame mFrame = new JFrame("Pharmacy Management");
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setBounds(0,0,950,600);

		// Client table views
		JPanel clientListPanel = new JPanel();
		clientListPanel.setLayout(new BoxLayout(clientListPanel, BoxLayout.Y_AXIS));
		JLabel clientListTitle = new JLabel("Client list");
		clientListTitle.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

		DefaultTableModel clientTableModel = new DefaultTableModel();
		clientTableModel.addColumn("Social Number");
		clientTableModel.addColumn("First Name");
		clientTableModel.addColumn("Last Name");
		JTable clientTable = new JTable(clientTableModel);          
		JScrollPane clientPanel = new JScrollPane(clientTable);

		clientListPanel.add(clientListTitle);
		clientListPanel.add(clientPanel);	
		mFrame.getContentPane().add(BorderLayout.LINE_START, clientListPanel);


		//drug table view
		JPanel drugListPanel = new JPanel();
		drugListPanel.setLayout(new BoxLayout(drugListPanel, BoxLayout.Y_AXIS));
		JLabel drugListTitle = new JLabel("Drug List");
		drugListTitle.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

		DefaultTableModel drugTableModel = new DefaultTableModel();
		drugTableModel.addColumn("Drug Ref");
		drugTableModel.addColumn("Drug Label");
		drugTableModel.addColumn("Drug Quantity");
		drugTableModel.addColumn("Drug Price");
		JTable drugTable = new JTable(drugTableModel);
		JScrollPane drugPanel = new JScrollPane(drugTable);

		drugListPanel.add(drugListTitle);
		drugListPanel.add(drugPanel);
		mFrame.getContentPane().add(BorderLayout.AFTER_LINE_ENDS, drugListPanel);


		//Creating the MenuBar and adding components
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Add");
		JMenu menu2 = new JMenu("Search");
		JMenuItem menuItem11 = new JMenuItem("Add Client");
		JMenuItem menuItem12 = new JMenuItem("Add Drug");
		JMenuItem menuItem21 = new JMenuItem("Search Client");
		JMenuItem menuItem22 = new JMenuItem("Search Drug");

		menuBar.add(menu1);
		menuBar.add(menu2);
		menu1.add(menuItem11);
		menu1.add(menuItem12);
		menu2.add(menuItem21);
		menu2.add(menuItem22);

		// Add Drug show dialog button
		menuItem11.addActionListener(new ActionListener() {	

			//creating drug button
			public void actionPerformed(ActionEvent e) {

				JPanel addClientDialogPanel = new JPanel();
				addClientDialogPanel.setLayout(new BoxLayout(addClientDialogPanel, BoxLayout.Y_AXIS));

				JTextField socialField = new JTextField();
				JTextField fnameField = new JTextField();
				JTextField lnameField = new JTextField();
				JTextField phoneField = new JTextField();
				JTextField addressField = new JTextField();						

				addClientDialogPanel.add(new JLabel("Client social security number:"));
				addClientDialogPanel.add(socialField);
				addClientDialogPanel.add(Box.createHorizontalStrut(15));

				addClientDialogPanel.add(new JLabel("Client first name:"));
				addClientDialogPanel.add(fnameField);
				addClientDialogPanel.add(Box.createHorizontalStrut(15));

				addClientDialogPanel.add(new JLabel("Client last name:"));
				addClientDialogPanel.add(lnameField);
				addClientDialogPanel.add(Box.createHorizontalStrut(15));

				addClientDialogPanel.add(new JLabel("Client phone number:"));
				addClientDialogPanel.add(phoneField);
				addClientDialogPanel.add(Box.createHorizontalStrut(15));

				addClientDialogPanel.add(new JLabel("Client address:"));
				addClientDialogPanel.add(addressField);
				addClientDialogPanel.add(Box.createHorizontalStrut(15));


				int result = JOptionPane.showConfirmDialog(mFrame, addClientDialogPanel, 
						"Provide Client info", JOptionPane.OK_CANCEL_OPTION);

				if (result == JOptionPane.OK_OPTION) {

					//creating confirm panel
					JOptionPane addClientConfirm = new JOptionPane();
					int confirmClient = addClientConfirm.showConfirmDialog(null,"Do you want to confirm?","Approval request", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					//if YES clicked
					if (confirmClient == 0) {

						try {
							Client newClient = new Client(socialField.getText(), fnameField.getText(), lnameField.getText(), phoneField.getText(), 
									addressField.getText());
							clientArrayList.add(newClient);
							clientTableModel.addRow(new Object[] {newClient.socialNb, newClient.firstName, newClient.lastName});

						} catch (Exception e1) {
							// TODO Auto-generated catch block
							new JOptionPane().showMessageDialog(null, e1.getMessage(), "Error, Social Security Number too short", JOptionPane.ERROR_MESSAGE);
						}
					}

					//if NO clicked
					else if(confirmClient == 1){
						addClientConfirm.getRootFrame().dispose();
					}
					//if CLOSED clicked
					else {
						addClientConfirm.getRootFrame().dispose();
					}

				}
			}
		});


		menuItem12.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {


				JPanel addDrugDialogPanel = new JPanel();
				addDrugDialogPanel.setLayout( new BoxLayout(addDrugDialogPanel, BoxLayout.Y_AXIS));

				JTextField refField = new JTextField();
				JTextField wordingField = new JTextField();
				JTextField descriptField = new JTextField();
				JTextField quantityField = new JTextField();
				JTextField priceField = new JTextField();

				addDrugDialogPanel.add(new JLabel("Reference of the Drug"));
				addDrugDialogPanel.add(refField);
				addDrugDialogPanel.add(Box.createHorizontalStrut(15));

				addDrugDialogPanel.add(new JLabel("Label of the Drug"));
				addDrugDialogPanel.add(wordingField);
				addDrugDialogPanel.add(Box.createHorizontalStrut(15));

				addDrugDialogPanel.add(new JLabel("Description of the Drug"));
				addDrugDialogPanel.add(descriptField);
				addDrugDialogPanel.add(Box.createHorizontalStrut(15));

				addDrugDialogPanel.add(new JLabel("Quantity of the Drug in stock"));
				addDrugDialogPanel.add(quantityField);
				addDrugDialogPanel.add(Box.createHorizontalStrut(15));

				addDrugDialogPanel.add(new JLabel("Price of the Drug"));
				addDrugDialogPanel.add(priceField);
				addDrugDialogPanel.add(Box.createHorizontalStrut(15));


				int result = JOptionPane.showConfirmDialog(mFrame, addDrugDialogPanel, "Provide Drug info", JOptionPane.OK_CANCEL_OPTION);

				if (result == JOptionPane.OK_OPTION) {

					JOptionPane addDrugConfirm = new JOptionPane();
					int confirmDrug = addDrugConfirm.showConfirmDialog(null, "Do you want to Confirm","Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (confirmDrug == 0) {
						Drug newDrug = new Drug(refField.getText(), wordingField.getText(), descriptField.getText(), Integer.parseInt(quantityField.getText()),
								Float.parseFloat(priceField.getText()));

						drugArrayList.add(newDrug);
						drugTableModel.addRow(new Object[] {newDrug.ref, newDrug.wording, newDrug.quantity, newDrug.price});

					}

					else if (confirmDrug == 1) {
						addDrugConfirm.getRootFrame().dispose();
					}

					else {
						addDrugConfirm.getRootFrame().dispose();
					}

				}

			}

		});
		
		menuItem21.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Search client button action
				JPanel searchClientDialogPanel = new JPanel();
				searchClientDialogPanel.setLayout( new BoxLayout(searchClientDialogPanel, BoxLayout.Y_AXIS));
				
				JTextField searchClientField = new JTextField (20);
				
				searchClientDialogPanel.add(new JLabel("Enter the social number of the CLient "));
				searchClientDialogPanel.add(searchClientField);
				
				int result = JOptionPane.showConfirmDialog(mFrame, searchClientDialogPanel, "Provide Drug info", JOptionPane.OK_CANCEL_OPTION);

				if (result == JOptionPane.OK_OPTION) {

					JOptionPane searchClientConfirm = new JOptionPane();
					int confirmSearchClient = searchClientConfirm.showConfirmDialog(null, "Do you want to Confirm","Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (confirmSearchClient == 0) {
						for (Client c : clientArrayList) {

							if (c.socialNb.equals(searchClientField.getText())) {
								
								drugListPanel.setVisible(false);
								
								setSearchClientPanel(clientArrayList, c , mFrame, drugListPanel);
								
								mFrame.revalidate();
						        mFrame.repaint();
						        return;

								
								
							}
						}
					}

					else if (confirmSearchClient == 1) {
						searchClientConfirm.getRootFrame().dispose();
					}

					else {
						searchClientConfirm.getRootFrame().dispose();
					}

				}
			}
		});


menuItem22.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Search client button action
				JPanel searchDrugDialogPanel = new JPanel();
				searchDrugDialogPanel.setLayout( new BoxLayout(searchDrugDialogPanel, BoxLayout.Y_AXIS));
				
				JTextField searchDrugField = new JTextField (20);
				
				searchDrugDialogPanel.add(new JLabel("Enter the reference of the drug:  "));
				searchDrugDialogPanel.add(searchDrugField);
				
				int result = JOptionPane.showConfirmDialog(mFrame, searchDrugDialogPanel, "Provide Drug info", JOptionPane.OK_CANCEL_OPTION);

				if (result == JOptionPane.OK_OPTION) {

					JOptionPane searchDrugConfirm = new JOptionPane();
					int confirmSearchDrug = searchDrugConfirm.showConfirmDialog(null, "Do you want to Confirm","Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (confirmSearchDrug == 0) {
						for (Drug d : drugArrayList) {

							if (d.ref.equals(searchDrugField.getText())) {
								
								clientListPanel.setVisible(false);
								setSearchDrugPanel(drugArrayList, d , mFrame, clientListPanel);
								
								
								mFrame.revalidate();
						        mFrame.repaint();
						        return;
								
								
							}
						}
					}

					else if (confirmSearchDrug == 1) {
						searchDrugConfirm.getRootFrame().dispose();
					}

					else {
						searchDrugConfirm.getRootFrame().dispose();
					}

				}
			}
		});






		//Adding elements to the main frame
		mFrame.getContentPane().add(BorderLayout.PAGE_START, menuBar);

		// Show Frame
		mFrame.setVisible(true);

	}
	/*
	 * Functions
	 */
	
	public static void setSearchClientPanel(ArrayList<Client> clientArrayList, Client c , JFrame mFrame, JPanel drugListPanel) {
		
		if (!clientArrayList.isEmpty()) {
			
			JPanel searchClientPanel = new JPanel();
			searchClientPanel.setLayout(new BoxLayout(searchClientPanel, BoxLayout.Y_AXIS));

			JLabel searchClientTitle = new JLabel("Search Client result: \n");
			searchClientTitle.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
			
			JLabel nameLabel = new JLabel("Client name: "+c.firstName+" "+ c.lastName+"\n");
			//JLabel lnameLabel = new JLabel(c.lastName);
			JLabel socialLabel = new JLabel("Social Security Number: "+c.socialNb+"\n");
			JLabel phoneLabel = new JLabel("Client's Phone Number: "+c.phoneNb+"\n");
			JLabel addrLabel = new JLabel("Client's address: "+c.address+"\n");
			
			
			JButton returnButton = new JButton("Return to Menu");
				
			returnButton.addActionListener(new ActionListener(){
		        
				public void actionPerformed(ActionEvent e){
		        	searchClientPanel.setVisible(false);
		        	drugListPanel.setVisible(true);
		        	}
		        });


			searchClientPanel.add(searchClientTitle);
			searchClientPanel.add(nameLabel);
			searchClientPanel.add(addrLabel);
			searchClientPanel.add(socialLabel);
			searchClientPanel.add(phoneLabel);
			searchClientPanel.add(addrLabel);
			searchClientPanel.add(returnButton);
			
			mFrame.add(searchClientPanel);
			
			searchClientPanel.setVisible(true);

			searchClientPanel.repaint();
			return;
		}
			
			}
		



public static void setSearchDrugPanel(ArrayList<Drug> drugArrayList, Drug d , JFrame mFrame, JPanel clientListPanel) {
	
	//if (!clientArrayList.isEmpty()) {
		JPanel searchDrugPanel = new JPanel();
		searchDrugPanel.setLayout(new BoxLayout(searchDrugPanel, BoxLayout.Y_AXIS));
		JLabel searchDrugTitle = new JLabel("Search Drug result: \n");
		searchDrugTitle.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		
		JLabel refLabel = new JLabel("Drug Reference: "+d.ref+"\n");
		JLabel wordingLabel = new JLabel("Drug Label: "+d.wording+"\n");
		JLabel descriptLabel = new JLabel("Drug Description "+d.descript+"\n");
		JLabel quantityLabel = new JLabel("Quantity of Drug in Stock: "+d.quantity+"\n");
		JLabel priceLabel = new JLabel("Price of the Drug: "+d.price+"\n");
		
		
		JButton returnButton = new JButton("Return to Menu");
			
		returnButton.addActionListener(new ActionListener(){
	        
			public void actionPerformed(ActionEvent e){
	        	searchDrugPanel.setVisible(false);
	        	clientListPanel.setVisible(true);
	        	}
	        });


		searchDrugPanel.add(searchDrugTitle);
		searchDrugPanel.add(refLabel);
		searchDrugPanel.add(wordingLabel);
		searchDrugPanel.add(descriptLabel);
		searchDrugPanel.add(quantityLabel);
		searchDrugPanel.add(priceLabel);
		searchDrugPanel.add(returnButton);
		
		mFrame.add(searchDrugPanel);
		
		searchDrugPanel.setVisible(true);
		
		
		searchDrugPanel.revalidate();
		searchDrugPanel.repaint();

		}

}


	//Truc de Jeanne qui sert à rien pcq Côme l'a fait au dessus
	//addStudentDialogPanel.add(new JLabel("Social Security number:"));
	//addStudentDialogPanel.add(SocialSecurityNumberField);
	//addStudentDialogPanel.add(Box.creatHorizontalStrut(15));

	//addStudentDialogPanel.add(new JLabel("Surname:"));
	//addStudentDialogPanel.add(SurnameField);
	//addStudentDialogPanel.add(Box.creatHorizontalStrut(15));

	//addStudentDialogPanel.add(new JLabel("First Name:"));
	//addStudentDialogPanel.add(FirstNameField)
	//addStudentDialogPanel.add(Box.creatHorizontalStrut(15));

	//addStudentDialogPanel.add(newJLabel("Address:"));
	//addStudentDialogPanel.add(AdressField)
	//addStudentDialogPanel.add(Box.creatHorizontalStrut(15));

	//addStudentDialogPanel.add(new JLabel("Telephone Number:"));
	//addStudentDialogPanel.add(TelephoneNumberField);
	//addStudentDialogPanel.add(Box.creatHorizontalStrut(15));




