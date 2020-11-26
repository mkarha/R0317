package LevyLista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLLevytManager {
	
	//tietokannan osoite, k‰ytt‰j‰tunnus ja salasana
	private static final String URL = "jdbc:mysql://localhost/levyt";
	private static final String USER = "kayttaja";
	private static final String PASSWORD =  "tunnus";
	
	//tietokannan k‰sittelymuuttujat
	private static Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement haeKaikkiLevyt = null;
	/*
	private PreparedStatement haeEsittaja = null;
	private PreparedStatement haeLevynNimella = null;
	private PreparedStatement haeJulkaisuVuosi = null;
	private PreparedStatement haeJulkaisuJalkeen = null;
	private PreparedStatement haeJulkaisuEnnen = null;
	*/
	private PreparedStatement lisaaUusiLevy = null;
	private static ResultSet resultSet = null;

	
	public SQLLevytManager() {
		
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//Kaikkien levyjen hakeminen
			haeKaikkiLevyt = connection.prepareStatement("SELECT * FROM levyt");
			
			//Levyn lis‰‰minen tietokantaan
			lisaaUusiLevy = connection.prepareStatement(
					"INSERT INTO vinyylit" + "(Esitt‰j‰, Levyn_nimi, Julkaisuvuosi, Genre, Formaatti) " + 
					"VALUES (?, ?, ?, ?, ?)");
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}
		
		
	/*Kaikkien tietokannassa olevien levyjen listaus
	 * Palauttaa listan, jonka alkioina on Levy-olioita
	 */
	public static ArrayList<Levy> kaikkiLevyt() {
		ArrayList<Levy> tulokset = null;

		
		

		System.out.println("Haetaan dataa...");

		
		
		
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			// Suoritetaan SQL kysely
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM LEVYT");
			tulokset = new ArrayList<Levy>();
			
			while (resultSet.next()) {
				tulokset.add(new Levy(
					resultSet.getString("Esitt‰j‰"),
					resultSet.getString("Levyn_nimi"),
					resultSet.getInt("Julkaisuvuosi"),
					resultSet.getString("Genre"),
					resultSet.getString("Formaatti")) );					
			}
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		finally {
			try {
				resultSet.close();
			}
			catch (SQLException sqlException) {
				sqlException.printStackTrace();
				sulje();
			}
		}
		
		return tulokset;
		
	}
		
		
	/*Lisaa levy metodi.
	 * Palauttaa kokonaisluvun, jonka arvo on 1, mik‰li lis‰ys onnistuu
	 */
	public static void lisaaLevy(Levy levy) {
		String tekija = levy.getTekija();
		String nimi = levy.getNimi();
		int vuosi = levy.getJulkaisuvuosi();
		String genre = levy.getGenre();
		String formaatti = levy.getFormaatti();

		Connection conn = null;
		Statement stmt = null;
		try {

			System.out.println("Connecting to database...");

			// Luodaan yhteys tietokantaan
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// SQL Lausekkeen esittely, k‰ytet‰‰n ? muuttuvien tietojen kohdalla
			String sql = "INSERT INTO levyt (Esitt‰j‰, Levyn_nimi, Julkaisuvuosi, Genre, Formaatti) values (?,?,?,?,?)";

			// T‰ydennet‰‰n SQL-lauseisiin puuttuvat muuttujat
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			
			preparedStmt.setString(1, tekija);
			preparedStmt.setString(2, nimi);
			preparedStmt.setInt(3, vuosi);
			preparedStmt.setString(4, genre);
			preparedStmt.setString(5, formaatti);

			// Suorittaa SQL lauseen

			preparedStmt.execute();

			System.out.println("Saving data...");

		} catch (SQLException se) {
			// K‰sitell‰‰n tietokantavirheet
			se.printStackTrace();
		} catch (Exception e) {
			// Muut virheet
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}


	public static void sulje() {
	
		try {
			connection.close();
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	
	}


	public static void lataaLevyt() {
		Connection conn = null;
		Statement stmt = null;
		try {

			// Luodaan yhteys
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			System.out.println("Haetaan dataa...");

			// Suoritetaan SQL kysely
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM LEVYT");

			// K‰yd‰‰n l‰pi tulosjoukko silmukassa
			while (rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));

			}
			// Otetaan mahdolliset virheet kiinni
		} catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		
	}

}


/*
 * 	
	public void hakuTeoksenNimella(String nimi) {
		
	}
	
	public void hakuTekijanNimella(String nimi) {
		
	}
	
	public void hakuVuodenXjalkeen(int X) {
		
	}
	
	public void hakuVuottaXEnnen(int x) {
		
	}
	*/
