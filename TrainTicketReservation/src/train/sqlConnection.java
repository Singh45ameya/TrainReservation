package train;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class sqlConnection {
	static Connection con = null;
	public static Connection connectorDB() {
		String url = "jdbc:mysql://u57rmk37r7psm0ep:gtnOlWktCLlYbslI133P@bo3s3vrkruas6tvdvily-mysql.services.clever-cloud.com:3306/bo3s3vrkruas6tvdvily";
		String username = "u57rmk37r7psm0ep";
		String password = "gtnOlWktCLlYbslI133P";
		try {
			//Class.forName("org.sqlite.JDBC");
			//con = DriverManager.getConnection("jdbc:sqlite:src/Data.db");
			con = DriverManager.getConnection(url,username,password);
			return con;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	public static void main(String args[]) {
		connectorDB();
	}
}