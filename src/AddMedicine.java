import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class AddMedicine extends JFrame {

	private JPanel contentPane;
	private JTextField medname_textField;
	private JTextField medtype_textField;
	private JTextField medprice_textField;
	private JTextField medexp_textField;
	private JTextField medpur_textField;
	private JTextField medavail_textField;
	private JTextField meddesc_textField;
	JLabel lblM ;
	String id;
	AddMedicine am;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMedicine frame = new AddMedicine("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public AddMedicine(String s) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddMedicine.class.getResource("/images/addic.png")));
		setResizable(false);
		setTitle("Medicine Form");
		id=s;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 46, 83));
		panel.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		panel.setBounds(20, 49, 502, 316);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[][][][][][grow][][]", "[][grow][][][][][][][][][][][]"));
		
		JLabel lblMedicineId = new JLabel("Medicine Id:");
		lblMedicineId.setForeground(new Color(0, 255, 204));
		lblMedicineId.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblMedicineId.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMedicineId, "cell 1 0");
		
		 lblM = new JLabel("m10002");
		 lblM.setForeground(Color.LIGHT_GRAY);
		 lblM.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		 
		panel.add(lblM, "cell 3 0 2 1");
		
		JLabel lblMedicineName = new JLabel("Medicine Name:");
		lblMedicineName.setForeground(Color.WHITE);
		lblMedicineName.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		panel.add(lblMedicineName, "cell 1 2,alignx trailing");
		
		medname_textField = new JTextField();
		medname_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		medname_textField.setBackground(new Color(240, 248, 255));
		panel.add(medname_textField, "cell 3 2 3 1,growx");
		medname_textField.setColumns(10);
		
		JLabel lblMedicineType = new JLabel("Medicine Type:");
		lblMedicineType.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblMedicineType.setForeground(Color.WHITE);
		panel.add(lblMedicineType, "cell 1 3,alignx trailing");
		
		medtype_textField = new JTextField();
		medtype_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		medtype_textField.setBackground(new Color(240, 248, 255));
		panel.add(medtype_textField, "cell 3 3 3 1,growx");
		medtype_textField.setColumns(10);
		
		JLabel lblMedicinePrice = new JLabel("Medicine Price:");
		lblMedicinePrice.setForeground(Color.WHITE);
		lblMedicinePrice.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		panel.add(lblMedicinePrice, "cell 1 4,alignx trailing");
		
		medprice_textField = new JTextField();
		medprice_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		medprice_textField.setBackground(new Color(240, 248, 255));
		panel.add(medprice_textField, "cell 3 4 3 1,growx");
		medprice_textField.setColumns(10);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date:");
		lblExpiryDate.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblExpiryDate.setForeground(Color.WHITE);
		panel.add(lblExpiryDate, "cell 1 5,alignx trailing");
		
		medexp_textField = new JTextField();
		medexp_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		medexp_textField.setBackground(new Color(240, 248, 255));
		medexp_textField.setText("dd-MM-yyyy");
		panel.add(medexp_textField, "cell 3 5 3 1,growx");
		medexp_textField.setColumns(10);
		
		JLabel lblPurchasedNumber = new JLabel("Purchased Number:");
		lblPurchasedNumber.setForeground(Color.WHITE);
		lblPurchasedNumber.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		panel.add(lblPurchasedNumber, "cell 1 6,alignx trailing");
		
		medpur_textField = new JTextField();
		medpur_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		medpur_textField.setBackground(new Color(240, 248, 255));
		panel.add(medpur_textField, "cell 3 6 3 1,growx");
		medpur_textField.setColumns(10);
		
		JLabel lblAvailableNumber = new JLabel("Available Number:");
		lblAvailableNumber.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblAvailableNumber.setForeground(Color.WHITE);
		panel.add(lblAvailableNumber, "cell 1 7,alignx trailing");
		
		medavail_textField = new JTextField();
		medavail_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		medavail_textField.setBackground(new Color(240, 248, 255));
		panel.add(medavail_textField, "cell 3 7 3 1,growx");
		medavail_textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		panel.add(lblDescription, "cell 1 8,alignx trailing");
		
		meddesc_textField = new JTextField();
		meddesc_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		meddesc_textField.setBackground(new Color(240, 248, 255));
		panel.add(meddesc_textField, "cell 3 8 3 1,growx");
		meddesc_textField.setColumns(10);
		
		JButton confirmBtn = new JButton("ADD");
		confirmBtn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		confirmBtn.setBackground(new Color(0, 102, 255));
		confirmBtn.setForeground(Color.WHITE);
		if(s!=null){
		if(!s.isEmpty()) confirmBtn.setText("UPDATE");}
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(confirmBtn.getText().equals("ADD")){
					
					if(medname_textField.getText().isEmpty() || medtype_textField.getText().isEmpty() || medprice_textField.getText().isEmpty() || 
							medexp_textField.getText().isEmpty() || medavail_textField.getText().isEmpty() || meddesc_textField.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Please fill all the fields");
					}
					else 
						insertMedicine();
				}
				else if(confirmBtn.getText().equals("UPDATE")){
					if(medname_textField.getText().isEmpty() || medtype_textField.getText().isEmpty() || medprice_textField.getText().isEmpty() || 
							medexp_textField.getText().isEmpty() || medavail_textField.getText().isEmpty() || meddesc_textField.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Please fill all the fields");
					}
					else
						updateMedicine(lblM.getText());
				}
			}
		});
		
		panel.add(confirmBtn, "cell 2 11 3 1");
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddMedicine.class.getResource("/images/loginbg.png")));
		label.setBounds(0, 0, 546, 384);
		contentPane.add(label);

	}
	
	
	protected void updateMedicine(String id) {
		
		String med_id,med_name,med_type,med_expiry,med_desc,med_stock="yes";
		float med_price;
		int med_avail,med_pur;java.sql.Date med_expdate;
		
		try{
		med_id=id;
		med_name=medname_textField.getText();
		med_type=medtype_textField.getText();
		med_price=Float.parseFloat(medprice_textField.getText());
		med_expiry=medexp_textField.getText();
		med_avail=Integer.parseInt(medavail_textField.getText());
		med_pur=Integer.parseInt(medpur_textField.getText());
		med_desc=meddesc_textField.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date sd;
		try {
			sd = sdf.parse(med_expiry);
			med_expdate = new java.sql.Date(sd.getTime());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "invalid date or date is in not proper format");
			e.printStackTrace();
			return;
		}
		
		if(med_avail>med_pur){JOptionPane.showMessageDialog(null, "Available Quantity can not be greater than purchased quantity");return;}

			String query="update medicines_stock set m_id='"+med_id+"' , mname='"+med_name+"' , mtype='"+med_type+"' , mprice="
					+med_price+" , mexpiry_date=TO_DATE('"+med_expdate+"' , 'YYYY-MM-DD') , maval_quantity="+med_avail+" ,mpurchase_quantity="+med_pur+" ,mdescription='"
					+med_desc+"' , available='yes' where m_id='"+med_id+"'";
		ConnectionToDB ctb = new ConnectionToDB();
		ctb.makeConnection();
		int i = ctb.queryUpdation(query);
		if(i==1) {JOptionPane.showMessageDialog(null, "Updated Successfully");}
		else 
			{JOptionPane.showMessageDialog(null, "Error Updating");}
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Invalid Types entered");
		}
		
		dispose();
		
	}




	


	public void insertMedicine(){
		
		String med_id,med_name,med_type,med_expiry,med_desc,med_stock="yes";
		float med_price;
		int med_avail,med_pur;java.sql.Date med_expdate;
		med_id=lblM.getText();
		try{
		med_name=medname_textField.getText();
		med_type=medtype_textField.getText();
		
		med_price=Float.parseFloat(medprice_textField.getText());
		med_expiry=medexp_textField.getText();
		med_avail=Integer.parseInt(medavail_textField.getText());
		med_pur=Integer.parseInt(medpur_textField.getText());
		med_desc=meddesc_textField.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date sd;
		try {
			sd = sdf.parse(med_expiry);
			med_expdate = new java.sql.Date(sd.getTime());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "invalid date or date is in not proper format");
			e.printStackTrace();
			return;
		}
		if(med_avail>med_pur){JOptionPane.showMessageDialog(null, "Available Quantity can not be greater than purchased quantity");return;}
		ConnectionToDB ctb = new ConnectionToDB();
		ctb.makeConnection();/**INSERTING TO MEDICINE DATABASE---------change date from string to sql date**/
		int res =ctb.insertToMedicinesStock(med_id, med_name, med_type, med_price, med_expdate, med_avail, med_pur, med_desc, med_stock);
	
		if(res==1) 
			JOptionPane.showMessageDialog(null, "Added Succefully");
		else 
			JOptionPane.showMessageDialog(null, "Problem While Adding");
		
		ctb.closeConnection();
}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Invalid Types entered");
		}
		
		dispose();
	}
	
	
	public void formMedicine(String s){
		if(!s.isEmpty()){
			
			ConnectionToDB ctb = new ConnectionToDB();
			ctb.makeConnection();
			ResultSet rs = ctb.queryExecution("Select * from medicines_stock where m_id='"+s+"'");
			try {
				rs.next();
				medname_textField.setText(rs.getString(2));
				medtype_textField.setText(rs.getString(3));
				medprice_textField.setText(rs.getFloat(4)+"");
				String date;
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				date = sdf.format(rs.getDate(5));
				medexp_textField.setText(date);
				medavail_textField.setText(rs.getInt(6)+"");
				medpur_textField.setText(rs.getInt(7)+"");
				meddesc_textField.setText(rs.getString(8));
				
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Medicine with given id is not present in the stock");
				dispose();
				e.printStackTrace();
			}
		}
	}






	public void deleteMedicine(String s) {
		ConnectionToDB ctb = new ConnectionToDB();
		ctb.makeConnection();
		int i = ctb.queryUpdation("delete from medicines_stock where m_id='"+s+"'");
		if(i==1){
			JOptionPane.showMessageDialog(null, "DELETED SUCCESSFULLY");
		}
		else{
			JOptionPane.showMessageDialog(null, "ERROR WHILE DELETING");

		}
		ctb.closeConnection();
	}






	public void showExpiredMedicines() {
		java.util.Date d = java.util.Calendar.getInstance().getTime();
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		String date = sd.format(d);
		String query = "select * from medicines_stock where mexpiry_date<'"+date+"'";
		ConnectionToDB ctb = new ConnectionToDB();
		ctb.makeConnection();
		ResultSet rs = ctb.queryExecution(query);
		ExpiredMedicines em = new ExpiredMedicines();
		em.setVisible(true);
		em.setTable(rs);
		ctb.closeConnection();
	}






	public void showStock() {
		String query = "select m_id,mname,maval_quantity from medicines_stock order by MAVAL_QUANTITY " ;
		ConnectionToDB ctb = new ConnectionToDB();
		ctb.makeConnection();
		ResultSet rs = ctb.queryExecution(query);
		Stock st = new Stock();
		st.setVisible(true);
		st.setTable(rs);
		ctb.closeConnection();
	}






	public void showTotalPurchase() {
		String query1 = "select sum(mpurchase_quantity) from medicines_stock" ;
		String query2 = "select sum(mpurchase_quantity*mprice) from medicines_stock";
		int puchase_qty=0;
		double puchase_price=0.0;
		ConnectionToDB ctb = new ConnectionToDB();
		ctb.makeConnection();
		ResultSet rs1 = ctb.queryExecution(query1);
		try {
			
			if(rs1.next()){
				puchase_qty=rs1.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		ctb.closeConnection();
		
		ConnectionToDB ctbc = new ConnectionToDB();
		ctbc.makeConnection();
		ResultSet rs2 = ctbc.queryExecution(query2);
		try {
			if(rs2.next()){
				puchase_price=rs2.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ctbc.closeConnection();
		TotalPurchase tp = new TotalPurchase();
		tp.setVisible(true);
		tp.setValue(puchase_price,puchase_qty);
		
	}






	public void showTotalSales() {
		String query1 = "select sum(MAVAL_QUANTITY) from medicines_stock" ;
		String query2 = "select sum(MAVAL_QUANTITY*MPRICE) from medicines_stock";
		String query3 = "select sum(MPURCHASE_QUANTITY)-sum(MAVAL_QUANTITY) from medicines_stock";
		String query4 = "select count(*) from medicines_stock";
		int aval_qty=0;
		double sold_price=0.0;
		int sold_med=0;
		int aval_tot=0;
		
		ConnectionToDB ctb = new ConnectionToDB();
		ctb.makeConnection();
		ResultSet rs1 = ctb.queryExecution(query1);
		try {
			
			if(rs1.next()){
				aval_qty=rs1.getInt(1);
			}
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		ctb.closeConnection();
		
		
		ConnectionToDB ctb1 = new ConnectionToDB();
		ctb1.makeConnection();
		ResultSet rs2 = ctb1.queryExecution(query2);
		try{
			if(rs2.next()){
				sold_price=rs2.getFloat(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}ctb1.closeConnection();
		
		ConnectionToDB ctb2 = new ConnectionToDB();
		ctb2.makeConnection();
		ResultSet rs3 = ctb2.queryExecution(query3);
		try{
			if(rs3.next()){
				sold_med= rs3.getInt(1);
			}	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ctb2.closeConnection();
		
		
		ConnectionToDB ctb3 = new ConnectionToDB();
		ctb3.makeConnection();
		ResultSet rs4 = ctb3.queryExecution(query4);
		try {
			
			if(rs4.next()){
				aval_tot=rs4.getInt(1);
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
		ctb3.closeConnection();
		TotalSales tp = new TotalSales();
		tp.setVisible(true);
		tp.setValue(sold_med,aval_qty,sold_price,aval_tot);
		
	}
	public void setAddMedicineReference(AddMedicine u){
		am=u;
	}
}
