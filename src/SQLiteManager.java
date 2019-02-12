import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class SQLiteManager {

    public void openDatabase() {

            Connection conn = null;

            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:test.db");
                Statement stmt = conn.createStatement();
                String sql = "CREATE TABLE X" +
                        "(ID INT PRIMARY KEY NOT NULL," +
                        " A  TEXT , " +
                        " B  TEXT , " +
                        " C  TEXT , " +
                        " D  TEXT ," +
                        " E  TEXT , " +
                        " F  TEXT , " +
                        " G  TEXT , " +
                        " H  TEXT , " +
                        " I  TEXT , " +
                        " J  TEXT)";
                stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Opened database successfully");

        }
    }

