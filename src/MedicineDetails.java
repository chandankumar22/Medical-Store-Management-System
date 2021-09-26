import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class MedicineDetails extends JFrame {

	private JPanel contentPane;
	MedicineDetails md;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicineDetails frame = new MedicineDetails("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	*/
	
	double price;String medname;
	JLabel mname_label;
	JLabel lblMtype;
	JLabel lblMprice;
	JLabel lblMexpdate;
	JLabel lblMdesc;
	JLabel lblMstock; String med_id,u_id;
 private JLabel lblNewLabel_1;
	/**
	 * Create the frame.
	 */
	public MedicineDetails(String s) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MedicineDetails.class.getResource("/images/detailic.png")));
		setResizable(false);
		setTitle("Medicine Details");
		System.out.println(s+"             first line id");
		med_id=s;
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 481, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 38, 321, 308);
		panel.setBackground(new Color(1,46,83));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblA = new JLabel("a");
		lblA.setIcon(new ImageIcon(MedicineDetails.class.getResource("/images/loginbg.png")));
		lblA.setBounds(0, 0, 475, 369);
		contentPane.add(lblA);
		
		JLabel lblMedicineName = new JLabel("Medicine Name:");
		lblMedicineName.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblMedicineName.setForeground(Color.LIGHT_GRAY);
		lblMedicineName.setBounds(19, 38, 136, 27);
		panel.add(lblMedicineName);
		
		JLabel lblNewLabel = new JLabel("Type:");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblNewLabel.setBounds(19, 76, 136, 25);
		panel.add(lblNewLabel);
		
		JLabel lblPriceperTabletml = new JLabel("Price(per tab/ml):");
		lblPriceperTabletml.setForeground(Color.LIGHT_GRAY);
		lblPriceperTabletml.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblPriceperTabletml.setBounds(19, 112, 151, 28);
		panel.add(lblPriceperTabletml);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date:");
		lblExpiryDate.setForeground(Color.LIGHT_GRAY);
		lblExpiryDate.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblExpiryDate.setBounds(19, 148, 136, 28);
		panel.add(lblExpiryDate);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setForeground(Color.LIGHT_GRAY);
		lblDescription.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblDescription.setBounds(19, 187, 136, 28);
		panel.add(lblDescription);
		
		JLabel lblStock = new JLabel("Stock Available:");
		lblStock.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblStock.setForeground(Color.LIGHT_GRAY);
		lblStock.setBounds(19, 226, 136, 27);
		panel.add(lblStock);
		
		JButton btnBuy = new JButton("BUY");
		btnBuy.setBackground(new Color(0, 102, 255));
		btnBuy.setForeground(Color.WHITE);
		btnBuy.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		if(s!=null){
			if(!s.equals(""))
				btnBuy.setText("DELETE");
		}
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnBuy.getText().equals("DELETE")){
					System.out.println(med_id+"       passed id");
					new AddMedicine("").deleteMedicine(s);
					dispose();
				}
				else{
					String s =JOptionPane.showInputDialog("Quantity");
					md.dispose();
					try{
						int i = Integer.parseInt(s);
						ConnectionToDB ct = new ConnectionToDB();ct.makeConnection();
						ResultSet r = ct.queryExecution("Select maval_quantity from medicines_stock where mname='"+medname+"'");
						int aval=-1;
						try {
							r.next();
							aval = r.getInt("maval_quantity");
							System.out.println(aval+"    aval is this");
							ct.closeConnection();
						} 
						catch (SQLException e) {
							e.printStackTrace();
						}
						if(aval>=i){
							BuyMedicine buyMedicine = new BuyMedicine();
							buyMedicine.setBuyMedicineReference(buyMedicine);
							buyMedicine.setVisible(true);
							buyMedicine.setQty(medname,i,price,u_id);
						}
						else{
							JOptionPane.showMessageDialog(null, "quantity exceeded the stock.");}
						}
					catch(NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Invalid Quantity");
					}
				}
			}
		});
		btnBuy.setBounds(100, 275, 136, 31);
		panel.add(btnBuy);
		
		mname_label = new JLabel("mname");
		mname_label.setForeground(Color.WHITE);
		mname_label.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		mname_label.setBounds(180, 41, 107, 21);
		panel.add(mname_label);
		
		lblMtype = new JLabel("mtype");
		lblMtype.setForeground(Color.WHITE);
		lblMtype.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblMtype.setBounds(180, 78, 107, 20);
		panel.add(lblMtype);
		
		lblMprice = new JLabel("mprice");
		lblMprice.setForeground(Color.WHITE);
		lblMprice.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblMprice.setBounds(180, 114, 107, 20);
		panel.add(lblMprice);
		
		lblMexpdate = new JLabel("mexpdate");
		lblMexpdate.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblMexpdate.setForeground(Color.WHITE);
		lblMexpdate.setBounds(180, 152, 107, 21);
		panel.add(lblMexpdate);
		
		lblMdesc = new JLabel("mdesc");
		lblMdesc.setForeground(Color.WHITE);
		lblMdesc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblMdesc.setBounds(180, 191, 107, 21);
		panel.add(lblMdesc);
		
		lblMstock = new JLabel("mstock");
		lblMstock.setForeground(Color.WHITE);
		lblMstock.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblMstock.setBounds(180, 229, 107, 21);
		panel.add(lblMstock);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 321, 306);
		panel.add(lblNewLabel_1);
		
		if(!s.equals("")){
			System.out.println(s+"          labelset");
			//UserPage uo = new UserPage(0);
			//uo.queriesExecute(5, 0, s);
			ConnectionToDB ctb = new ConnectionToDB();
			ctb.makeConnection();
			String query = "select * from medicines_stock where m_id='"+s+"'";
			ResultSet rs = ctb.queryExecution(query);
			try {
				rs.next();
				String name=rs.getString("Mname");
				String type = rs.getString("MTYPE");
				//String id = rs.getString("M_ID");
				float pr = rs.getFloat("MPRICE");
				String price = String.format("%.2f", pr);
				String stock = rs.getString("AVAILABLE");
				java.util.Date sdate = rs.getDate("MEXPIRY_DATE");
				String date = new SimpleDateFormat("dd-MM-yyyy").format(sdate);
				String desc = rs.getString("MDESCRIPTION");
				setLabels(name,type,price,date,desc,stock,"");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Medicine with given id is not present in the stock");
				e.printStackTrace();
			}
		}
		
	}

	public void setLabels(String name, String type, String price2, String date, String desc, String stock,String id) {
		mname_label.setText(name);
		lblMtype.setText(type);
		lblMprice.setText(price2+"");
		lblMexpdate.setText(date);
		lblMdesc.setText(desc);
		lblMdesc.setToolTipText(desc);
		lblMstock.setText(stock);
		
		this.price=Double.parseDouble(price2);
		medname = name;
		u_id=id;
	}
	
	public void setMedicineDetailsReference(MedicineDetails u){
		md=u;
	}
	
}
