import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class BuyMedicine extends JFrame {

	private JPanel contentPane;
	String u_id;
	BuyMedicine bm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyMedicine frame = new BuyMedicine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	JLabel lblMname;
	JLabel lblQty;
	JLabel lblPrice;

	/**
	 * Create the frame.
	 */
	public BuyMedicine() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuyMedicine.class.getResource("/images/cnfic.png")));
		setTitle("Confirm To Buy");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 456, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 46, 83));
		panel.setBounds(53, 32, 320, 248);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BuyMedicine.class.getResource("/images/loginbg.png")));
		label.setBounds(0, 0, 450, 301);
		contentPane.add(label);
		
		
		
		JLabel buyMname = new JLabel("Medicine Name:");
		buyMname.setHorizontalAlignment(SwingConstants.RIGHT);
		buyMname.setForeground(Color.LIGHT_GRAY);
		buyMname.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		buyMname.setBounds(10, 35, 142, 36);
		panel.add(buyMname);
		
		JLabel quantity = new JLabel("Quantity:");
		quantity.setHorizontalAlignment(SwingConstants.TRAILING);
		quantity.setForeground(Color.LIGHT_GRAY);
		quantity.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		quantity.setBounds(10, 92, 142, 36);
		panel.add(quantity);
		
		JLabel price = new JLabel("Total Price:");
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		price.setForeground(Color.LIGHT_GRAY);
		price.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		price.setBounds(10, 153, 142, 36);
		panel.add(price);
		
		JButton btnConfirmToBuy = new JButton("CONFIRM TO BUY");
		btnConfirmToBuy.setBackground(new Color(0, 102, 255));
		btnConfirmToBuy.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		btnConfirmToBuy.setForeground(Color.WHITE);
		btnConfirmToBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertPurchase(lblMname,lblQty,lblPrice);
				dispose();
			}
		});
		btnConfirmToBuy.setBounds(77, 211, 178, 26);
		panel.add(btnConfirmToBuy);
		
		lblMname = new JLabel("mname");
		lblMname.setForeground(Color.WHITE);
		lblMname.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblMname.setBounds(178, 35, 121, 36);
		panel.add(lblMname);
		
		lblQty = new JLabel("qty");
		lblQty.setForeground(Color.WHITE);
		lblQty.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblQty.setBounds(178, 92, 121, 36);
		panel.add(lblQty);
		
		lblPrice = new JLabel("price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblPrice.setBounds(178, 153, 121, 36);
		panel.add(lblPrice);
	}

	protected void insertPurchase(JLabel name, JLabel qty, JLabel price) {
		ConnectionToDB c = new ConnectionToDB();
		c.makeConnection();
		java.util.Date d = new java.util.Date();
		java.sql.Date date = new java.sql.Date(d.getTime());
		c.insertPurchaseData(date, name.getText(), price.getText(), qty.getText(),u_id);
		c.closeConnection();
		JOptionPane.showMessageDialog(null, "You bought "+qty.getText()+" "+name.getText()+" tablets");
		
	}

	public void setQty(String name,int qty,double price,String id) {
		lblMname.setText(name);
		lblQty.setText(qty+"");
		double pr=price*qty;
		String p = String.format("%.2f", pr);
		
		lblPrice.setText(p);
		u_id=id;
	}
	public void setBuyMedicineReference(BuyMedicine u){
		bm=u;
	}

}
