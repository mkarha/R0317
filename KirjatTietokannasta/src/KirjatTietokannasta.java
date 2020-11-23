import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class KirjatTietokannasta {
	
	static final String tietokantaOsoite = "jdbc:mysql://localhost/kirjat";

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = DriverManager.getConnection(tietokantaOsoite, "ventti", "123peli!");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM kirjasto");
			
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			System.out.println("Kirjat tietokannassa kirjasto:");
			
			for(int i=1; i<=numberOfColumns; i++) {
				System.out.printf("%-30s\t", metaData.getColumnName(i));
				
			}
			System.out.println("\n");
			
			while (resultSet.next()) {
				for (int i=1; i<=numberOfColumns; i++) {
					System.out.printf("%-30s\t", resultSet.getObject(i));
					
				}
				System.out.println();
			}
				
			
			
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}

	}

}
