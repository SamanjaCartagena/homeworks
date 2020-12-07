package sqlProject;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlTests {
	String url = "jdbc:mysql://127.0.0.1:3306/sakila";
	String userId = "root";
	String password = "root";
	Connection connection = null;

	@Test
	public void canConnectToDatabase() throws SQLException {
		try {
			connection = DriverManager.getConnection(url, userId, password);

			if (connection == null) {
				throw new RuntimeException((new Exception("Failed to make connection!")));
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(new Exception(String.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage())));
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		} 
		finally {
			if(connection != null ) {
				connection.close();
			}
		}
	}
	
	//Number1
	//This works properly and you can see the output at the console
	//As you can see I have copied and pasted some of your codes on github just
// practice and test the right way of doing it but I am not using your codes I am using mine
   @Test
	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String username="root";
		String password="root";
		String url ="jdbc:mysql://localhost:3306/sakila";
		Connection con=DriverManager.getConnection(url, username,password);
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=stmt.executeQuery("select * from city order by city desc limit 10");
		
		 rs.last();
		 
		 int rows=rs.getRow();
		 System.out.println("Number of rows "+rows);
		 
		 ResultSetMetaData rsmd = rs.getMetaData();
		 int cols = rsmd.getColumnCount();
		 System.out.println("Number of columns "+cols);
		  int i=0;
		  rs.beforeFirst();
		 String data[][] = new String[rows][cols];
		 while(rs.next()) {
			 for(int j=0;j<cols;j++) {
				data[i][j]= rs.getString(j+1);
				System.out.println(""+data[i][j]);
			 }
			 i++;
		 }
	}
 //Number 7
 	@Test
 	
 	public void connect3() throws ClassNotFoundException, SQLException {
 		Class.forName("com.mysql.cj.jdbc.Driver");
 		
 		String username="root";
 		String password="root";
 		String url ="jdbc:mysql://localhost:3306/sakila";
 		Connection con=DriverManager.getConnection(url, username,password);
 		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
 		stmt.executeQuery("set @filmidAlien= 15");
 				ResultSet rs=stmt.executeQuery("select inventory_id from inventory where film_id like @filmidAlien && store_id like 2");
 		 rs.last();
 		 
 		 int rows=rs.getRow();
 		 System.out.println("Number of rows "+rows);
 		 
 		 ResultSetMetaData rsmd = rs.getMetaData();
 		 int cols = rsmd.getColumnCount();
 		 System.out.println("Number of columns "+cols);
 		  int i=0;
 		  rs.beforeFirst();
 		 String data[][] = new String[rows][cols];
 		 while(rs.next()) {
 			 for(int j=0;j<cols;j++) {
 				data[i][j]= rs.getString(j+1);
 				System.out.println(""+data[i][j]);
 			 }
 			 i++;
 		 }
 	}
 	
 	//Number 8
 	//Unfortunately I have already altered the table and removed foreign key constraints 
 	// I am now aware that I was not supposed to do that but now I cannot fix this
 	// I have tried altering back the table to the way it was
 	
   @Test
   public void connect4() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String username="root";
		String password="root";
		String url ="jdbc:mysql://localhost:3306/sakila";
		Connection con=DriverManager.getConnection(url, username,password);
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stmt.executeUpdate("Start Transaction");
			stmt.executeUpdate("insert into store(manager_staff_id,address_id) values(19,19)");
			stmt.executeUpdate("commit");

			ResultSet rs= stmt.executeQuery("select * from store");

			
			rs.last();
		 
		 int rows=rs.getRow();
		 System.out.println("Number of rows "+rows);
		 
		 ResultSetMetaData rsmd = rs.getMetaData();
		 int cols = rsmd.getColumnCount();
		 System.out.println("Number of columns "+cols);
		  int i=0;
		  rs.beforeFirst();
		 String data[][] = new String[rows][cols];
		 while(rs.next()) {
			 for(int j=0;j<cols;j++) {
				data[i][j]= rs.getString(j+1);
				System.out.println(""+data[i][j]);
			 }
			 i++;
		 }
	}
 //Number 9
   //Here I have tried to compare the time in Assert statement
   //but the assert statement doesnt work
 	@Test
 	public void connect5() throws ClassNotFoundException, SQLException {
 		Class.forName("com.mysql.cj.jdbc.Driver");
 		
 		String username="root";
 		String password="root";
 		String url ="jdbc:mysql://localhost:3306/sakila";
 		Connection con=DriverManager.getConnection(url, username,password);
 		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
 		stmt.executeQuery("set @newstoreID = 13");
       
 		stmt.executeUpdate("update store set last_update=Now() where store_id like @newstoreID");
 		
       ResultSet timeInQuery= stmt.executeQuery("select last_update from store where store_id like @newstoreID");
 			ResultSet rs= stmt.executeQuery("select * from store");
          ResultSet timeTest= stmt.executeQuery("select Now()");
  		 Assert.assertEquals(timeTest, timeInQuery);

 			rs.last();
 		 
 		 int rows=rs.getRow();
 		 System.out.println("Number of rows "+rows);
 		 
 		 ResultSetMetaData rsmd = rs.getMetaData();
 		 int cols = rsmd.getColumnCount();
 		 System.out.println("Number of columns "+cols);
 		  int i=0;
 		  rs.beforeFirst();
 		 String data[][] = new String[rows][cols];
 		 while(rs.next()) {
 			 for(int j=0;j<cols;j++) {
 				data[i][j]= rs.getString(j+1);
 				System.out.println(""+data[i][j]);
 			 }
 			 i++;
 		 }
 	}
 	//Number 10
 		@Test
 		
 		public void connect2() throws ClassNotFoundException, SQLException {
 			Class.forName("com.mysql.cj.jdbc.Driver");
 			
 			String username="root";
 			String password="root";
 			String url ="jdbc:mysql://localhost:3306/sakila";
 			Connection con=DriverManager.getConnection(url, username,password);
 			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
 			
 			 stmt.executeUpdate("rollback");
 			 stmt.executeUpdate("delete from store where store_id like 11");
 			ResultSet rs=stmt.executeQuery("select * from store");
 			
 			 rs.last();
 			 
 			 int rows=rs.getRow();
 			 System.out.println("Number of rows "+rows);
 			 
 			 ResultSetMetaData rsmd = rs.getMetaData();
 			 int cols = rsmd.getColumnCount();
 			 System.out.println("Number of columns "+cols);
 			  int i=0;
 			  rs.beforeFirst();
 			 String data[][] = new String[rows][cols];
 			 while(rs.next()) {
 				 for(int j=0;j<cols;j++) {
 					data[i][j]= rs.getString(j+1);
 					System.out.println(""+data[i][j]);
 				 }
 				 i++;
 			 }
 		}
	@Test
	public void canExecuteUsingTheStatementInterface() throws SQLException {

		double expectedPaymentAmount = 5.99;
		double actualPaymentAmount = 0;
		String sql = "SELECT amount FROM sakila.payment WHERE rental_id = 78";

		try {
			connection = getDatabaseConnection();

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);

			resultSet.next();

			actualPaymentAmount = resultSet.getDouble("amount");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		} 
		finally {
			if(connection != null ) {
				connection.close();
			}
		}

		Assert.assertEquals(actualPaymentAmount, expectedPaymentAmount);
	}

	@Test
	public void canExecutePreparedStatement() throws SQLException {

		double expectedPaymentAmount = 5.99;
		double actualPaymentAmount = 0;
		String sql = "SELECT amount FROM sakila.payment WHERE rental_id = ?";

		try {
			connection = getDatabaseConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 78);

			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();

			actualPaymentAmount = resultSet.getDouble("amount");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		} 
		finally {
			if(connection != null ) {
				connection.close();
			}
		}

		Assert.assertEquals(actualPaymentAmount, expectedPaymentAmount);
	}

	@Test
	public void canUpdateRowsInResultSetObjects() throws SQLException {

		double actualPaymentAmount = 0;
		double updatedActualPaymentAmount = 0;
		String sql = "SELECT * FROM sakila.payment WHERE rental_id = ?";

		try {
			connection = getDatabaseConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			preparedStatement.setInt(1, 76);

			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();

			actualPaymentAmount = resultSet.getDouble("amount");

			resultSet.updateDouble("amount", actualPaymentAmount + 1);

			resultSet.updateRow();

			updatedActualPaymentAmount = resultSet.getDouble("amount");    	
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		} 
		finally {
			if(connection != null ) {
				connection.close();
			}
		}

		Assert.assertEquals(updatedActualPaymentAmount, actualPaymentAmount + 1, "the recordset value should be updated.");
	}

	private Connection getDatabaseConnection() throws Exception {
		connection = DriverManager.getConnection(url, userId, password);

		if (connection == null) {
			throw new Exception("Failed to make connection!");
		}	

		return connection;
	}
	
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
