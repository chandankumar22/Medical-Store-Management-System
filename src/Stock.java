import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class Stock extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
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
	public Stock() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Stock.class.getResource("/images/stckic.png")));
		setResizable(false);
		setTitle("Stock");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 200, 687, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.DARK_GRAY, Color.WHITE));
		panel.setBounds(10, 11, 818, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblExpiredMedicines = new JLabel("STOCK WISE MEDICINES LIST");
		lblExpiredMedicines.setForeground(Color.WHITE);
		lblExpiredMedicines.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
		lblExpiredMedicines.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpiredMedicines.setBounds(94, 18, 487, 38);
		panel.add(lblExpiredMedicines);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 67, 651, 304);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Stock.class.getResource("/images/bgg.jpg")));
		label.setBounds(0, 0, 671, 400);
		panel.add(label);
	}
	
	public void setTable(ResultSet rs){
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
	}

}
