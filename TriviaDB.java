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
	
	public int getRandomNumber(){
		int randomnumberquestion= (int) (Math.random() * (numberofquestions - 1)) + 1;
		return randomnumberquestion;
	}
	
	private final String userName = "root";      //enter user name for DB connection
	private final String password = "cancan563"; //enter password for DB connection
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
 
	
	public String getQuestion(int id) {
		// Connect to MySQL
		Connection conn = null;
		try {conn = this.getConnection();}
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			}
		
		try {
		    PreparedStatement st = conn.prepareStatement("SELECT * " + "FROM questiontable " + "WHERE id="+id);
		    // ONEMLI NOT!!! : questiontable burda table'ımızın adı. Eğer DB'deki table ismi farklıysa aynı yap.
		    ResultSet rs=st.executeQuery();
		  
		    String arr = null;
		    while (rs.next()) {
		        String questn = rs.getString("question");
		        arr = questn.replace("\n", ",");
		    }return arr;
		    }
		
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect the table");
			e.printStackTrace();
			return ("failed to get a question from table");
			}
		
	}	
	
	
	public String getAnswerA(int id) {
		// Connect to MySQL
		Connection conn = null;
		try {conn = this.getConnection();}
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			}
		
		try {
		    PreparedStatement st = conn.prepareStatement("SELECT * " + "FROM questiontable " + "WHERE id="+id);
		    // ONEMLI NOT!!! : questiontable burda table'ımızın adı. Eğer DB'deki table ismi farklıysa aynı yap.
		    ResultSet rs=st.executeQuery();
		  
		    String arr = null;
		    while (rs.next()) {
		        String questn = rs.getString("A");
		        arr = questn.replace("\n", ",");
		    }return arr;
		    }
		
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect the table");
			e.printStackTrace();
			return ("failed to get answer A from table");
			}
		
	}	
	
	
	
	public String getAnswerB(int id) {
		// Connect to MySQL
		Connection conn = null;
		try {conn = this.getConnection();}
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			}
		
		try {
		    PreparedStatement st = conn.prepareStatement("SELECT * " + "FROM questiontable " + "WHERE id="+id);
		    // ONEMLI NOT!!! : questiontable burda table'ımızın adı. Eğer DB'deki table ismi farklıysa aynı yap.
		    ResultSet rs=st.executeQuery();
		  
		    String arr = null;
		    while (rs.next()) {
		        String questn = rs.getString("B");
		        arr = questn.replace("\n", ",");
		    }return arr;
		    }
		
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect the table");
			e.printStackTrace();
			return ("failed to get answer B from table");
			}
		
	}	
	
	
	
	public String getAnswerC(int id) {
		// Connect to MySQL
		Connection conn = null;
		try {conn = this.getConnection();}
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			}
		
		try {
		    PreparedStatement st = conn.prepareStatement("SELECT * " + "FROM questiontable " + "WHERE id="+id);
		    // ONEMLI NOT!!! : questiontable burda table'ımızın adı. Eğer DB'deki table ismi farklıysa aynı yap.
		    ResultSet rs=st.executeQuery();
		  
		    String arr = null;
		    while (rs.next()) {
		        String questn = rs.getString("C");
		        arr = questn.replace("\n", ",");
		    }return arr;
		    }
		
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect the table");
			e.printStackTrace();
			return ("failed to get answer C from table");
			}
		
	}
	
	
	
	public String getAnswerD(int id) {
		// Connect to MySQL
		Connection conn = null;
		try {conn = this.getConnection();}
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			}
		
		try {
		    PreparedStatement st = conn.prepareStatement("SELECT * " + "FROM questiontable " + "WHERE id="+id);
		    // ONEMLI NOT!!! : questiontable burda table'ımızın adı. Eğer DB'deki table ismi farklıysa aynı yap.
		    ResultSet rs=st.executeQuery();
		  
		    String arr = null;
		    while (rs.next()) {
		        String questn = rs.getString("D");
		        arr = questn.replace("\n", ",");
		    }return arr;
		    }
		
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect the table");
			e.printStackTrace();
			return ("failed to get answer D from table");
			}
		
	}	
	
	public String getcorrectAnswer(int id) {
		// Connect to MySQL
		Connection conn = null;
		try {conn = this.getConnection();}
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			}
		
		try {
		    PreparedStatement st = conn.prepareStatement("SELECT * " + "FROM questiontable " + "WHERE id="+id);
		    // ONEMLI NOT!!! : questiontable burda table'ımızın adı. Eğer DB'deki table ismi farklıysa aynı yap.
		    ResultSet rs=st.executeQuery();
		  
		    String arr = null;
		    while (rs.next()) {
		        String questn = rs.getString("answer");
		        arr = questn.replace("\n", ",");
		    }return arr;		    
		    }
		
		
		catch (SQLException e) {
			System.out.println("ERROR: Could not connect the table");
			e.printStackTrace();
			return ("failed to get the correct answer from table");
			}
		
	}	
	
}
