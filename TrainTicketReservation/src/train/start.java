package train;

import java.awt.Color;


public class Start {
	public static void main(String[] args ) {
		Color k;
		String s = "TRAIN TICKET RESERVATION";
		Splash sp = new Splash();
		sp.setLocationRelativeTo(null);
		sp.setVisible(true);
		
		for(int i=0;i<101;i++) {
			k=new Color(255,i+20,i+40);
			try {
				Thread.sleep(30);
				sp.progressBar.setValue(i);
				if(i<24)
					sp.lblWelcomeToStudent.setText(sp.lblWelcomeToStudent.getText() + s.charAt(i));
				sp.lblWelcomeToStudent.setForeground(k);
				sp.label1.setText(Integer.toString(i));
				sp.lblDesignedBySree.setForeground(k);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
			if(i==100) 
				sp.setVisible(false); 
		}
		HomePage hp = new HomePage();
		hp.frame.setLocationRelativeTo(null);
		hp.frame.setVisible(true);
	}
}
