import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class UserPage extends JFrame {

	private JPanel contentPane;
	private JTextField search_box;
	private JTable table;
	private JScrollPane scrollPane;
	JLabel lblUsernameName;
	JLabel useridlabbel;
	UserPage up;
	private JLabel lblA;
	private JButton btnDeleteProfile;
	JFrame jf;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	
	public UserPage(int dumm)
	{
		
	}
	
	public UserPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserPage.class.getResource("/images/useric.png")));
		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitle("Search and Buy");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 829, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		search_box = new JTextField();
		search_box.setFont(new Font("Tahoma", Font.PLAIN, 18));
		search_box.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				queriesExecute(1,0,"");
			}
		});
		search_box.setBounds(27, 51, 575, 35);
		contentPane.add(search_box);
		search_box.setColumns(10);
		
		scrollPane = new JScrollPane();
		/*scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println( table.getSelectedRow());
			}
		});*/
		scrollPane.setBounds(27, 109, 577, 356);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Purchase History");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseHistory p = new PurchaseHistory();
				String u_id=useridlabbel.getText();
				p.setVisible(true);
				p.showPurchaseHistory(u_id);
			}
		});
		btnNewButton.setBounds(628, 132, 165, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Receipts");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		btnNewButton_1.setBackground(new Color(0, 102, 255));
		btnNewButton_1.setBounds(628, 211, 165, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Edit Profile");
		btnNewButton_2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(0, 102, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//editProfile();
				RegistrationForm r =new RegistrationForm(useridlabbel.getText(),0);
				r.setRegistrationPageReference(r);
			}
		});
		btnNewButton_2.setBounds(628, 294, 165, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 18));
		btnNewButton_3.setBackground(new Color(0, 102, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				up.dispose();
			}
		});
		
		btnDeleteProfile = new JButton("Delete Profile");
		btnDeleteProfile.setBackground(new Color(0, 102, 255));
		btnDeleteProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ans = JOptionPane.showConfirmDialog(null, "Are you sure to delete this profile?");
				if(ans==JOptionPane.YES_OPTION)
					queriesExecute(6, 0, "");
				else if(ans==JOptionPane.NO_OPTION){}
				else if(ans==JOptionPane.CANCEL_OPTION){}
			}
		});
		btnDeleteProfile.setForeground(Color.WHITE);
		btnDeleteProfile.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		btnDeleteProfile.setBounds(628, 360, 165, 35);
		contentPane.add(btnDeleteProfile);
		btnNewButton_3.setBounds(628, 430, 165, 35);
		contentPane.add(btnNewButton_3);
		
		queriesExecute(2,0,"");
		table.setEnabled(false);
		
		JButton btnViewDetails = new JButton("View Details");
		btnViewDetails.setForeground(Color.WHITE);
		btnViewDetails.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		btnViewDetails.setBackground(new Color(0, 102, 255));
		btnViewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = search_box.getText().trim();
				if(text.isEmpty()){
					JOptionPane.showMessageDialog(null, "Input medicine Name", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					queriesExecute(3,0,text);
				}
			}
		});
		btnViewDetails.setBounds(634, 54, 137, 29);
		contentPane.add(btnViewDetails);
		
		lblUsernameName = new JLabel("usernameusernameusername");
		lblUsernameName.setForeground(Color.WHITE);
		lblUsernameName.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		lblUsernameName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsernameName.setBounds(398, 13, 248, 29);
		contentPane.add(lblUsernameName);
		
		JLabel lblLoggedIn = new JLabel("Logged In");
		lblLoggedIn.setForeground(Color.WHITE);
		lblLoggedIn.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		lblLoggedIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoggedIn.setBounds(628, 13, 128, 25);
		contentPane.add(lblLoggedIn);
		
		useridlabbel = new JLabel("User Id:");
		useridlabbel.setForeground(Color.WHITE);
		useridlabbel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		useridlabbel.setHorizontalAlignment(SwingConstants.CENTER);
		useridlabbel.setBounds(291, 16, 97, 24);
		contentPane.add(useridlabbel);
		
		lblA = new JLabel("a");
		lblA.setIcon(new ImageIcon(UserPage.class.getResource("/images/userpagebg.jpg")));
		lblA.setBounds(0, 0, 823, 476);
		contentPane.add(lblA);
		
		//new PurchaseHistory().showPurchaseHistory("");
		/*ArrayList l = PurchaseHistory.showLastPurchaseDetails();
		System.out.println(l.get(0)+"Al01    "+l.get(1));
		lblLastMedName.setText((String)(l.get(0)));
		String date = new SimpleDateFormat().format(l.get(1));
		lblLastDateAndTime.setText(date);*/
		
	}
	
	
	public void setUserPageReference(UserPage u){
		up=u;
	}
	
	


	public void queriesExecute(int flag,int qty,String mname){
		String query="";
		ConnectionToDB ctb = new ConnectionToDB();
		ctb.makeConnection();
		if(flag==1){
			String name = search_box.getText().trim();
			query = "select mname,mtype,mdescription from medicines_stock where mname like '"+name+"%'";
			ResultSet rs = ctb.queryExecution(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		else if(flag==2){
			query = "select mname,mtype,mdescription from medicines_stock";
			ResultSet rs = ctb.queryExecution(query);
			try {
				rs.next();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		else if(flag==3){
			query = "select * from medicines_stock where mname='"+mname+"'";
			ResultSet rs = ctb.queryExecution(query);
			try {
				if(rs.next()){
				String name=search_box.getText();
				String type = rs.getString("MTYPE");
				//String id = rs.getString("M_ID");
				float pr = rs.getFloat("MPRICE");
				String price = String.format("%.2f", pr);
				String stock = rs.getString("AVAILABLE");
				java.sql.Date s = rs.getDate("MEXPIRY_DATE");
				String date = new SimpleDateFormat("dd-MM-YYYY").format(s);
				String desc = rs.getString("MDESCRIPTION");
				String uid = useridlabbel.getText();
				MedicineDetails medicineDetails = new MedicineDetails("");
				medicineDetails.setMedicineDetailsReference(medicineDetails);
				medicineDetails.setVisible(true);
				medicineDetails.setLabels(name,type,price,date,desc,stock,uid);
				}
				else{
					JOptionPane.showMessageDialog(null, "Medicine Not Found");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(flag==4){
				System.out.println("Quaantity minus is "+qty);
				query="update medicines_stock set MAVAL_QUANTITY=MAVAL_QUANTITY-"+qty+" where mname='"+mname+"'";
				ctb.queryUpdation(query);
		}
		else if(flag==5){
			query = "select * from medicines_stock where m_id='"+mname+"'";
			ResultSet rs = ctb.queryExecution(query);
			try {
				rs.next();
				String name=rs.getString("Mname");
				String type = rs.getString("MTYPE");
				//String id = rs.getString("M_ID");
				float pr = rs.getFloat("MPRICE");
				String price = String.format("%.2f", pr);
				String stock = rs.getString("AVAILABLE");
				java.util.Date s = rs.getDate("MEXPIRY_DATE");
				String date = new SimpleDateFormat("dd-MM-yyy").format(s);
				String desc = rs.getString("MDESCRIPTION");
				MedicineDetails medicineDetails = new MedicineDetails("");
				medicineDetails.setVisible(true);
				medicineDetails.setLabels(name,type,price,date,desc,stock,"");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		else if(flag==6){
			query="delete from users where u_id='"+useridlabbel.getText().trim()+"'";
			ctb.queryUpdation(query);
			dispose();
		}
	
		ctb.closeConnection();
	}
	
	public void showname(String uname,String u_id){
		lblUsernameName.setText(uname);
		useridlabbel.setText(u_id);
		setTitle(uname);
		
	}
}
