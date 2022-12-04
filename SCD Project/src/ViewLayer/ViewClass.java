package ViewLayer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import BusinessLayer.BusinessClass;
import TransferObjects.DatabaseData;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class ViewClass extends JFrame 
{
	private JPanel contentPane;
	private JTextField txtMultilingualDictionary;
	private JTextField txtImportFiles;
	private JTable table;

	/**
	 * @author usama
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewClass frame = new ViewClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @author usama
	 * Create the frame.
	 */
	public ViewClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setForeground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(0, 0, 434, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtMultilingualDictionary = new JTextField();
		txtMultilingualDictionary.setForeground(new Color(255, 255, 255));
		txtMultilingualDictionary.setBackground(new Color(0, 102, 153));
		txtMultilingualDictionary.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtMultilingualDictionary.setHorizontalAlignment(SwingConstants.CENTER);
		txtMultilingualDictionary.setText("MULTILINGUAL DICTIONARY");
		txtMultilingualDictionary.setBounds(0, 0, 434, 46);
		panel.add(txtMultilingualDictionary);
		txtMultilingualDictionary.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(0, 45, 434, 216);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtImportFiles = new JTextField();
		txtImportFiles.setForeground(new Color(30, 144, 255));
		txtImportFiles.setBackground(new Color(240, 255, 255));
		txtImportFiles.setHorizontalAlignment(SwingConstants.CENTER);
		txtImportFiles.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtImportFiles.setText("IMPORT FILES");
		txtImportFiles.setBounds(0, 0, 126, 26);
		panel_1.add(txtImportFiles);
		txtImportFiles.setColumns(10);
		
		JButton btnNewButton = new JButton("SELECT");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				JFileChooser Chooser = new JFileChooser();
				int response=Chooser.showOpenDialog(null);
				if(response==JFileChooser.APPROVE_OPTION) 
				{
					File file =new File (Chooser.getSelectedFile().getAbsolutePath());
					File file2 = file;
					String chosenFile = file2.toString();
					BusinessClass obj = new BusinessClass();
					try {
						obj.setFilePath(chosenFile);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		}
		);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(10, 37, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnFaeel = new JButton("FAEEL");
		btnFaeel.addActionListener(new ActionListener() {
			String str = "faeel";
			public void actionPerformed(ActionEvent e) {
				try {
					jTable(str);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFaeel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnFaeel.setBounds(10, 99, 89, 23);
		panel_1.add(btnFaeel);
		
		JButton btnMasdar = new JButton("MASDAR");
		btnMasdar.addActionListener(new ActionListener() {
			String str = "masdar";
			public void actionPerformed(ActionEvent e) {
				try {
					jTable(str);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnMasdar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnMasdar.setBounds(10, 133, 89, 23);
		panel_1.add(btnMasdar);
		
		JButton btnMafoul = new JButton("MAFOUL");
		btnMafoul.addActionListener(new ActionListener() {
			String str = "mafoul";
			public void actionPerformed(ActionEvent e) {
				try {
					jTable(str);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnMafoul.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnMafoul.setBounds(10, 167, 89, 23);
		panel_1.add(btnMafoul);
		
		table = new JTable();
		table.setBounds(136, 0, 298, 216);
		panel_1.add(table);
	}
	
	/**
	 * @author usama
	 * @param str
	 * @throws SQLException
	 */
	public void jTable(String str) throws SQLException
	{
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		String [] col  = new String [8];
	    ArrayList<DatabaseData> list = BusinessClass.getRow(str);
	    String [] data = new String [8];
	    data[0] = "rakam";
	    data[1] = "mashkool";
	    data[2] = "sinf";
	    data[3] = "asal";
	    data[4] = "jins";
	    data[5] = "adad";
	    data[6] = "mashkool_vocalize";
	    data[7] = "asal_vocalize";
	    
	    model.setColumnIdentifiers(data);
		for (int i = 0; i < list.size(); i++) 
		{
			col[0] = list.get(i).getRakam();
			col[1] = list.get(i).getMashkool();
			col[2] = list.get(i).getSinf();
			col[3] = list.get(i).getAsal();
			col[4] = list.get(i).getJins();
			col[5] = list.get(i).getAdad();
			col[6] = list.get(i).getMashkool_vocalize();
			col[7] = list.get(i).getAsal_vocalize();
			model.addRow(col);
		}
	}
}
