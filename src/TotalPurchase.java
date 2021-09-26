import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class TotalPurchase extends JFrame {

	private JPanel contentPane;
	JLabel lblTotalPurchase;
	JLabel label ;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalPurchase frame = new TotalPurchase();
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
	public TotalPurchase() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TotalPurchase.class.getResource("/images/totpuric.png")));
		setResizable(false);
		setTitle("Purchases");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 501, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 46, 83));
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.DARK_GRAY));
		panel.setBounds(29, 80, 423, 255);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTotalMedicinesPurchased = new JLabel("Total Medicines Purchased:");
		lblTotalMedicinesPurchased.setForeground(Color.LIGHT_GRAY);
		lblTotalMedicinesPurchased.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTotalMedicinesPurchased.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalMedicinesPurchased.setBounds(10, 61, 233, 36);
		panel.add(lblTotalMedicinesPurchased);
		
		JLabel lblTotalPurchasePrice = new JLabel("Total Purchase Price:");
		lblTotalPurchasePrice.setForeground(Color.LIGHT_GRAY);
		lblTotalPurchasePrice.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTotalPurchasePrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalPurchasePrice.setBounds(10, 145, 233, 36);
		panel.add(lblTotalPurchasePrice);
		
		label = new JLabel("15000000000000");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(253, 63, 160, 36);
		panel.add(label);
		
		lblTotalPurchase = new JLabel("15000000000000");
		lblTotalPurchase.setForeground(Color.WHITE);
		lblTotalPurchase.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblTotalPurchase.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalPurchase.setBounds(253, 147, 160, 36);
		panel.add(lblTotalPurchase);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TotalPurchase.class.getResource("/images/loginbg.png")));
		label_1.setBounds(0, 0, 495, 380);
		contentPane.add(label_1);
	}

	public void setValue(double puchase_price, int puchase_qty) {
		label.setText(puchase_qty+"");
		lblTotalPurchase.setText(puchase_price+"");
}

}
