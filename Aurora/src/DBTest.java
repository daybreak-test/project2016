import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;

		connection = DriverManager.getConnection("jdbc:sqlite:../sqlite3.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
//		statement.execute("insert into DB_TEST values('DB Test!!')");
		ResultSet resultSet = statement.executeQuery("select * from DB_TEST");
		while(resultSet.next()) {
			System.out.println(resultSet.getString("ID"));
		}
		connection.close();
		connection = null;
	}

}
