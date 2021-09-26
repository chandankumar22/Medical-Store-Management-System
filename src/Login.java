import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField name_textField;
	private JPasswordField password_textField;
	private ImageIcon ic;
	int  flag;
	Login lo;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblA;
	private JLabel lblA_1;
	private JLabel label;;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	
	public Login(int i){
		
		Login l = new Login();
		l.flag=i;
		l.lo=l;
		l.setVisible(true);
	}
	
	
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/logic.png")));
		setTitle("Login");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 571, 446);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 565, 417);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 46, 83));
		panel_1.setBounds(78, 154, 411, 228);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		name_textField = new JTextField();
		name_textField.setForeground(Color.BLACK);
		name_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		name_textField.setBounds(67, 78, 293, 35);
		panel_1.add(name_textField);
		name_textField.setColumns(10);
		//name_textField.setText("ID");
		
		password_textField = new JPasswordField();
		password_textField.setForeground(Color.GRAY);
		password_textField.setEchoChar('*');
		password_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		password_textField.setBounds(67, 124, 293, 35);
		panel_1.add(password_textField);
		//password_textField.setText("Password");
		
		JLabel lblLoginToStore = new JLabel("Login");
		lblLoginToStore.setBounds(21, 11, 147, 47);
		panel_1.add(lblLoginToStore);
		lblLoginToStore.setForeground(Color.WHITE);
		lblLoginToStore.setFont(new Font("Mongolian Baiti", Font.BOLD, 39));
		
		lblA = new JLabel("");
		lblA.setIcon(new ImageIcon(Login.class.getResource("/images/uiicon.png")));
		lblA.setBounds(21, 78, 35, 35);
		panel_1.add(lblA);
		
		lblA_1 = new JLabel("");
		lblA_1.setIcon(new ImageIcon(Login.class.getResource("/images/passicon.png")));
		lblA_1.setBounds(21, 124, 35, 35);
		panel_1.add(lblA_1);
		
		
		
		JButton signinbtn = new JButton("SIGN IN");
		signinbtn.setForeground(Color.WHITE);
		signinbtn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		signinbtn.setBackground(new Color(16, 95, 159));
		signinbtn.setBounds(133, 179, 108, 38);
		panel_1.add(signinbtn);
		signinbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("user is "+flag);
				if(name_textField.getText().isEmpty()||password_textField.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Please Enter UserId/Password");
				else
					authenticate(flag);
			}
		});
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Login.class.getResource("/images/logo.png")));
		label.setBounds(186, 0, 151, 150);
		panel.add(label);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/loginbg.png")));
		lblNewLabel.setBounds(0, 0, 565, 417);
		panel.add(lblNewLabel);
	}
	
	public void authenticate(int flag){
		
		if(flag==1){
		ConnectionToDB ct = new ConnectionToDB();
		ct.makeConnection();
		String s = String.format("Select upassword,uname,u_id from users where u_id = '%s'", name_textField.getText());
		
		ResultSet rs = ct.queryExecution(s);
		
		System.out.println(rs);
		
		try {
			if(rs.next()){
			if(rs.getString("upassword").equals(password_textField.getText())){
				lo.dispose();
				UserPage u = new UserPage();
				u.setUserPageReference(u);
				u.setVisible(true);
				u.showname(rs.getString("uname"),rs.getString("u_id"));
			}
			else{
				JOptionPane.showMessageDialog(null, "Invalid password");
			}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Invalid user id");
			e.printStackTrace();
		}
		
		}
		
		else if(flag==2){
			String admin_id = "ad1001";
			String admin_password = "admin";
			if(name_textField.getText().equals(admin_id) && password_textField.getText().equals(admin_password)){
				lo.dispose();
				AdminPage adminPage = new AdminPage();
				adminPage.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "Invalid Credentials");
			}
		}
	}
}
