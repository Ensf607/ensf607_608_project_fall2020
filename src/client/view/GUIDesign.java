package client.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.Box;
import javax.swing.ButtonGroup;

import java.awt.Insets;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIDesign {

	private JFrame frame;
	private JTextField toolIDField;
	private JTable table;
	private JTextField qtyField;
	private JTextField toolIDPurchase;
	private JTextField toolNamePurchase;
	private JTextField toolType;
	private JTextField toolPrice;
	private JTextField clientIDPurchase;
	private JTextField fNameClient;
	private JTextField fNameNew;
	private JTextField lNameNew;
	private JTextField addressNew;
	private JTextField postalCodeNew;
	private JTextField phoneNew;
	private JTextField textField;
	private JTextField clientIDCMS;
	private JTextField fnameCMS;
	private JTextField lNameCMS;
	private JTextField addressCMS;
	private JTextField postalCodeCMS;
	private JTextField phoneCMS;
	private JTextField totalField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIDesign window = new GUIDesign();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIDesign() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1362, 692);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu inventory = new JMenu("Inventory GUI");
		inventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==inventory)
				System.err.println("HH");
			}
			
		});
		menuBar.add(inventory);
		
		JMenu clientGuiMenu = new JMenu("Client GUI");
		menuBar.add(clientGuiMenu);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel inventoryPanel = new JPanel();
		inventoryPanel.setBackground(SystemColor.inactiveCaption);
		panel.add(inventoryPanel, "name_2038975145240200");
		inventoryPanel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDoubleBuffered(true);
		splitPane.setMaximumSize(new Dimension(2147483647, 100));
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		inventoryPanel.add(splitPane);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(SystemColor.menu);
		headerPanel.setAutoscrolls(true);
		headerPanel.setMaximumSize(new Dimension(32767, 60));
		headerPanel.setMinimumSize(new Dimension(30, 400));
		splitPane.setLeftComponent(headerPanel);
		headerPanel.setLayout(null);
		
		toolIDField = new JTextField();
		toolIDField.setBounds(168, 10, 116, 22);
		headerPanel.add(toolIDField);
		toolIDField.setColumns(10);
		
		JButton search = new JButton("Search");
		search.setBounds(178, 40, 97, 25);
		headerPanel.add(search);
		
		JButton listTools = new JButton("List All Tools");
		listTools.setBounds(548, 61, 134, 25);
		headerPanel.add(listTools);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Search by ToolID", "Search by ToolName"}));
		comboBox_1.setBounds(31, 10, 125, 22);
		headerPanel.add(comboBox_1);
		
		JPanel displayPanel = new JPanel();
		displayPanel.setBackground(SystemColor.scrollbar);
		displayPanel.setMinimumSize(new Dimension(10, 600));
		splitPane.setRightComponent(displayPanel);
		displayPanel.setLayout(new CardLayout(0, 0));
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(SystemColor.inactiveCaption);
		displayPanel.add(tablePanel, "name_2040111206647000");
		tablePanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		tablePanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBackground(SystemColor.text);
		scrollPane.setViewportView(table);
		
		JPanel purchasePanel = new JPanel();
		purchasePanel.setBackground(SystemColor.inactiveCaption);
		displayPanel.add(purchasePanel, "name_2040121098680100");
		GridBagLayout gbl_purchasePanel = new GridBagLayout();
		gbl_purchasePanel.columnWidths = new int[]{76, 56, 116, 0};
		gbl_purchasePanel.rowHeights = new int[]{29, 16, 22, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_purchasePanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_purchasePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		purchasePanel.setLayout(gbl_purchasePanel);
		
		JLabel lblNewLabel_1 = new JLabel("Tool Info");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		purchasePanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("ToolID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		purchasePanel.add(lblNewLabel, gbc_lblNewLabel);
		
		toolIDPurchase = new JTextField();
		toolIDPurchase.setEditable(false);
		toolIDPurchase.setColumns(10);
		GridBagConstraints gbc_toolIDPurchase = new GridBagConstraints();
		gbc_toolIDPurchase.anchor = GridBagConstraints.WEST;
		gbc_toolIDPurchase.insets = new Insets(0, 0, 5, 5);
		gbc_toolIDPurchase.gridx = 1;
		gbc_toolIDPurchase.gridy = 1;
		purchasePanel.add(toolIDPurchase, gbc_toolIDPurchase);
		
		JLabel lblToolName = new JLabel("Tool Name");
		GridBagConstraints gbc_lblToolName = new GridBagConstraints();
		gbc_lblToolName.anchor = GridBagConstraints.EAST;
		gbc_lblToolName.insets = new Insets(0, 0, 5, 5);
		gbc_lblToolName.gridx = 0;
		gbc_lblToolName.gridy = 2;
		purchasePanel.add(lblToolName, gbc_lblToolName);
		
		toolNamePurchase = new JTextField();
		toolNamePurchase.setEditable(false);
		toolNamePurchase.setColumns(10);
		GridBagConstraints gbc_toolNamePurchase = new GridBagConstraints();
		gbc_toolNamePurchase.anchor = GridBagConstraints.WEST;
		gbc_toolNamePurchase.insets = new Insets(0, 0, 5, 5);
		gbc_toolNamePurchase.gridx = 1;
		gbc_toolNamePurchase.gridy = 2;
		purchasePanel.add(toolNamePurchase, gbc_toolNamePurchase);
		
		JLabel lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 3;
		purchasePanel.add(lblType, gbc_lblType);
		
		toolType = new JTextField();
		toolType.setEditable(false);
		toolType.setColumns(10);
		GridBagConstraints gbc_toolType = new GridBagConstraints();
		gbc_toolType.anchor = GridBagConstraints.WEST;
		gbc_toolType.insets = new Insets(0, 0, 5, 5);
		gbc_toolType.gridx = 1;
		gbc_toolType.gridy = 3;
		purchasePanel.add(toolType, gbc_toolType);
		
		JLabel lblPrice = new JLabel("Price");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 4;
		purchasePanel.add(lblPrice, gbc_lblPrice);
		
		toolPrice = new JTextField();
		toolPrice.setEditable(false);
		toolPrice.setColumns(10);
		GridBagConstraints gbc_toolPrice = new GridBagConstraints();
		gbc_toolPrice.anchor = GridBagConstraints.WEST;
		gbc_toolPrice.insets = new Insets(0, 0, 5, 5);
		gbc_toolPrice.gridx = 1;
		gbc_toolPrice.gridy = 4;
		purchasePanel.add(toolPrice, gbc_toolPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
		gbc_lblQuantity.anchor = GridBagConstraints.EAST;
		gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity.gridx = 0;
		gbc_lblQuantity.gridy = 5;
		purchasePanel.add(lblQuantity, gbc_lblQuantity);
		
		qtyField = new JTextField();
		qtyField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
			}
		});
		qtyField.setEditable(false);
		GridBagConstraints gbc_qtyField = new GridBagConstraints();
		gbc_qtyField.anchor = GridBagConstraints.NORTHWEST;
		gbc_qtyField.insets = new Insets(0, 0, 5, 5);
		gbc_qtyField.gridx = 1;
		gbc_qtyField.gridy = 5;
		purchasePanel.add(qtyField, gbc_qtyField);
		qtyField.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 6;
		purchasePanel.add(lblTotal, gbc_lblTotal);
		
		totalField = new JTextField();
		totalField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
			}
		});
		totalField.setEditable(false);
		totalField.setColumns(10);
		GridBagConstraints gbc_totalField = new GridBagConstraints();
		gbc_totalField.anchor = GridBagConstraints.WEST;
		gbc_totalField.insets = new Insets(0, 0, 5, 5);
		gbc_totalField.gridx = 1;
		gbc_totalField.gridy = 6;
		purchasePanel.add(totalField, gbc_totalField);
		
		JLabel lblCustomerInfo = new JLabel("Customer Info");
		GridBagConstraints gbc_lblCustomerInfo = new GridBagConstraints();
		gbc_lblCustomerInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerInfo.gridx = 1;
		gbc_lblCustomerInfo.gridy = 7;
		purchasePanel.add(lblCustomerInfo, gbc_lblCustomerInfo);
		
		JButton newClientBtn = new JButton("New Customer");
		GridBagConstraints gbc_newClientBtn = new GridBagConstraints();
		gbc_newClientBtn.insets = new Insets(0, 0, 5, 0);
		gbc_newClientBtn.gridx = 2;
		gbc_newClientBtn.gridy = 7;
		purchasePanel.add(newClientBtn, gbc_newClientBtn);
		
		JLabel labelID = new JLabel("ClientID");
		GridBagConstraints gbc_labelID = new GridBagConstraints();
		gbc_labelID.anchor = GridBagConstraints.EAST;
		gbc_labelID.insets = new Insets(0, 0, 5, 5);
		gbc_labelID.gridx = 0;
		gbc_labelID.gridy = 8;
		purchasePanel.add(labelID, gbc_labelID);
		
		clientIDPurchase = new JTextField();
		clientIDPurchase.setEditable(false);
		clientIDPurchase.setColumns(10);
		GridBagConstraints gbc_clientIDPurchase = new GridBagConstraints();
		gbc_clientIDPurchase.anchor = GridBagConstraints.WEST;
		gbc_clientIDPurchase.insets = new Insets(0, 0, 5, 5);
		gbc_clientIDPurchase.gridx = 1;
		gbc_clientIDPurchase.gridy = 8;
		purchasePanel.add(clientIDPurchase, gbc_clientIDPurchase);
		
		JLabel label = new JLabel("First Name");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 9;
		purchasePanel.add(label, gbc_label);
		
		fNameClient = new JTextField();
		fNameClient.setEditable(false);
		fNameClient.setColumns(10);
		GridBagConstraints gbc_fNameClient = new GridBagConstraints();
		gbc_fNameClient.anchor = GridBagConstraints.WEST;
		gbc_fNameClient.insets = new Insets(0, 0, 5, 5);
		gbc_fNameClient.gridx = 1;
		gbc_fNameClient.gridy = 9;
		purchasePanel.add(fNameClient, gbc_fNameClient);
		
		JButton purchaseBtn = new JButton("Purchase");
		GridBagConstraints gbc_purchaseBtn = new GridBagConstraints();
		gbc_purchaseBtn.insets = new Insets(0, 0, 0, 5);
		gbc_purchaseBtn.gridx = 1;
		gbc_purchaseBtn.gridy = 11;
		purchasePanel.add(purchaseBtn, gbc_purchaseBtn);
		
		JPanel newCustomerPanel = new JPanel();
		newCustomerPanel.setBackground(SystemColor.inactiveCaption);
		displayPanel.add(newCustomerPanel, "name_2041480659170000");
		GridBagLayout gbl_newCustomerPanel = new GridBagLayout();
		gbl_newCustomerPanel.columnWidths = new int[]{32, 77, 18, 23, 46, 97, 0};
		gbl_newCustomerPanel.rowHeights = new int[]{22, 22, 22, 22, 22, 22, 47, 25, 0};
		gbl_newCustomerPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_newCustomerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		newCustomerPanel.setLayout(gbl_newCustomerPanel);
		
		JLabel lblNewLabel_2 = new JLabel("First Name");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		newCustomerPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		fNameNew = new JTextField();
		GridBagConstraints gbc_fNameNew = new GridBagConstraints();
		gbc_fNameNew.anchor = GridBagConstraints.NORTHWEST;
		gbc_fNameNew.insets = new Insets(0, 0, 5, 0);
		gbc_fNameNew.gridwidth = 4;
		gbc_fNameNew.gridx = 2;
		gbc_fNameNew.gridy = 0;
		newCustomerPanel.add(fNameNew, gbc_fNameNew);
		fNameNew.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 1;
		gbc_lblLastName.gridy = 1;
		newCustomerPanel.add(lblLastName, gbc_lblLastName);
		
		lNameNew = new JTextField();
		lNameNew.setColumns(10);
		GridBagConstraints gbc_lNameNew = new GridBagConstraints();
		gbc_lNameNew.anchor = GridBagConstraints.NORTHWEST;
		gbc_lNameNew.insets = new Insets(0, 0, 5, 0);
		gbc_lNameNew.gridwidth = 4;
		gbc_lNameNew.gridx = 2;
		gbc_lNameNew.gridy = 1;
		newCustomerPanel.add(lNameNew, gbc_lNameNew);
		
		JLabel lblType_1 = new JLabel("Type");
		GridBagConstraints gbc_lblType_1 = new GridBagConstraints();
		gbc_lblType_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblType_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblType_1.gridx = 1;
		gbc_lblType_1.gridy = 2;
		newCustomerPanel.add(lblType_1, gbc_lblType_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"R", "C"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTHEAST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		newCustomerPanel.add(comboBox, gbc_comboBox);
		
		JLabel lblAddress = new JLabel("Address");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 3;
		newCustomerPanel.add(lblAddress, gbc_lblAddress);
		
		addressNew = new JTextField();
		addressNew.setColumns(10);
		GridBagConstraints gbc_addressNew = new GridBagConstraints();
		gbc_addressNew.anchor = GridBagConstraints.NORTHWEST;
		gbc_addressNew.insets = new Insets(0, 0, 5, 0);
		gbc_addressNew.gridwidth = 4;
		gbc_addressNew.gridx = 2;
		gbc_addressNew.gridy = 3;
		newCustomerPanel.add(addressNew, gbc_addressNew);
		
		JLabel Postal = new JLabel("Postal Code");
		GridBagConstraints gbc_Postal = new GridBagConstraints();
		gbc_Postal.fill = GridBagConstraints.HORIZONTAL;
		gbc_Postal.insets = new Insets(0, 0, 5, 5);
		gbc_Postal.gridx = 1;
		gbc_Postal.gridy = 4;
		newCustomerPanel.add(Postal, gbc_Postal);
		
		postalCodeNew = new JTextField();
		postalCodeNew.setColumns(10);
		GridBagConstraints gbc_postalCodeNew = new GridBagConstraints();
		gbc_postalCodeNew.anchor = GridBagConstraints.NORTHWEST;
		gbc_postalCodeNew.insets = new Insets(0, 0, 5, 0);
		gbc_postalCodeNew.gridwidth = 4;
		gbc_postalCodeNew.gridx = 2;
		gbc_postalCodeNew.gridy = 4;
		newCustomerPanel.add(postalCodeNew, gbc_postalCodeNew);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridx = 1;
		gbc_lblPhoneNumber.gridy = 5;
		newCustomerPanel.add(lblPhoneNumber, gbc_lblPhoneNumber);
		
		phoneNew = new JTextField();
		phoneNew.setColumns(10);
		GridBagConstraints gbc_phoneNew = new GridBagConstraints();
		gbc_phoneNew.anchor = GridBagConstraints.NORTHWEST;
		gbc_phoneNew.insets = new Insets(0, 0, 5, 5);
		gbc_phoneNew.gridwidth = 3;
		gbc_phoneNew.gridx = 2;
		gbc_phoneNew.gridy = 5;
		newCustomerPanel.add(phoneNew, gbc_phoneNew);
		
		JButton createClient = new JButton("SignUp");
		GridBagConstraints gbc_createClient = new GridBagConstraints();
		gbc_createClient.insets = new Insets(0, 0, 5, 0);
		gbc_createClient.anchor = GridBagConstraints.NORTH;
		gbc_createClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_createClient.gridx = 5;
		gbc_createClient.gridy = 6;
		newCustomerPanel.add(createClient, gbc_createClient);
		splitPane.setDividerLocation(100);
		
		JPanel clientMgmntPanel = new JPanel();
		panel.add(clientMgmntPanel, "name_2039044715175000");
		clientMgmntPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.PLAIN, 89));
		panel_1.setBackground(SystemColor.controlDkShadow);
		panel_1.setPreferredSize(new Dimension(10, 100));
		clientMgmntPanel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Client Management Screen");
		lblNewLabel_3.setForeground(SystemColor.window);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 29));
		panel_1.add(lblNewLabel_3);
		
		JSplitPane splitPane_1 = new JSplitPane();
		clientMgmntPanel.add(splitPane_1, BorderLayout.CENTER);
		
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
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 6;
		searchClientPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton searchClient = new JButton("Search");
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
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"hello", "is", "me"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton clearSearch = new JButton("Clear Search");
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
		
		JComboBox comboBoxClientMgmnt = new JComboBox();
		comboBoxClientMgmnt.setModel(new DefaultComboBoxModel(new String[] {"R", "C"}));
		GridBagConstraints gbc_comboBoxClientMgmnt = new GridBagConstraints();
		gbc_comboBoxClientMgmnt.anchor = GridBagConstraints.NORTHEAST;
		gbc_comboBoxClientMgmnt.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxClientMgmnt.gridx = 2;
		gbc_comboBoxClientMgmnt.gridy = 9;
		clientInfoPanel.add(comboBoxClientMgmnt, gbc_comboBoxClientMgmnt);
		
		JButton saveBtn = new JButton("Save");
		GridBagConstraints gbc_saveBtn = new GridBagConstraints();
		gbc_saveBtn.anchor = GridBagConstraints.NORTHEAST;
		gbc_saveBtn.insets = new Insets(0, 0, 0, 5);
		gbc_saveBtn.gridx = 0;
		gbc_saveBtn.gridy = 11;
		clientInfoPanel.add(saveBtn, gbc_saveBtn);
		
		JButton deleteBtn = new JButton("Delete");
		GridBagConstraints gbc_deleteBtn = new GridBagConstraints();
		gbc_deleteBtn.anchor = GridBagConstraints.NORTH;
		gbc_deleteBtn.insets = new Insets(0, 0, 0, 5);
		gbc_deleteBtn.gridwidth = 2;
		gbc_deleteBtn.gridx = 1;
		gbc_deleteBtn.gridy = 11;
		clientInfoPanel.add(deleteBtn, gbc_deleteBtn);
		
		JButton clearBtn = new JButton("Clear");
		GridBagConstraints gbc_clearBtn = new GridBagConstraints();
		gbc_clearBtn.anchor = GridBagConstraints.NORTHWEST;
		gbc_clearBtn.gridx = 3;
		gbc_clearBtn.gridy = 11;
		clientInfoPanel.add(clearBtn, gbc_clearBtn);
	}
}
