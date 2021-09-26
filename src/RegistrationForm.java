import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RegistrationForm extends JFrame {

	private JPanel contentPane;
	private JTextField name_textField;
	private JTextField age_textField;
	private JTextField email_textField;
	private JTextField phoneno_textField;
	private JTextField address_textField;
	private JPasswordField password_textField;
	private JPasswordField repeatpassword_textField;
	private JTextField city_textField;
	private JTextField state_textField;
	private JTextField country_textField;
	private JRadioButton male_rdbtn;
	private ButtonGroup b;
	private JRadioButton female_rdbtn;
	String uid;
	RegistrationForm rf;
	JLabel id_label; String edit_id="";
	JButton register_btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	public RegistrationForm(String u_id,int i){
		System.out.println("edit id is"+u_id);
		if(i==1){
			
			RegistrationForm r = new RegistrationForm();
			r.setUserId(u_id);
			r.setVisible(true);
		}
		else{
		edit_id=u_id;
		RegistrationForm r = new RegistrationForm();
		r.setVisible(true);
		r.editProfile(u_id);
		
		}
		
	}
	
	
	private void setUserId(String u_id) {
		System.out.println("id in method created "+uid);

		id_label.setText(u_id);
		
	}


	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public RegistrationForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrationForm.class.getResource("/images/regic.png")));
		setResizable(false);
		setTitle("Registration");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 632, 674);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 153));
		contentPane.setForeground(new Color(0, 0, 51));
		//contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Register Here", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 46, 83));
		panel.setOpaque(true);
		panel.setBounds(20, 21, 571, 592);
		contentPane.add(panel);
		
		JLabel l = new JLabel();
		//contentPane.add(l);
		
		panel.setLayout(new MigLayout("", "[][][][][][][][][][][][][]", "[][][][][][][][][][][][][][][][][]"));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registration Form", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		
		JLabel userid_label = new JLabel("User Id:");
		userid_label.setForeground(new Color(0, 204, 204));
		userid_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		panel.add(userid_label, "cell 0 1,alignx trailing");
		
		 id_label = new JLabel("");
		 id_label.setForeground(new Color(204, 255, 255));
		id_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 22));
		id_label.setHorizontalTextPosition(SwingConstants.CENTER);
		id_label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(id_label, "cell 1 1 7 1");
	
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegistrationForm.class.getResource("/images/Userreg.png")));
		panel.add(label, "cell 9 1 2 3");
		
		JLabel lblNewLabel = new JLabel("Personal Information");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Colonna MT", Font.BOLD, 34));
		panel.add(lblNewLabel, "cell 0 3 5 1");
		
		JLabel name_label = new JLabel("Name: ");
		name_label.setForeground(Color.WHITE);
		name_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		panel.add(name_label, "cell 0 4,alignx trailing");
		
		name_textField = new JTextField();
		name_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				name_textField.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.green));
			}
			@Override
			public void focusLost(FocusEvent e) {
				name_textField.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		name_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		name_textField.setBackground(new Color(240, 248, 255));
		panel.add(name_textField, "cell 1 4 9 1,growx,aligny center");
		name_textField.setColumns(10);

		
		JLabel age_label = new JLabel("Age:");
		age_label.setForeground(Color.WHITE);
		age_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		panel.add(age_label, "cell 0 5,alignx trailing");
		
		age_textField = new JTextField();
		age_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				age_textField.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.green));
			}
			@Override
			public void focusLost(FocusEvent e) {
				age_textField.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		age_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		age_textField.setBackground(new Color(240, 248, 255));
		panel.add(age_textField, "cell 1 5 2 1,growx");
		age_textField.setColumns(10);
		
		JLabel sex_label = new JLabel("                    Sex:");
		sex_label.setForeground(Color.WHITE);
		sex_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		panel.add(sex_label, "cell 0 6");
		
		b = new  ButtonGroup();
		male_rdbtn = new JRadioButton("Male");
		male_rdbtn.setBackground(new Color(1, 46, 83));
		male_rdbtn.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		male_rdbtn.setForeground(Color.WHITE);
		panel.add(male_rdbtn, "flowx,cell 1 6");
		b.add(male_rdbtn);
		female_rdbtn = new JRadioButton("Feamle");
		female_rdbtn.setBackground(new Color(1, 46, 83));
		female_rdbtn.setForeground(Color.WHITE);
		female_rdbtn.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		panel.add(female_rdbtn, "cell 1 6");
		b.add(female_rdbtn);
		
		JLabel email_label = new JLabel("Email:");
		email_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		email_label.setForeground(Color.WHITE);
		panel.add(email_label, "cell 0 7,alignx trailing");
		
		
		email_textField = new JTextField();
		email_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				email_textField.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.green));
			}
			@Override
			public void focusLost(FocusEvent e) {
				email_textField.setBorder(new EmptyBorder(1,1,1,1));
			}
		});
		email_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		email_textField.setBackground(new Color(240, 248, 255));
		panel.add(email_textField, "cell 1 7 9 1,growx");
		email_textField.setColumns(10);
		
		JLabel phoneno_label = new JLabel("Phone No.:");
		phoneno_label.setForeground(Color.WHITE);
		phoneno_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		panel.add(phoneno_label, "cell 0 8,alignx trailing");
		
		phoneno_textField = new JTextField(10);
		phoneno_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				phoneno_textField.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.green));
			}
			@Override
			public void focusLost(FocusEvent e) {
				phoneno_textField.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		phoneno_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		phoneno_textField.setBackground(new Color(240, 248, 255));
		panel.add(phoneno_textField, "cell 1 8 9 1,growx");
		phoneno_textField.setColumns(10);
		
		JLabel address_label = new JLabel("Address:");
		address_label.setForeground(Color.WHITE);
		address_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		panel.add(address_label, "cell 0 9,alignx trailing");
		
		address_textField = new JTextField();
		address_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				address_textField.setBorder(new MatteBorder(3,3,3,3, (Color) Color.green));
			}
			@Override
			public void focusLost(FocusEvent e) {
				address_textField.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		address_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		address_textField.setBackground(new Color(240, 248, 255));
		panel.add(address_textField, "cell 1 9 9 1,growx");
		address_textField.setColumns(10);
		
		JLabel city_label = new JLabel("City:");
		city_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		city_label.setForeground(Color.WHITE);
		panel.add(city_label, "cell 0 10,alignx trailing");
		
		city_textField = new JTextField();
		city_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				city_textField.setBorder(new MatteBorder(3,3,3,3, (Color) Color.green));
			}
			@Override
			public void focusLost(FocusEvent e) {
				city_textField.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		city_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		city_textField.setBackground(new Color(240, 248, 255));
		panel.add(city_textField, "cell 1 10 3 1,growx");
		city_textField.setColumns(10);
		
		JLabel state_label = new JLabel("State:");
		state_label.setForeground(Color.WHITE);
		state_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		panel.add(state_label, "cell 0 11,alignx trailing");
		
		state_textField = new JTextField();
		state_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				state_textField.setBorder(new MatteBorder(3,3,3,3, (Color) Color.green));
			}
			@Override
			public void focusLost(FocusEvent e) {
				state_textField.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		state_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		state_textField.setBackground(new Color(240, 248, 255));
		panel.add(state_textField, "cell 1 11 3 1,growx");
		state_textField.setColumns(10);
		
		JLabel country_label = new JLabel("Country: ");
		country_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		country_label.setForeground(Color.WHITE);
		panel.add(country_label, "cell 0 12,alignx trailing");
		
		country_textField = new JTextField();
		country_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				country_textField.setBorder(new MatteBorder(3,3,3,3, (Color) Color.green));
			}
			@Override
			public void focusLost(FocusEvent e) {
				country_textField.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		country_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		country_textField.setBackground(new Color(240, 248, 255));
		panel.add(country_textField, "cell 1 12 3 1,growx");
		country_textField.setColumns(10);
		
		JLabel password_label = new JLabel("Password:");
		password_label.setForeground(Color.WHITE);
		password_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		panel.add(password_label, "cell 0 13,alignx trailing,aligny baseline");
		
		password_textField = new JPasswordField();
		password_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				password_textField.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.green));
			}
			@Override
			public void focusLost(FocusEvent e) {
				password_textField.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		password_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		password_textField.setBackground(new Color(240, 248, 255));
		panel.add(password_textField, "cell 1 13 9 1,growx");
		
		JLabel repeatpassword_label = new JLabel("Repeat Password:");
		repeatpassword_label.setForeground(Color.WHITE);
		repeatpassword_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		panel.add(repeatpassword_label, "cell 0 14,alignx trailing");
		
		repeatpassword_textField = new JPasswordField();
		repeatpassword_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(password_textField.getPassword().toString().isEmpty()){}
				if(repeatpassword_textField.getText().equals(password_textField.getText())){
					repeatpassword_textField.setBorder(new MatteBorder(3,3, 3, 3, (Color) Color.green));
				}
			}
		});
		
		
		repeatpassword_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(password_textField.getText().toString().isEmpty()){}
				if(repeatpassword_textField.getText().equals(password_textField.getText())){
					repeatpassword_textField.setBorder(new MatteBorder(3,3, 3, 3, (Color) Color.green));
				}
				else 				repeatpassword_textField.setBorder(new MatteBorder(3, 3,3, 3, (Color) Color.red));
		}
			
			@Override
			public void focusLost(FocusEvent e) {
				repeatpassword_textField.setBorder(new EmptyBorder(1, 1, 1, 1));
				
				/**if(!(name_textField.getText().isEmpty()||age_textField.getText().isEmpty()||
						email_textField.getText().isEmpty()||address_textField.getText().isEmpty()||
						country_textField.getText().isEmpty()||city_textField.getText().isEmpty()||
						state_textField.getText().isEmpty()||password_textField.getText().isEmpty()||
						repeatpassword_textField.getText().isEmpty()||
						(!male_rdbtn.isSelected()&&!female_rdbtn.isSelected())||
						phoneno_textField.getText().isEmpty())) {
					try{
						int a = Integer.parseInt(age_textField.getText());
					}catch(NumberFormatException nfe){
						age_textField.setBorder(new MatteBorder(3,3,3,3,Color.red));
					}
					try{
					int b= Integer.parseInt(phoneno_textField.getText());
					}catch(NumberFormatException nfe){
						phoneno_textField.setBorder(new MatteBorder(3,3,3,3,Color.red));
					}
					register_btn.setEnabled(true);**/
				}
		});
		repeatpassword_textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		repeatpassword_textField.setBackground(new Color(240, 248, 255));
		panel.add(repeatpassword_textField, "cell 1 14 9 1,growx");
		
		
		
		register_btn = new JButton("Register");
	//	register_btn.setEnabled(false);
		register_btn.setBackground(new Color(16, 95, 159));
		register_btn.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		register_btn.setForeground(Color.WHITE);
		panel.add(register_btn, "cell 1 15 1 2");
		register_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(register_btn.getText().equals("Register")){
					try{
						if(validateForm()){
						InsertToDB(e);
						}
						//frame.dispose();
					}
					catch (Exception i) {
						System.out.println(i.getMessage()+"\n"+"");
						i.printStackTrace();
					}
				}
				else{
					updateToDB();
				}
			}
		});
		

		JLabel lblNewLabel1 = new JLabel("a");
		lblNewLabel1.setIcon(new ImageIcon(RegistrationForm.class.getResource("/images/rgbg.png")));
		lblNewLabel1.setBounds(0, 0, 626, 645);
		contentPane.add(lblNewLabel1);
	}
	
	
	public boolean validateForm(){
		if((name_textField.getText().isEmpty()||age_textField.getText().isEmpty()||
				email_textField.getText().isEmpty()||address_textField.getText().isEmpty()||
				country_textField.getText().isEmpty()||city_textField.getText().isEmpty()||
				state_textField.getText().isEmpty()||password_textField.getText().isEmpty()||
				repeatpassword_textField.getText().isEmpty()||
				(!male_rdbtn.isSelected()&&!female_rdbtn.isSelected())||
				phoneno_textField.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null,"Please fill all the fields");
			return false;
		}
		
		
		
		
		else
		{
			try{
				int age=Integer.parseInt(age_textField.getText());
				if(age>=100||age<15)
				{	
					age_textField.setBorder(new MatteBorder(3,3,3,3,Color.red));
					age_textField.setToolTipText("Age can not be less than 15 or negative or more than 100");
					return false;
				}
				
			}catch(NumberFormatException nfe){
				age_textField.setBorder(new MatteBorder(3,3,3,3,Color.red));return false;
			}
			try{
				//  p = Integer.parseInt(phoneno_textField.getText());
				if(phoneno_textField.getText().length()!=10){
					phoneno_textField.setBorder(new MatteBorder(3,3,3,3,Color.red));
					phoneno_textField.setToolTipText("Phone number should be of 10 digits");
					return false;
				}
			}catch(NumberFormatException nfe){
				phoneno_textField.setBorder(new MatteBorder(3,3,3,3,Color.red));return false;
			}
		}
		return true;
	}
	
	
	@SuppressWarnings("deprecation")
	public void InsertToDB(ActionEvent regform) {
		
		
		String uname;
		int uage;
		String usex;
		String uphone;
		String uaddress;
		String ucity;
		String ustate;
		String ucountry;
		String upassword;
		String uemail;
		
		ConnectionToDB c = new ConnectionToDB();
		String uuid = id_label.getText();
	
			System.out.println("success");
		uname=name_textField.getText();
			uage=Integer.parseInt(age_textField.getText());
			
			if(male_rdbtn.isSelected())
				usex="M";
			else
				usex="F";
			
			uemail = email_textField.getText();
			uphone =  phoneno_textField.getText();
			uaddress = address_textField.getText();
			ucity = city_textField.getText();
			ustate = state_textField.getText();
			ucountry = country_textField.getText();
			upassword = password_textField.getText();
			String urepeatpassword =repeatpassword_textField.getText();
			
			if(uuid==null) 
				JOptionPane.showMessageDialog(null, "uid null de raha hai");
			else {
				
			}
			
			
			if(upassword.equals(urepeatpassword))
			{
				System.out.println("p="+upassword+"rp="+urepeatpassword);
				boolean checkConnection = c.makeConnection();
				String query = "insert into users values(?,?,?,?,?,?,?,?,?,?,?)";
				if(checkConnection)
				{
					int i = c.insertToUsers(query,uuid, uname, uage, usex,uemail, uphone, uaddress, ucity, ustate, ucountry, upassword);
					c.closeConnection();
					
					if(i==1) {
						JOptionPane.showMessageDialog(null, "Registered Successfully");
						dispose();
					}
					else	   
						JOptionPane.showMessageDialog(null, "Problem while Registering");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error Connecting to Database");
				}
			}
			
			else
				JOptionPane.showMessageDialog(null, "Password Do not Match");
		}
	
		


	public void editProfile(String edit_id){
		this.edit_id=edit_id;
		id_label.setText(edit_id);
		String query = "Select * from users where u_id ='"+edit_id+"'";
		ConnectionToDB c = new ConnectionToDB();
		c.makeConnection();
		ResultSet resultSet = c.queryExecution(query);
		try {
			resultSet.next();
			name_textField.setText(resultSet.getString("uname"));
			age_textField.setText(resultSet.getInt("uage")+"");
			String sex = resultSet.getString("ugender");
			if(sex.equals("M")) male_rdbtn.setSelected(true);else female_rdbtn.setSelected(true);
			phoneno_textField.setText(resultSet.getString("uphone"));
			email_textField.setText(resultSet.getString("uemail"));
			state_textField.setText(resultSet.getString("ustate"));
			address_textField.setText(resultSet.getString("uaddress"));
			country_textField.setText(resultSet.getString("ucountry"));
			city_textField.setText(resultSet.getString("ucity"));
			password_textField.setText(resultSet.getString("upassword"));
			register_btn.setText("UPDATE");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.closeConnection();
	}
	
	public void updateToDB(){
		String query = "update users set u_id=?,uname=?,uage=?,ugender=?,uemail=?,uphone=?,uaddress=?,ucity=?,ustate=?,ucountry=?,upassword=? where u_id='"+edit_id+"'";
		String uname=name_textField.getText();
		String usex;
		int uage=Integer.parseInt(age_textField.getText());
		
		if(male_rdbtn.isSelected())
			usex="M";
		else
			usex="F";
		
		String uemail = email_textField.getText();
		String uphone =  phoneno_textField.getText();
		String uaddress = address_textField.getText();
		String ucity = city_textField.getText();
		String ustate = state_textField.getText();
		String ucountry = country_textField.getText();
		String upassword = password_textField.getText();
		String urepeatpassword =repeatpassword_textField.getText();
		ConnectionToDB c = new ConnectionToDB();
		int i=0;
		c.makeConnection();
		if(upassword.equals(urepeatpassword))
			i = c.insertToUsers(query, edit_id, uname, uage, usex, uemail, uphone, uaddress, ucity, ustate, ucountry, upassword);
		else
			JOptionPane.showMessageDialog(null, "Password do not match");
		if(i==1) {
			JOptionPane.showMessageDialog(null, "Updated Successfully");
			dispose();
		}
		else	   
			JOptionPane.showMessageDialog(null, "Problem while Updating");
		c.closeConnection();
		
	}
	
	public void setRegistrationPageReference(RegistrationForm u){
		rf=u;
	}
}

