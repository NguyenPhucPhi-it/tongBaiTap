package Database;
import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectSQL {
	private Connection conn = null;
	private static ConnectSQL instance = null;
	
	private ConnectSQL() {
		try{ 
			   String userName = "root";
			   String password = "";
			   String DatabaseName = "userdb";
			   String url = "jdbc:mysql://localhost/" + DatabaseName;
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   this.conn = DriverManager.getConnection(url, userName, password);
			   System.out.println("Đã kết nối tới SQL");
		} catch (Exception e) {
			// TODO: handle exception
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static ConnectSQL getInstance() {
		if (instance == null) {
			instance = new ConnectSQL();
		}
		return instance;
	}
	
	public static Connection getConnected() {
	    instance = getInstance();
	    try {
	        if (instance.getConn() == null || instance.getConn().isClosed()) {
	            // Kết nối đã đóng, mở lại kết nối
	            instance = new ConnectSQL();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return instance.getConn();
	}

	public Connection getConn() {
		return conn;
	}

}