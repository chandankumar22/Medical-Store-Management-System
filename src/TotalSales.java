import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class TotalSales extends JFrame {

	private JPanel contentPane;
	JLabel lblTotalPurchase;
	JLabel labelmed_total ;
	private JLabel lblTotalSalePrice;
	private JLabel labelmed_price;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalSales frame = new TotalSales();
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
	public TotalSales() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TotalSales.class.getResource("/images/totpuric.png")));
		setResizable(false);
		setTitle("Sales");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 200, 533, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 46, 83));
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.DARK_GRAY));
		panel.setBounds(38, 51, 440, 205);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTotalMedicinesPurchased = new JLabel("Total Tablets Available:");
		lblTotalMedicinesPurchased.setForeground(Color.LIGHT_GRAY);
		lblTotalMedicinesPurchased.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTotalMedicinesPurchased.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalMedicinesPurchased.setBounds(10, 64, 219, 36);
		panel.add(lblTotalMedicinesPurchased);
		
		JLabel lblTotalPurchasePrice = new JLabel("Total Medicines Sold:");
		lblTotalPurchasePrice.setForeground(Color.LIGHT_GRAY);
		lblTotalPurchasePrice.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTotalPurchasePrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalPurchasePrice.setBounds(10, 111, 219, 36);
		panel.add(lblTotalPurchasePrice);
		
		labelmed_total = new JLabel("15000000000000");
		labelmed_total.setForeground(Color.WHITE);
		labelmed_total.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		labelmed_total.setHorizontalAlignment(SwingConstants.LEFT);
		labelmed_total.setBounds(239, 64, 156, 36);
		panel.add(labelmed_total);
		
		lblTotalPurchase = new JLabel("15000000000000");
		lblTotalPurchase.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblTotalPurchase.setForeground(Color.WHITE);
		lblTotalPurchase.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalPurchase.setBounds(239, 111, 156, 36);
		panel.add(lblTotalPurchase);
		
		lblTotalSalePrice = new JLabel("Total Sale Price:");
		lblTotalSalePrice.setForeground(Color.LIGHT_GRAY);
		lblTotalSalePrice.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		lblTotalSalePrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalSalePrice.setBounds(10, 158, 219, 36);
		panel.add(lblTotalSalePrice);
		
		labelmed_price = new JLabel("1500000000000");
		labelmed_price.setForeground(Color.WHITE);
		labelmed_price.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		labelmed_price.setHorizontalAlignment(SwingConstants.LEFT);
		labelmed_price.setBounds(239, 158, 156, 36);
		panel.add(labelmed_price);
		
		label_1 = new JLabel("Total Medicines Available:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		label_1.setBounds(10, 17, 219, 36);
		panel.add(label_1);
		
		label_2 = new JLabel("15000000000000");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		label_2.setBounds(239, 17, 156, 36);
		panel.add(label_2);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(TotalSales.class.getResource("/images/loginbg.png")));
		label.setBounds(0, 0, 527, 312);
		contentPane.add(label);
	}

	public void setValue(int sold_med, int aval_qty, double sold_price, int aval_tot) {
		labelmed_total.setText(aval_qty+"");
		lblTotalPurchase.setText(sold_med+"");
		String s = String.format("%.2f", sold_price);
		labelmed_price.setText(s);
		label_2.setText(aval_tot+"");
	}

}
