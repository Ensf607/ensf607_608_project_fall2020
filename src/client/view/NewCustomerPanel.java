package client.view;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.controller.Observer;

/**
 * The type New customer panel.
 */
public class NewCustomerPanel extends JPanel implements ActionListener {
private JTextField fNameNew;
private JTextField lNameNew;
private JComboBox comboBox;
private JTextField addressNew;
private JTextField postalCodeNew;
private JTextField phoneNew;
private CardLayout c;
private JPanel panel;
private Observer mc;
private JButton createClient;

    /**
     * Instantiates a new New customer panel.
     *
     * @param mc the mc
     */
    public NewCustomerPanel(Observer mc) {
	this.mc=mc;
	setBackground(SystemColor.inactiveCaption);
	GridBagLayout gbl_newCustomerPanel = new GridBagLayout();
	gbl_newCustomerPanel.columnWidths = new int[]{32, 77, 18, 23, 46, 97, 0};
	gbl_newCustomerPanel.rowHeights = new int[]{22, 22, 22, 22, 22, 22, 47, 25, 0};
	gbl_newCustomerPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	gbl_newCustomerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	setLayout(gbl_newCustomerPanel);
	
	JLabel fnameLbl = new JLabel("First Name");
	GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
	gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
	gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
	gbc_lblNewLabel_2.gridx = 1;
	gbc_lblNewLabel_2.gridy = 0;
	add(fnameLbl, gbc_lblNewLabel_2);
	
	fNameNew = new JTextField();
	GridBagConstraints gbc_fNameNew = new GridBagConstraints();
	gbc_fNameNew.anchor = GridBagConstraints.NORTHWEST;
	gbc_fNameNew.insets = new Insets(0, 0, 5, 0);
	gbc_fNameNew.gridwidth = 4;
	gbc_fNameNew.gridx = 2;
	gbc_fNameNew.gridy = 0;
	add(fNameNew, gbc_fNameNew);
	fNameNew.setColumns(10);
	
	JLabel lblLastName = new JLabel("Last Name");
	GridBagConstraints gbc_lblLastName = new GridBagConstraints();
	gbc_lblLastName.fill = GridBagConstraints.HORIZONTAL;
	gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
	gbc_lblLastName.gridx = 1;
	gbc_lblLastName.gridy = 1;
	add(lblLastName, gbc_lblLastName);
	
	lNameNew = new JTextField();
	lNameNew.setColumns(10);
	GridBagConstraints gbc_lNameNew = new GridBagConstraints();
	gbc_lNameNew.anchor = GridBagConstraints.NORTHWEST;
	gbc_lNameNew.insets = new Insets(0, 0, 5, 0);
	gbc_lNameNew.gridwidth = 4;
	gbc_lNameNew.gridx = 2;
	gbc_lNameNew.gridy = 1;
	add(lNameNew, gbc_lNameNew);
	
	JLabel lblType= new JLabel("Type");
	GridBagConstraints gbc_lblType_1 = new GridBagConstraints();
	gbc_lblType_1.fill = GridBagConstraints.HORIZONTAL;
	gbc_lblType_1.insets = new Insets(0, 0, 5, 5);
	gbc_lblType_1.gridx = 1;
	gbc_lblType_1.gridy = 2;
	add(lblType, gbc_lblType_1);
	
	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] {"R", "C"}));
	GridBagConstraints gbc_comboBox = new GridBagConstraints();
	gbc_comboBox.anchor = GridBagConstraints.NORTHEAST;
	gbc_comboBox.insets = new Insets(0, 0, 5, 5);
	gbc_comboBox.gridwidth = 2;
	gbc_comboBox.gridx = 2;
	gbc_comboBox.gridy = 2;
	add(comboBox, gbc_comboBox);
	
	JLabel lblAddress = new JLabel("Address");
	GridBagConstraints gbc_lblAddress = new GridBagConstraints();
	gbc_lblAddress.fill = GridBagConstraints.HORIZONTAL;
	gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
	gbc_lblAddress.gridx = 1;
	gbc_lblAddress.gridy = 3;
	add(lblAddress, gbc_lblAddress);
	
	addressNew = new JTextField();
	addressNew.setColumns(10);
	GridBagConstraints gbc_addressNew = new GridBagConstraints();
	gbc_addressNew.anchor = GridBagConstraints.NORTHWEST;
	gbc_addressNew.insets = new Insets(0, 0, 5, 0);
	gbc_addressNew.gridwidth = 4;
	gbc_addressNew.gridx = 2;
	gbc_addressNew.gridy = 3;
	add(addressNew, gbc_addressNew);
	
	JLabel Postal = new JLabel("Postal Code");
	GridBagConstraints gbc_Postal = new GridBagConstraints();
	gbc_Postal.fill = GridBagConstraints.HORIZONTAL;
	gbc_Postal.insets = new Insets(0, 0, 5, 5);
	gbc_Postal.gridx = 1;
	gbc_Postal.gridy = 4;
	add(Postal, gbc_Postal);
	
	postalCodeNew = new JTextField();
	postalCodeNew.setColumns(10);
	GridBagConstraints gbc_postalCodeNew = new GridBagConstraints();
	gbc_postalCodeNew.anchor = GridBagConstraints.NORTHWEST;
	gbc_postalCodeNew.insets = new Insets(0, 0, 5, 0);
	gbc_postalCodeNew.gridwidth = 4;
	gbc_postalCodeNew.gridx = 2;
	gbc_postalCodeNew.gridy = 4;
	add(postalCodeNew, gbc_postalCodeNew);
	
	JLabel lblPhoneNumber = new JLabel("Phone Number");
	GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
	gbc_lblPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
	gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
	gbc_lblPhoneNumber.gridx = 1;
	gbc_lblPhoneNumber.gridy = 5;
	add(lblPhoneNumber, gbc_lblPhoneNumber);
	
	phoneNew = new JTextField();
	phoneNew.setColumns(10);
	GridBagConstraints gbc_phoneNew = new GridBagConstraints();
	gbc_phoneNew.anchor = GridBagConstraints.NORTHWEST;
	gbc_phoneNew.insets = new Insets(0, 0, 5, 5);
	gbc_phoneNew.gridwidth = 3;
	gbc_phoneNew.gridx = 2;
	gbc_phoneNew.gridy = 5;
	add(phoneNew, gbc_phoneNew);
	
	createClient = new JButton("SignUp");
	GridBagConstraints gbc_createClient = new GridBagConstraints();
	gbc_createClient.insets = new Insets(0, 0, 5, 0);
	gbc_createClient.anchor = GridBagConstraints.NORTH;
	gbc_createClient.fill = GridBagConstraints.HORIZONTAL;
	gbc_createClient.gridx = 5;
	gbc_createClient.gridy = 6;
	add(createClient, gbc_createClient);
	createClient.addActionListener(this);
}

    /**
     * Sets card layout.
     *
     * @param c the c
     */
    public void setCardLayout(CardLayout c) {
	this.c=c;
}

    /**
     * Sets panel.
     *
     * @param panel the panel
     */
    public void setPanel(JPanel panel) {
	this.panel=panel;
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==createClient) {
		//TODO get all fields
		String json=null;
		String response=mc.request(json);
		JOptionPane.showMessageDialog(this, response);
		c.show(panel, "purchase");
		//return message 
	}
	
}

}
