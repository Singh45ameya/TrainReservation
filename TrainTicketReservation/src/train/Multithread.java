package train;


public class Multithread extends SignUp implements Runnable {
	
	Thread t;
	
	Multithread() {
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		sendmail(textField_2.getText(), 0, 0);
	}

}
