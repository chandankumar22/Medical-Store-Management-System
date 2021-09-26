import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	int flag;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	
	public AdminPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminPage.class.getResource("/images/admic.png")));
		setResizable(false);
		setTitle("Admin Panel");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 842, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 33, 755, 625);
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminPage.class.getResource("/images/adminbg.jpg")));
		label.setBounds(0, 0, 836, 679);
		contentPane.add(label);
		
		JLabel userlist = new JLabel("l");
		userlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				userlist.setIcon(new ImageIcon(AdminPage.class.getResource("/images/userlisthover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				userlist.setIcon(new ImageIcon(AdminPage.class.getResource("/images/userlist.png")));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				UsersList ul = new UsersList(1);
				ul.setVisible(true);
			}
		});
		userlist.setHorizontalAlignment(SwingConstants.CENTER);
		userlist.setIcon(new ImageIcon(AdminPage.class.getResource("/images/userlist.png")));
		panel.add(userlist);
		
		JLabel medicinelist = new JLabel("");
		medicinelist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				medicinelist.setIcon(new ImageIcon(AdminPage.class.getResource("/images/medicineslisthover.png")));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				medicinelist.setIcon(new ImageIcon(AdminPage.class.getResource("/images/medicineslist.png")));

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				UsersList ul = new UsersList(2);
				ul.setVisible(true);
			}
		});
		medicinelist.setHorizontalAlignment(SwingConstants.CENTER);
		medicinelist.setIcon(new ImageIcon(AdminPage.class.getResource("/images/medicineslist.png")));
		panel.add(medicinelist);
		
		JLabel addmedicine = new JLabel("");
		addmedicine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				addmedicine.setIcon(new ImageIcon(AdminPage.class.getResource("/images/addmedicineshover.png")));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				addmedicine.setIcon(new ImageIcon(AdminPage.class.getResource("/images/addmedicines.png")));

			}
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String text = new ConnectionToDB().createNewUserId(3);
				 
				AddMedicine ad = new AddMedicine("");
				ad.lblM.setText(text);
				ad.setVisible(true);
			}
		});
		addmedicine.setHorizontalAlignment(SwingConstants.CENTER);
		addmedicine.setIcon(new ImageIcon(AdminPage.class.getResource("/images/addmedicines.png")));
		panel.add(addmedicine);
		
		JLabel updatemed = new JLabel("");
		updatemed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				updatemed.setIcon(new ImageIcon(AdminPage.class.getResource("/images/updatemedicinehover.png")));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				updatemed.setIcon(new ImageIcon(AdminPage.class.getResource("/images/updatemedicine.png")));

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String id=JOptionPane.showInputDialog("Enter medicine id");
				if(!id.isEmpty()){
				AddMedicine ad = new AddMedicine(id);
				ad.setVisible(true);
				ad.lblM.setText(id);
				ad.formMedicine(id);
				}
			}
		});
		updatemed.setHorizontalAlignment(SwingConstants.CENTER);
		updatemed.setIcon(new ImageIcon(AdminPage.class.getResource("/images/updatemedicine.png")));
		panel.add(updatemed);
		
		JLabel removemed = new JLabel("");
		removemed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				removemed.setIcon(new ImageIcon(AdminPage.class.getResource("/images/removemedicineshover.png")));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				removemed.setIcon(new ImageIcon(AdminPage.class.getResource("/images/removemedicines.png")));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = JOptionPane.showInputDialog("Enter Medicine ID");
				MedicineDetails md = new MedicineDetails(id);
				md.setVisible(true);	
			}
		});
		removemed.setHorizontalAlignment(SwingConstants.CENTER);
		removemed.setIcon(new ImageIcon(AdminPage.class.getResource("/images/removemedicines.png")));
		panel.add(removemed);
		
		JLabel expmed = new JLabel("");
		expmed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				expmed.setIcon(new ImageIcon(AdminPage.class.getResource("/images/expiredmedicinehover.png")));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				expmed.setIcon(new ImageIcon(AdminPage.class.getResource("/images/expiredmedicine.png")));

			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new AddMedicine("").showExpiredMedicines();

			}
		});
		expmed.setHorizontalAlignment(SwingConstants.CENTER);
		expmed.setIcon(new ImageIcon(AdminPage.class.getResource("/images/expiredmedicine.png")));
		panel.add(expmed);
		
		JLabel viewstock = new JLabel("");
		viewstock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				viewstock.setIcon(new ImageIcon(AdminPage.class.getResource("/images/viewmedicinewithlessstockhover.png")));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				viewstock.setIcon(new ImageIcon(AdminPage.class.getResource("/images/viewmedicinewithlessstock.png")));

			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new AddMedicine("").showStock();
			}
		});
		viewstock.setHorizontalAlignment(SwingConstants.CENTER);
		viewstock.setIcon(new ImageIcon(AdminPage.class.getResource("/images/viewmedicinewithlessstock.png")));
		panel.add(viewstock);
		
		JLabel totalsale = new JLabel("");
		totalsale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				totalsale.setIcon(new ImageIcon(AdminPage.class.getResource("/images/totalsalehover.png")));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				totalsale.setIcon(new ImageIcon(AdminPage.class.getResource("/images/totalsale.png")));

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMedicine am = new AddMedicine("");
				am.showTotalSales();
			}
		});
		totalsale.setHorizontalAlignment(SwingConstants.CENTER);
		totalsale.setIcon(new ImageIcon(AdminPage.class.getResource("/images/totalsale.png")));
		panel.add(totalsale);
		
		JLabel totalpurchase = new JLabel("");
		totalpurchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				totalpurchase.setIcon(new ImageIcon(AdminPage.class.getResource("/images/totalpurchasehover.png")));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				totalpurchase.setIcon(new ImageIcon(AdminPage.class.getResource("/images/totalpurchase.png")));

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddMedicine("").showTotalPurchase();
			}
		});
		totalpurchase.setHorizontalAlignment(SwingConstants.CENTER);
		totalpurchase.setIcon(new ImageIcon(AdminPage.class.getResource("/images/totalpurchase.png")));
		panel.add(totalpurchase);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		btnLogout.setBackground(new Color(0, 102, 255));
		btnLogout.setBounds(650, 0, 136, 31);
		contentPane.add(btnLogout);
	}
	
	

}
