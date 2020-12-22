package train;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Faqs {

	public JFrame frame;
	private JTextField txtWhereWould;
	private JTextField txtThePnrWould;
	private JTextField txtWhatIsThe;
	private JTextField txtTheTicketsCan;
	private JTextField txtWhyAm;
	private JTextField txtAnsYouMay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Faqs window = new Faqs();
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
	public Faqs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		txtWhereWould = new JTextField();
		txtWhereWould.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtWhereWould.setText("1. Where would I find PNR?");
		txtWhereWould.setBounds(365, 186, 398, 22);
		frame.getContentPane().add(txtWhereWould);
		txtWhereWould.setColumns(10);
		
		txtThePnrWould = new JTextField();
		txtThePnrWould.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtThePnrWould.setText("The PNR would be sent in the email you receive as confirmation.");
		txtThePnrWould.setBounds(365, 221, 539, 22);
		frame.getContentPane().add(txtThePnrWould);
		txtThePnrWould.setColumns(10);
		
		txtWhatIsThe = new JTextField();
		txtWhatIsThe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtWhatIsThe.setText("2. What is the advance reservation period for booking tickets?");
		txtWhatIsThe.setBounds(365, 298, 520, 22);
		frame.getContentPane().add(txtWhatIsThe);
		txtWhatIsThe.setColumns(10);
		
		txtTheTicketsCan = new JTextField();
		txtTheTicketsCan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTheTicketsCan.setText("The tickets can be booked 4 months (120 days) in advance.");
		txtTheTicketsCan.setBounds(365, 333, 539, 22);
		frame.getContentPane().add(txtTheTicketsCan);
		txtTheTicketsCan.setColumns(10);
		
		txtWhyAm = new JTextField();
		txtWhyAm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtWhyAm.setText("3. Why am I getting errors while checking PNR?");
		txtWhyAm.setBounds(365, 402, 398, 22);
		frame.getContentPane().add(txtWhyAm);
		txtWhyAm.setColumns(10);
		
		txtAnsYouMay = new JTextField();
		txtAnsYouMay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAnsYouMay.setText("You may have entered the wrong PNR (please check the PNR and try again).");
		txtAnsYouMay.setBounds(363, 437, 650, 29);
		frame.getContentPane().add(txtAnsYouMay);
		txtAnsYouMay.setColumns(10);
		
		JLabel lblFaqs = new JLabel("FAQ's");
		lblFaqs.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFaqs.setBounds(518, 90, 83, 29);
		frame.getContentPane().add(lblFaqs);
		
		JButton button = new JButton("\uF0E7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage hp = new HomePage();
				hp.frame.setLocationRelativeTo(null);
				hp.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setFont(new Font("Wingdings", Font.PLAIN, 13));
		button.setBounds(93, 97, 81, 32);
		frame.getContentPane().add(button);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
