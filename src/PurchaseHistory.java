import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class PurchaseHistory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static java.sql.Date date;
	static String mname;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseHistory frame = new PurchaseHistory();
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
	public PurchaseHistory() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PurchaseHistory.class.getResource("/images/phic.png")));
		setResizable(false);
		setTitle("Purchase History");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 592, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 566, 349);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("PURCHASE HISTORY");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(112, 11, 337, 43);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(PurchaseHistory.class.getResource("/images/bgg.jpg")));
		label.setBounds(0, 0, 586, 435);
		contentPane.add(label);
	}
	
	public void showPurchaseHistory(String id){
		String query = "Select m_name,p_quantity,p_price,p_date from purchase where u_id='"+id+"'";
		ConnectionToDB ctb= new ConnectionToDB();
		ctb.makeConnection();
		ResultSet rs = ctb.queryExecution(query);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		table.setCellSelectionEnabled(false);
		System.out.println("purchase history"+query);
		/*try {
			if(rs.next()){
			}
			else
				JOptionPane.showMessageDialog(null, "YOU HAVEN'T BOUGHT ANY MEDICINE");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "YOU HAVEN'T BOUGHT ANY MEDICINE");
			e.printStackTrace();
		}*/
		
		ctb.closeConnection();
	}
	/*public static ArrayList showLastPurchaseDetails(){
		ArrayList l = new ArrayList();
		l.add(mname);l.add(date);
		return l;
		
	}*/
}
