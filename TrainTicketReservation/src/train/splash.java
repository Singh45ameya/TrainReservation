package train;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;


public class Splash extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JProgressBar progressBar;
	public JLabel lblWelcomeToStudent;
	public JLabel label1;
	public JLabel lblDesignedBySree;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Splash() {
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 527);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWelcomeToStudent = new JLabel();
		lblWelcomeToStudent.setFont(new Font("Baskerville Old Face", Font.BOLD, 24));
		lblWelcomeToStudent.setBounds(236, 209, 384, 70);
		contentPane.add(lblWelcomeToStudent);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(12, 330, 817, 45);
		contentPane.add(progressBar);
		
		
		label1 = new JLabel("...");
		label1.setBackground(Color.RED);
		label1.setFont(new Font("Tahoma", Font.BOLD, 24));
		label1.setBounds(394, 292, 32, 38);
		contentPane.add(label1);
		
		lblDesignedBySree = new JLabel("Designed by - ");
		lblDesignedBySree.setForeground(Color.WHITE);
		lblDesignedBySree.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
		lblDesignedBySree.setBounds(497, 412, 308, 38);
		contentPane.add(lblDesignedBySree);
		
		JLabel lblSoumyaKSoumya = new JLabel("Soumya k, Soumya s, Sree chand, Sourabh G");
		lblSoumyaKSoumya.setForeground(Color.WHITE);
		lblSoumyaKSoumya.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
		lblSoumyaKSoumya.setBounds(153, 464, 452, 38);
		contentPane.add(lblSoumyaKSoumya);
		
	}
}
