package train;

import java.awt.*;

import javax.swing.*;

import javax.swing.border.BevelBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import java.text.DateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;

public class Dashboard extends SignUp {

	public JFrame frame;
	private JTextField txtSree;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private String username;
	
	Connection con = null;
	ResultSet rs= null;
	PreparedStatement ps = null,ps2=null;
	
	Timer tm;
    int x = 0;
    //Images Path In Array
    String[] list = {
                      "/Golden.png",//0
                      "/maharaja.png",//1
                     
                    };

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		con = sqlConnection.connectorDB();
		initialize();
	}
	
	public Dashboard(String s) {
		con = sqlConnection.connectorDB();
		initialize();
		lblNewLabel.setText(s);
		username = s;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 0), new Color(255, 255, 0), Color.YELLOW, Color.YELLOW));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.requestFocus();
			}
		});
		panel.setBackground(new Color(244, 164, 96));
		panel.setBounds(12, 13, 331, 727);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 0, 0), new Color(255, 0, 0), new Color(255, 0, 0), new Color(255, 0, 0)));
		panel_1.setBackground(new Color(255, 99, 71));
		panel_1.setBounds(355, 13, 821, 727);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(48, 57, 700, 600);
		SetImageSize(1);
        //set a timer
		tm = new Timer(3000,new ActionListener() {

		     @Override
		     public void actionPerformed(ActionEvent e) {
		         SetImageSize(x);
		         x += 1;
		         if(x >= list.length )
		             x = 0; 
		     }
		 });
		panel_1.add(lblNewLabel_1);
		tm.start();
		
		
		
		
		Image img2 = new ImageIcon(this.getClass().getResource("/logout1.png")).getImage();
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage hp = new HomePage();
				hp.frame.setLocationRelativeTo(null);
				hp.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Imprint MT Shadow", Font.BOLD, 18));
		btnNewButton.setIcon(new ImageIcon(img2));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(76, 647, 179, 55);
		panel.add(btnNewButton);
		
		Image img = new ImageIcon(this.getClass().getResource("/bookticket.png")).getImage();
		
		JButton btnNewButton_1 = new JButton("Book Ticket");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				panelcomp();
				panel_1.repaint();
				panel_1.revalidate();
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setFont(new Font("Imprint MT Shadow", Font.BOLD, 18));
		btnNewButton_1.setIcon(new ImageIcon(img));
		btnNewButton_1.setForeground(SystemColor.controlText);
		btnNewButton_1.setBackground(new Color(255, 255, 102));
		btnNewButton_1.setBounds(12, 140, 307, 55);
		panel.add(btnNewButton_1);
		
		
		Image img1 = new ImageIcon(this.getClass().getResource("/cancelticket.png")).getImage();
		
		JButton btnCancelTicket = new JButton("Cancel/View Ticket");
		btnCancelTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				panelviews();
				panel_1.repaint();
				panel_1.revalidate();
			}
		});
		btnCancelTicket.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelTicket.setForeground(Color.BLACK);
		btnCancelTicket.setFont(new Font("Imprint MT Shadow", Font.BOLD, 18));
		btnCancelTicket.setIcon(new ImageIcon(img1));
		btnCancelTicket.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCancelTicket.setBackground(new Color(255, 255, 102));
		btnCancelTicket.setBounds(12, 247, 307, 55);
		panel.add(btnCancelTicket);
		
		Image img3 = new ImageIcon(this.getClass().getResource("/view.png")).getImage();
		
		JButton btnProfileSettings = new JButton("Profile Settings");
		btnProfileSettings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProfileSettings.setForeground(Color.BLACK);
		btnProfileSettings.setFont(new Font("Imprint MT Shadow", Font.BOLD, 18));
		btnProfileSettings.setIcon(new ImageIcon(img3));
		btnProfileSettings.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnProfileSettings.setBackground(new Color(255, 255, 102));
		btnProfileSettings.setBounds(12, 351, 307, 55);
		panel.add(btnProfileSettings);
		
		lblNewLabel = new JLabel("",JLabel.CENTER);
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 18));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sreechand R\\Downloads\\user.png"));
		lblNewLabel.setBounds(12, 47, 307, 55);
		panel.add(lblNewLabel);
		
		//panelcomp();
		//panelviews();
	}
	
	
	public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(this.getClass().getResource(list[i]));
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        lblNewLabel_1.setIcon(newImc);
    }

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void panelcomp () {
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(95, 197, 56, 16);
		panel_1.add(lblName);
		
		txtSree = new JTextField();
		txtSree.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		txtSree.setBounds(145, 194, 144, 22);
		txtSree.setBackground(Color.WHITE);
		panel_1.add(txtSree);
		txtSree.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAge.setBounds(315, 188, 40, 31);
		panel_1.add(lblAge);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(364, 194, 56, 22);
		panel_1.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		comboBox.setToolTipText("Select Gender");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female", "Other"}));
		comboBox.setBounds(555, 194, 88, 22);
		panel_1.add(comboBox);
		
		AutoCompleteDecorator.decorate(comboBox);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFrom.setBounds(95, 285, 56, 16);
		panel_1.add(lblFrom);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(145, 282, 144, 22);
		panel_1.add(textField_3);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTo.setBounds(326, 285, 29, 16);
		panel_1.add(lblTo);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(364, 284, 144, 22);
		panel_1.add(textField_4);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		dateChooser.setBounds(145, 352, 144, 31);
		panel_1.add(dateChooser);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(95, 352, 47, 31);
		panel_1.add(lblDate);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "2S Sitting", "CC ", "AC 3-Tier"}));
		comboBox_1.setToolTipText("Select Gender");
		comboBox_1.setBounds(364, 361, 144, 22);
		panel_1.add(comboBox_1);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClass.setBounds(315, 352, 47, 31);
		panel_1.add(lblClass);
		
		JButton btnNewButton_2 = new JButton("Book");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(isValid(txtSree.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText(),DateFormat.getDateInstance().format(dateChooser.getDate())) == 5
							&& comboBox.getSelectedIndex()!=0 && comboBox_1.getSelectedIndex() != 0) {
					String query = "Insert into ticket values(?,?,?,?,?,?,?,?)";
					String query2 = "Select email from login where username = ?";
					ps = con.prepareStatement(query);
					int rand1 = (int)(Math.random() * (999999999 - 100000000 + 1) + 100000000);
					ps.setInt(1, rand1);
					ps.setString(2, txtSree.getText().toString());
					ps.setString(3, textField_2.getText().toString());
					ps.setString(4,comboBox.getSelectedItem().toString());
					ps.setString(5, textField_3.getText().toString());
					ps.setString(6, textField_4.getText().toString());
					ps.setString(7, DateFormat.getDateInstance().format(dateChooser.getDate()));
					ps.setString(8, comboBox_1.getSelectedItem().toString());
					ps.executeUpdate();
					ps2 = con.prepareStatement(query2);
					ps2.setString(1, username);
					rs = ps2.executeQuery();
					rs.next();
					sendmail(rs.getString("email"),1, rand1);
					JOptionPane.showMessageDialog(null, "Successfully Booked with PNR "+rand1);
					Dashboard db = new Dashboard(username);
					db.frame.setLocationRelativeTo(null);
					db.frame.setVisible(true);
					frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "fill in all the fields appropiately");
						Dashboard db = new Dashboard(username);
						db.frame.setLocationRelativeTo(null);
						db.frame.setVisible(true);
						frame.dispose();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter date in DD MMM, YYYY format");
					Dashboard db = new Dashboard(username);
					db.frame.setLocationRelativeTo(null);
					db.frame.setVisible(true);
					frame.dispose();
					
				} finally {
					try { rs.close(); } catch (Exception ex) { /* ignored */ }
					try { ps.close(); } catch (Exception ex) { /* ignored */ }
					try { ps2.close(); } catch (Exception ex) { /* ignored */ }
					try { con.close(); } catch (Exception ex) { /* ignored */ }
				}
			}
		});
		btnNewButton_2.setFont(new Font("High Tower Text", Font.PLAIN, 18));
		btnNewButton_2.setBounds(345, 451, 116, 51);
		panel_1.add(btnNewButton_2);
		
	}
	
	
	private  void panelviews() {
		JLabel label = new JLabel("Name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(84, 160, 56, 16);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(134, 157, 144, 22);
		panel_1.add(textField);
		
		JLabel label_1 = new JLabel("Age");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(304, 151, 40, 31);
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(353, 157, 56, 22);
		panel_1.add(textField_1);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(353, 247, 144, 22);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBackground(Color.WHITE);
		textField_6.setBounds(134, 245, 144, 22);
		panel_1.add(textField_6);
		
		JLabel label_3 = new JLabel("To");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(315, 248, 29, 16);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("From");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBounds(84, 248, 56, 16);
		panel_1.add(label_4);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int input  = JOptionPane.showConfirmDialog(null, "Confirm your Deletion","Confirmation",JOptionPane.YES_NO_OPTION);
				try {
					con = sqlConnection.connectorDB();
					if(input == 0) {
					String query  = "Delete from ticket where Id = ?";
					String query2 = "Select email from login where username = ?";
					ps = con.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(textField_10.getText()));
					ps2 = con.prepareStatement(query2);
					ps2.setString(1, username);
					rs = ps2.executeQuery();
					rs.next();
					sendmail(rs.getString("email"),2,Integer.parseInt(textField_10.getText()));
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
					Dashboard db = new Dashboard(username);
					db.frame.setLocationRelativeTo(null);
					db.frame.setVisible(true);
					frame.dispose();
					}
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "The Ticket doesnt exists");
					e.printStackTrace();
					Dashboard db = new Dashboard(username);
					db.frame.setLocationRelativeTo(null);
					db.frame.setVisible(true);
					frame.dispose();
					
				} finally {
					try { rs.close(); } catch (Exception ex) { /* ignored */ }
					try { ps.close(); } catch (Exception ex) { /* ignored */ }
					try { ps2.close(); } catch (Exception ex) { /* ignored */ }
					try { con.close(); } catch (Exception ex) { /* ignored */ }
				}
			}
		});
		btnDelete.setFont(new Font("High Tower Text", Font.PLAIN, 18));
		btnDelete.setBounds(334, 414, 116, 51);
		panel_1.add(btnDelete);
		
		JLabel label_2 = new JLabel("Gender");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(498, 160, 56, 16);
		panel_1.add(label_2);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBackground(Color.WHITE);
		textField_7.setBounds(570, 157, 122, 22);
		panel_1.add(textField_7);
		
		JLabel lblDate_1 = new JLabel("Date");
		lblDate_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate_1.setBounds(84, 346, 56, 16);
		panel_1.add(lblDate_1);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		textField_8.setColumns(10);
		textField_8.setBackground(Color.WHITE);
		textField_8.setBounds(134, 343, 144, 22);
		panel_1.add(textField_8);
		
		JLabel lblClass_1 = new JLabel("Class");
		lblClass_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClass_1.setBounds(303, 343, 56, 16);
		panel_1.add(lblClass_1);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		textField_9.setColumns(10);
		textField_9.setBackground(Color.WHITE);
		textField_9.setBounds(353, 340, 144, 22);
		panel_1.add(textField_9);
		
		JLabel lblPnrNumber = new JLabel("PNR Number");
		lblPnrNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPnrNumber.setBounds(84, 55, 101, 16);
		panel_1.add(lblPnrNumber);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		textField_10.setEditable(true);
		textField_10.setColumns(10);
		textField_10.setBackground(Color.WHITE);
		textField_10.setBounds(197, 54, 144, 22);
		panel_1.add(textField_10);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(! textField_10.getText().isEmpty() && textField_10.getText().length() == 9) {
					String query = "select * from ticket where Id = ?";
					ps = con.prepareStatement(query);
					ps.setInt(1,Integer.parseInt(textField_10.getText().toString()));
					rs = ps.executeQuery();
					rs.next();
					
					textField.setText(rs.getString("Name"));
					textField_1.setText(rs.getString("Age"));
					textField_7.setText(rs.getString("Gender"));
					textField_6.setText(rs.getString("From"));
					textField_5.setText(rs.getString("To"));
					textField_8.setText(rs.getString("Date"));
					textField_9.setText(rs.getString("Class"));
					}
					else {
						JOptionPane.showMessageDialog(null, "PNR should be of 9 Digits");
						Dashboard db = new Dashboard(username);
						db.frame.setLocationRelativeTo(null);
						db.frame.setVisible(true);
						frame.dispose();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ticket with PNR " + textField_10.getText() + " doesnt exists");
					Dashboard db = new Dashboard(username);
					db.frame.setLocationRelativeTo(null);
					db.frame.setVisible(true);
					frame.dispose();
				} finally {
					try { rs.close(); } catch (Exception ex) { /* ignored */ }
					try { ps.close(); } catch (Exception ex) { /* ignored */ }
					try { con.close(); } catch (Exception ex) { /* ignored */ }
				}
			}
		});
		btnNewButton_3.setBounds(353, 53, 97, 25);
		panel_1.add(btnNewButton_3);
	}
	
	
	public static int isValid(String name, String age, String from, String to, String date)  //Form validation
    { 
		int n=0;
        String regex = "[0-9]+"; 
        String regex1 = "[aA-zZ ]+";
        String regex2 = "^\\d{1,2} [a-zA-Z]{3}, \\d{4}$";
        
        Pattern p = Pattern.compile(regex); 
        Matcher m = p.matcher(age); 
        if(m.matches())
        	n += 1;
   
         p = Pattern.compile(regex1); 
         m = p.matcher(name); 
         if(m.matches())
         	n += 1;
     
         m = p.matcher(from); 
         if(m.matches())
         	n += 1;
     
         m = p.matcher(to); 
         if(m.matches())
         	n += 1;
 
         p = Pattern.compile(regex2); 
         m = p.matcher(date); 
         if(m.matches())
         	n += 1;
   
        return n; 
    } 
}
