package TriviaQuiz_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TriviaDB {
	int numberofquestions=3;  //1 fazla yazılacak random number icin xd
	
	private final String userName = "root";      //enter user name for DB connection
	private final String password = "sifrenigirxd"; //enter password for DB connection
	private final String serverName = "localhost";
	private final int portNumber = 3306;
	private final String dbName = "test";
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);
		conn = DriverManager.getConnection("jdbc:mysql://"+ this.serverName + ":" + this.portNumber + "/" + this.dbName,connectionProps);
		return conn;
	}
 
	
	public String getQuestion() {
		// Connect to MySQL
		Connection conn = null;
		try {conn = this.getConnection();
			System.out.println("Connected to database");}
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			}
		
		
		try {
			int randomnumberquestion= (int) (Math.random() * (numberofquestions - 1)) + 1;
		    PreparedStatement st = conn.prepareStatement("SELECT * " + "FROM questiontable " + "WHERE id="+randomnumberquestion);
		    // ONEMLI NOT!!! : questiontable burda table'ımızın adı. Eğer DB'deki table ismi farklıysa aynı yap.
		    ResultSet rs=st.executeQuery();
		  
		    String arr = null;
		    while (rs.next()) {
		        String questn = rs.getString("question");
		        arr = questn.replace("\n", ",");
		    }
			System.out.println("Connected to the table");
		    return arr;
		    }
		
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect the table");
			e.printStackTrace();
			return ("failed to get a question from table");
			}
		
	}	
	
}
