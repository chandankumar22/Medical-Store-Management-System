import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UsersList extends JFrame {

	private JPanel contentPane;
	private JTable table; int i;UsersList ul;
private JLabel lblUsersInformation;
private JLabel label;
private JTextField textField;
int flag;
private JLabel lblName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersList frame = new UsersList(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	/*public UsersList(int flag){
		UsersList ul = new UsersList();
		//ul=ul;
		i=flag;
		ul.setVisible(true);
		showUsersList();
		
		System.out.println(i+ "          "+ul.i);
	}*/
	
	
	

	/**
	 * Create the frame.
	 */
	public UsersList(int flag) {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(UsersList.class.getResource("/images/listic.png")));
		setTitle("Users");
		setResizable(false);
		i=flag;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 100, 1343, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 144, 1307, 391);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		
		lblUsersInformation = new JLabel("USER'S INFORMATION");
		lblUsersInformation.setForeground(Color.WHITE);
		lblUsersInformation.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
		lblUsersInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsersInformation.setBounds(462, 11, 392, 71);
		contentPane.add(lblUsersInformation);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				String search=textField.getText();
				System.out.println("in listener "+" searched = "+search);
				showSearchResults(flag,search);
			}
		});
		
		lblName = new JLabel("NAME:");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		lblName.setBounds(31, 78, 108, 37);
		contentPane.add(lblName);
		textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBounds(149, 78, 1168, 37);
		contentPane.add(textField);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(UsersList.class.getResource("/images/bgg.jpg")));
		label.setBounds(0, 0, 1337, 546);
		contentPane.add(label);
		
			//if(flag==1)
		System.out.println(flag+"  flag");
				showUsersList(flag);
		
			/*else if(flag==2)
				showMedicinesList(flag);*/
	}
	
	
	protected void showSearchResults(int j, String search) {
		
		System.out.println("Enterer showaresults with flag="+j+" searched = "+search);
		if(j==1){
			String query = "Select u_id,uname,uage,ugender,uemail,uphone,uaddress,ucity,ustate,ucountry from users where uname like '"+search+"%'";
			System.out.println("searched query   "+query);
			ConnectionToDB c = new ConnectionToDB();
			c.makeConnection();
			ResultSet rs = c.queryExecution(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			c.closeConnection();
		}
		else if(j==2){
			String query = "Select * from  medicines_stock where mname like '"+search+"%'";
			System.out.println("searched query   "+query);
			ConnectionToDB c = new ConnectionToDB();
			c.makeConnection();
			ResultSet rs = c.queryExecution(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			c.closeConnection();
		}
		
	}



	public void showUsersList(int i){
		System.out.println(i+"   i");
		if(i==1){
		ConnectionToDB c = new ConnectionToDB();
		c.makeConnection();
		ResultSet rs = c.queryExecution("Select u_id,uname,uage,ugender,uemail,uphone,uaddress,ucity,ustate,ucountry from  users");
		table.setModel(DbUtils.resultSetToTableModel(rs));
		c.closeConnection();}
		else if(i==2){
			lblUsersInformation.setText("MEDICINES LIST");
			ConnectionToDB c = new ConnectionToDB();
			c.makeConnection();
			ResultSet rs = c.queryExecution("Select * from  medicines_stock");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			c.closeConnection();

		}
	}
}
