import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class FirstPage {

	private JFrame frmMedicalStoreManagement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage window = new FirstPage();
					window.frmMedicalStoreManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/**
	 * 
	 */
	public FirstPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMedicalStoreManagement = new JFrame();
		frmMedicalStoreManagement.setIconImage(Toolkit.getDefaultToolkit().getImage(FirstPage.class.getResource("/images/logo.png")));
		frmMedicalStoreManagement.setResizable(false);
		frmMedicalStoreManagement.setTitle("Medical Store Management System");
		frmMedicalStoreManagement.getContentPane().setLayout(null);
		frmMedicalStoreManagement.setBounds(100, 100, 882, 533);
		frmMedicalStoreManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 876, 504);
		frmMedicalStoreManagement.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//frmMedicalStoreManagement.getContentPane().setBackground(new Color(102, 153, 204));
		
		//panel.setLayout(new BoxLayout(frmMedicalStoreManagement.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel title_panel = new JPanel();
		title_panel.setBackground(new Color(0, 51, 255));
		
		JPanel uar_panel = new JPanel();
		uar_panel.setBackground(new Color(0, 102, 255));
		title_panel.setLayout(null);
		
		JLabel title_label = new JLabel("Medical Store Management\r\n System\r\n");
		title_label.setBounds(0, 0, 866, 140);
		title_label.setBackground(new Color(0, 153, 51));
		title_label.setForeground(Color.WHITE);
		title_label.setFont(new Font("Colonna MT", Font.BOLD, 50));
		title_label.setHorizontalAlignment(SwingConstants.CENTER);
		title_panel.add(title_label);
		
		
		panel.add(title_panel);
		panel.add(uar_panel);
		uar_panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel label_admin = new JLabel("");
		label_admin.setHorizontalAlignment(SwingConstants.CENTER);
		label_admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Login login = new Login(2);
				//login.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_admin.setIcon(new ImageIcon(FirstPage.class.getResource("/images/adminloginhover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_admin.setIcon(new ImageIcon(FirstPage.class.getResource("/images/adminlogin.png")));
			}
		});
		label_admin.setIcon(new ImageIcon(FirstPage.class.getResource("/images/adminlogin.png")));
		uar_panel.add(label_admin);
		
		JLabel label_user = new JLabel("");
		label_user.setHorizontalAlignment(SwingConstants.CENTER);
		label_user.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_user.setIcon(new ImageIcon(FirstPage.class.getResource("/images/userloginhover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_user.setIcon(new ImageIcon(FirstPage.class.getResource("/images/userlogin.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Login login = new Login(1);
				//login.setVisible(true);
			}
		});
		label_user.setIcon(new ImageIcon(FirstPage.class.getResource("/images/userlogin.png")));
		uar_panel.add(label_user);
		
		JLabel label_register = new JLabel("");
		label_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_register.setIcon(new ImageIcon(FirstPage.class.getResource("/images/regusershover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_register.setIcon(new ImageIcon(FirstPage.class.getResource("/images/regusers.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e)  {
				ConnectionToDB c = new ConnectionToDB();
				String uid =c.createNewUserId(1);
				 new RegistrationForm(uid,1);
			}
		});
		label_register.setHorizontalAlignment(SwingConstants.CENTER);
		label_register.setIcon(new ImageIcon(FirstPage.class.getResource("/images/regusers.png")));
		uar_panel.add(label_register);
		
		JPanel b_panel = new JPanel();
		panel.add(b_panel);
		b_panel.setBackground(new Color(0, 102, 255));
		
		JButton about_btn = new JButton("ABOUT");
		about_btn.setBounds(149, 23, 175, 49);
		about_btn.setVerticalAlignment(SwingConstants.BOTTOM);
		about_btn.setFont(new Font("Sitka Subheading", Font.PLAIN, 28));
		about_btn.setBackground(new Color(255, 255, 204));
		about_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frmMedicalStoreManagement, "This is a simple Medical Store Management System Application.");
			}
		});
		b_panel.setLayout(null);
		b_panel.add(about_btn);
		
		JButton exit_btn = new JButton("EXIT");
		exit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMedicalStoreManagement.dispose();
			}
		});
		exit_btn.setBounds(463, 23, 152, 50);
		exit_btn.setBackground(new Color(255, 255, 204));
		exit_btn.setFont(new Font("Sitka Heading", Font.PLAIN, 28));
		b_panel.add(exit_btn);
		
	
	}
}
