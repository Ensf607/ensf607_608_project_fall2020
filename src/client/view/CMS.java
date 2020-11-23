package client.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import client.controller.Observer;

public class CMS extends JPanel implements ActionListener {
	private Observer mc;
	private JTextField search;
	private JButton searchClient;
	private JList list;
	private JButton clearSearch;
	private JTextField clientIDCMS;
	private JTextField fnameCMS;
	private JTextField lNameCMS;
	private Component lblAddress_1;
	private JTextField addressCMS;
	private JTextField postalCodeCMS;
	private JTextField phoneCMS;
	private JButton saveBtn;
	private JButton deleteBtn;
	private JButton clearBtn;
	int option;
	private JComboBox comboBoxClientMgmnt;

	public CMS(Observer mc) {
		this.mc=mc;
		setLayout(new BorderLayout(0, 0));
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.PLAIN, 89));
		panel_1.setBackground(SystemColor.controlDkShadow);
		panel_1.setPreferredSize(new Dimension(10, 100));
		add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Client Management Screen");
		lblNewLabel_3.setForeground(SystemColor.window);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 29));
		panel_1.add(lblNewLabel_3);
		
		JSplitPane splitPane_1 = new JSplitPane();
		add(splitPane_1, BorderLayout.CENTER);
		
		JPanel searchClientPanel = new JPanel();
		searchClientPanel.setMinimumSize(new Dimension(900, 10));
		searchClientPanel.setPreferredSize(new Dimension(500, 10));
		splitPane_1.setLeftComponent(searchClientPanel);
		GridBagLayout gbl_searchClientPanel = new GridBagLayout();
		gbl_searchClientPanel.columnWidths = new int[]{170, 53, 113, 0};
		gbl_searchClientPanel.rowHeights = new int[]{16, 28, 25, 25, 25, 50, 25, 174, 0};
		gbl_searchClientPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_searchClientPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		searchClientPanel.setLayout(gbl_searchClientPanel);
		
		JLabel lblNewLabel_4 = new JLabel("Select type of search to be performed");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridwidth = 3;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		searchClientPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		ButtonGroup bg1 =new ButtonGroup();
		JRadioButton clientID = new JRadioButton("Client ID");
		GridBagConstraints gbc_clientID = new GridBagConstraints();
		gbc_clientID.anchor = GridBagConstraints.NORTH;
		gbc_clientID.fill = GridBagConstraints.HORIZONTAL;
		gbc_clientID.insets = new Insets(0, 0, 5, 0);
		gbc_clientID.gridwidth = 3;
		gbc_clientID.gridx = 0;
		gbc_clientID.gridy = 2;
		searchClientPanel.add(clientID, gbc_clientID);
		bg1.add(clientID);
		JRadioButton lName = new JRadioButton("Last Name");
		GridBagConstraints gbc_lName = new GridBagConstraints();
		gbc_lName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lName.insets = new Insets(0, 0, 5, 5);
		gbc_lName.gridx = 0;
		gbc_lName.gridy = 3;
		searchClientPanel.add(lName, gbc_lName);
		bg1.add(lName);
		JRadioButton clientType = new JRadioButton("Client Type");
		GridBagConstraints gbc_clientType = new GridBagConstraints();
		gbc_clientType.anchor = GridBagConstraints.NORTHWEST;
		gbc_clientType.insets = new Insets(0, 0, 5, 5);
		gbc_clientType.gridx = 0;
		gbc_clientType.gridy = 4;
		searchClientPanel.add(clientType, gbc_clientType);
		bg1.add(clientType);
		
		search = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 6;
		searchClientPanel.add(search, gbc_textField);
		search.setColumns(10);
		
		searchClient = new JButton("Search");
		GridBagConstraints gbc_searchClient = new GridBagConstraints();
		gbc_searchClient.anchor = GridBagConstraints.NORTH;
		gbc_searchClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchClient.insets = new Insets(0, 0, 5, 0);
		gbc_searchClient.gridx = 2;
		gbc_searchClient.gridy = 6;
		searchClientPanel.add(searchClient, gbc_searchClient);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.anchor = GridBagConstraints.SOUTH;
		gbc_scrollPane_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 7;
		searchClientPanel.add(scrollPane_1, gbc_scrollPane_1);
		
		 list = new JList();
		scrollPane_1.setViewportView(list);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		 clearSearch = new JButton("Clear Search");
		GridBagConstraints gbc_clearSearch = new GridBagConstraints();
		gbc_clearSearch.anchor = GridBagConstraints.NORTHWEST;
		gbc_clearSearch.gridx = 2;
		gbc_clearSearch.gridy = 7;
		searchClientPanel.add(clearSearch, gbc_clearSearch);
		
		JPanel clientInfoPanel = new JPanel();
		clientInfoPanel.setBackground(SystemColor.inactiveCaption);
		clientInfoPanel.setMinimumSize(new Dimension(900, 10));
		clientInfoPanel.setPreferredSize(new Dimension(500, 10));
		splitPane_1.setRightComponent(clientInfoPanel);
		GridBagLayout gbl_clientInfoPanel = new GridBagLayout();
		gbl_clientInfoPanel.columnWidths = new int[]{97, 97, 38, 274, 0};
		gbl_clientInfoPanel.rowHeights = new int[]{16, 67, 22, 22, 22, 22, 22, 22, 37, 22, 61, 25, 0};
		gbl_clientInfoPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_clientInfoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		clientInfoPanel.setLayout(gbl_clientInfoPanel);
		
		JLabel lblClientInformation = new JLabel("Client Information");
		GridBagConstraints gbc_lblClientInformation = new GridBagConstraints();
		gbc_lblClientInformation.anchor = GridBagConstraints.NORTH;
		gbc_lblClientInformation.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblClientInformation.insets = new Insets(0, 0, 5, 0);
		gbc_lblClientInformation.gridx = 3;
		gbc_lblClientInformation.gridy = 0;
		clientInfoPanel.add(lblClientInformation, gbc_lblClientInformation);
		
		JLabel lblNewLabel_5 = new JLabel("Clinet ID");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 2;
		clientInfoPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		clientIDCMS = new JTextField();
		GridBagConstraints gbc_clientIDCMS = new GridBagConstraints();
		gbc_clientIDCMS.anchor = GridBagConstraints.NORTHWEST;
		gbc_clientIDCMS.insets = new Insets(0, 0, 5, 0);
		gbc_clientIDCMS.gridwidth = 2;
		gbc_clientIDCMS.gridx = 2;
		gbc_clientIDCMS.gridy = 2;
		clientInfoPanel.add(clientIDCMS, gbc_clientIDCMS);
		clientIDCMS.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.WEST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 3;
		clientInfoPanel.add(lblFirstName, gbc_lblFirstName);
		
		fnameCMS = new JTextField();
		fnameCMS.setColumns(10);
		GridBagConstraints gbc_fnameCMS = new GridBagConstraints();
		gbc_fnameCMS.anchor = GridBagConstraints.NORTHWEST;
		gbc_fnameCMS.insets = new Insets(0, 0, 5, 0);
		gbc_fnameCMS.gridwidth = 2;
		gbc_fnameCMS.gridx = 2;
		gbc_fnameCMS.gridy = 3;
		clientInfoPanel.add(fnameCMS, gbc_fnameCMS);
		
		JLabel lblLastName_1 = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName_1 = new GridBagConstraints();
		gbc_lblLastName_1.anchor = GridBagConstraints.WEST;
		gbc_lblLastName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName_1.gridx = 1;
		gbc_lblLastName_1.gridy = 4;
		clientInfoPanel.add(lblLastName_1, gbc_lblLastName_1);
		
		lNameCMS = new JTextField();
		lNameCMS.setColumns(10);
		GridBagConstraints gbc_lNameCMS = new GridBagConstraints();
		gbc_lNameCMS.anchor = GridBagConstraints.NORTHWEST;
		gbc_lNameCMS.insets = new Insets(0, 0, 5, 0);
		gbc_lNameCMS.gridwidth = 2;
		gbc_lNameCMS.gridx = 2;
		gbc_lNameCMS.gridy = 4;
		clientInfoPanel.add(lNameCMS, gbc_lNameCMS);
		
		JLabel lblAddress_1 = new JLabel("Address");
		GridBagConstraints gbc_lblAddress_1 = new GridBagConstraints();
		gbc_lblAddress_1.anchor = GridBagConstraints.WEST;
		gbc_lblAddress_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress_1.gridx = 1;
		gbc_lblAddress_1.gridy = 5;
		clientInfoPanel.add(lblAddress_1, gbc_lblAddress_1);
		
		addressCMS = new JTextField();
		addressCMS.setColumns(10);
		GridBagConstraints gbc_addressCMS = new GridBagConstraints();
		gbc_addressCMS.anchor = GridBagConstraints.NORTHWEST;
		gbc_addressCMS.insets = new Insets(0, 0, 5, 0);
		gbc_addressCMS.gridwidth = 2;
		gbc_addressCMS.gridx = 2;
		gbc_addressCMS.gridy = 5;
		clientInfoPanel.add(addressCMS, gbc_addressCMS);
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		GridBagConstraints gbc_lblPostalCode = new GridBagConstraints();
		gbc_lblPostalCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPostalCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostalCode.gridx = 1;
		gbc_lblPostalCode.gridy = 6;
		clientInfoPanel.add(lblPostalCode, gbc_lblPostalCode);
		
		postalCodeCMS = new JTextField();
		postalCodeCMS.setColumns(10);
		GridBagConstraints gbc_postalCodeCMS = new GridBagConstraints();
		gbc_postalCodeCMS.anchor = GridBagConstraints.NORTHWEST;
		gbc_postalCodeCMS.insets = new Insets(0, 0, 5, 0);
		gbc_postalCodeCMS.gridwidth = 2;
		gbc_postalCodeCMS.gridx = 2;
		gbc_postalCodeCMS.gridy = 6;
		clientInfoPanel.add(postalCodeCMS, gbc_postalCodeCMS);
		
		JLabel lblPhoneNumber_1 = new JLabel("Phone Number");
		GridBagConstraints gbc_lblPhoneNumber_1 = new GridBagConstraints();
		gbc_lblPhoneNumber_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPhoneNumber_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber_1.gridx = 1;
		gbc_lblPhoneNumber_1.gridy = 7;
		clientInfoPanel.add(lblPhoneNumber_1, gbc_lblPhoneNumber_1);
		
		phoneCMS = new JTextField();
		phoneCMS.setColumns(10);
		GridBagConstraints gbc_phoneCMS = new GridBagConstraints();
		gbc_phoneCMS.anchor = GridBagConstraints.NORTHWEST;
		gbc_phoneCMS.insets = new Insets(0, 0, 5, 0);
		gbc_phoneCMS.gridwidth = 2;
		gbc_phoneCMS.gridx = 2;
		gbc_phoneCMS.gridy = 7;
		clientInfoPanel.add(phoneCMS, gbc_phoneCMS);
		
		JLabel lblClientType = new JLabel("Client Type");
		GridBagConstraints gbc_lblClientType = new GridBagConstraints();
		gbc_lblClientType.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblClientType.insets = new Insets(0, 0, 5, 5);
		gbc_lblClientType.gridx = 1;
		gbc_lblClientType.gridy = 9;
		clientInfoPanel.add(lblClientType, gbc_lblClientType);
		
		comboBoxClientMgmnt = new JComboBox();
		comboBoxClientMgmnt.setModel(new DefaultComboBoxModel(new String[] {"R", "C"}));
		GridBagConstraints gbc_comboBoxClientMgmnt = new GridBagConstraints();
		gbc_comboBoxClientMgmnt.anchor = GridBagConstraints.NORTHEAST;
		gbc_comboBoxClientMgmnt.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxClientMgmnt.gridx = 2;
		gbc_comboBoxClientMgmnt.gridy = 9;
		clientInfoPanel.add(comboBoxClientMgmnt, gbc_comboBoxClientMgmnt);
		
		 saveBtn = new JButton("Save");
		GridBagConstraints gbc_saveBtn = new GridBagConstraints();
		gbc_saveBtn.anchor = GridBagConstraints.NORTHEAST;
		gbc_saveBtn.insets = new Insets(0, 0, 0, 5);
		gbc_saveBtn.gridx = 0;
		gbc_saveBtn.gridy = 11;
		clientInfoPanel.add(saveBtn, gbc_saveBtn);
		
		 deleteBtn = new JButton("Delete");
		GridBagConstraints gbc_deleteBtn = new GridBagConstraints();
		gbc_deleteBtn.anchor = GridBagConstraints.NORTH;
		gbc_deleteBtn.insets = new Insets(0, 0, 0, 5);
		gbc_deleteBtn.gridwidth = 2;
		gbc_deleteBtn.gridx = 1;
		gbc_deleteBtn.gridy = 11;
		clientInfoPanel.add(deleteBtn, gbc_deleteBtn);
		
		 clearBtn = new JButton("Clear");
		GridBagConstraints gbc_clearBtn = new GridBagConstraints();
		gbc_clearBtn.anchor = GridBagConstraints.NORTHWEST;
		gbc_clearBtn.gridx = 3;
		gbc_clearBtn.gridy = 11;
		clientInfoPanel.add(clearBtn, gbc_clearBtn);
	}
	public void populateList(String json) {
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"hello", "is", "me"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchClient) {
			if (option ==1) {
				//using ID
				search.getText();
				populateList(mc.request("BBB"));
			}
			else if (option==2) {
				//lname
				populateList(mc.request("BBB"));
			}
			else if (option==3) {
				//type
			}
			else {
				JOptionPane.showMessageDialog(null, "Select a option");
			}
		}
		else if (e.getSource()==saveBtn) {
			//TODO algo to make changes// mus check if id exsist
		}
		else if (e.getSource()==deleteBtn) {
			//TODO algo to delete 
		}
		else if (e.getSource()==clearBtn) {
			//TOFO clear all fields
		}
	}

}
