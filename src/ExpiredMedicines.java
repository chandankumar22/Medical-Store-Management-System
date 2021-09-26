import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class ExpiredMedicines extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpiredMedicines frame = new ExpiredMedicines();
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
	public ExpiredMedicines() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ExpiredMedicines.class.getResource("/images/expic.png")));
		setTitle("Expired Medicines");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 854, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.DARK_GRAY, Color.WHITE));
		panel.setBounds(0, 0, 838, 404);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblExpiredMedicines = new JLabel("EXPIRED MEDICINES");
		lblExpiredMedicines.setForeground(Color.WHITE);
		lblExpiredMedicines.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
		lblExpiredMedicines.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpiredMedicines.setBounds(246, 18, 355, 38);
		panel.add(lblExpiredMedicines);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 67, 818, 304);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ExpiredMedicines.class.getResource("/images/bgg.jpg")));
		label.setBounds(0, 0, 850, 414);
		panel.add(label);
	}
	
	public void setTable(ResultSet rs){
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
	}
}
