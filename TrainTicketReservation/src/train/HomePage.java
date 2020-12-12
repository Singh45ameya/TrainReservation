package train;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends SignUp {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	//Connection con = null;
	ResultSet rs= null;
	PreparedStatement ps = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
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
	public HomePage() {
		//con = sqlConnection.connectorDB();
		initialize();
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
	
		Image img = new ImageIcon(this.getClass().getResource("/homelogo.png")).getImage();
		JLabel label = new JLabel();
		label.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
		label.setIcon( new ImageIcon(img));
		label.setBounds(0, 0, 225, 225);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBorder(new LineBorder(Color.RED, 2, true));
		label_1.setIcon(new ImageIcon(img));
		label_1.setBounds(957, 0, 225, 225);
		frame.getContentPane().add(label_1);
		
		JTextArea txtrWelcomeToIndian = new JTextArea();
		txtrWelcomeToIndian.setForeground(Color.WHITE);
		txtrWelcomeToIndian.setCaretColor(new Color(0, 0, 0));
		txtrWelcomeToIndian.setBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, Color.YELLOW, new Color(255, 0, 0), new Color(255, 0, 0)));
		txtrWelcomeToIndian.setBackground(SystemColor.textHighlight);
		txtrWelcomeToIndian.setEditable(false);
		txtrWelcomeToIndian.setWrapStyleWord(true);
		txtrWelcomeToIndian.setFont(new Font("Myanmar Text", Font.BOLD, 36));
		txtrWelcomeToIndian.setLineWrap(true);
		txtrWelcomeToIndian.setText("WELCOME TO INDIAN RAILWAYS");
		txtrWelcomeToIndian.setBounds(441, 51, 343, 123);
		frame.getContentPane().add(txtrWelcomeToIndian);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.setBackground(SystemColor.textHighlight);
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "LOGIN", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 69, 0)));
		panel.setBounds(361, 315, 474, 273);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("SimSun", Font.PLAIN, 16));
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (textField.getText().equalsIgnoreCase("Enter Your Username")) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
		        }
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if (textField.getText().isEmpty()) {
					textField.setText("Enter Your Username");
					textField.setForeground(Color.GRAY);
		        }
			}
		});
		textField.setForeground(Color.GRAY);
		textField.setText("Enter Your Username");
		textField.setBounds(137, 35, 188, 42);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent arg0) {
				if (passwordField.getText().isEmpty()) {
					passwordField.setText("Enter Your Password");
					passwordField.setEchoChar('\u0000');
					passwordField.setForeground(Color.GRAY);
		        }
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent arg0) {
				if (passwordField.getText().equalsIgnoreCase("Enter Your Password")) {
					passwordField.setText("");
					passwordField.setEchoChar('*');
					passwordField.setForeground(Color.BLACK);
		        }
			}
		});
		passwordField.setForeground(Color.GRAY);
		passwordField.setFont(new Font("SimSun", Font.PLAIN, 16));
		passwordField.setText("Enter Your Password");
		passwordField.setBounds(137, 100, 188, 42);
		passwordField.setEchoChar('\u0000');
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(textField.getText().compareTo("Enter Your Username") != 0 && passwordField.getText().compareTo("Enter Your Password") !=0) {
						String query = "SELECT password FROM login WHERE username = ? ";
						ps = con.prepareStatement(query);
						ps.setString(1, textField.getText());
						String s = passwordField.getText().toString();
						rs = ps.executeQuery();
						rs.next();
						if(encrypt(s).equals(rs.getString("password"))) {
							Dashboard db = new Dashboard(textField.getText().toString());
							db.frame.setLocationRelativeTo(null);
							db.frame.setVisible(true);
							frame.dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Fill in all the fields or wrong credentials");
							new HomePage().frame.setVisible(true);
							frame.dispose();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Fill in all the fields");
						HomePage hp = new HomePage();
						hp.frame.setLocationRelativeTo(null);
						hp.frame.setVisible(true);
						frame.dispose();
					}
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Username doesnt exists");
					HomePage hp = new HomePage();
					hp.frame.setLocationRelativeTo(null);
					hp.frame.setVisible(true);
					frame.dispose();
					
				} finally {
					try { rs.close(); } catch (Exception e) { /* ignored */ }
					try { ps.close(); } catch (Exception e) { /* ignored */ }
					try { con.close(); } catch (Exception e) { /* ignored */ }
				}
			}
		});
		btnNewButton.setBorder(UIManager.getBorder("PasswordField.border"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(137, 167, 188, 35);
		panel.add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp sp = new SignUp();
				sp.frame.setLocationRelativeTo(null);
				sp.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		btnSignUp.setBackground(UIManager.getColor("Button.background"));
		btnSignUp.setBounds(137, 215, 188, 35);
		panel.add(btnSignUp);
		
		
		/*
		 frame.addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		        super.windowClosing(e);
		     
		    }
		});
		*/
	}
}
