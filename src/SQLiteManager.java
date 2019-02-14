import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class SQLiteManager {

    Connection conn;

    private Connection getConnection() {
        String url = "jdbc:sqlite:records.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public SQLiteManager(){
        this.conn = getConnection();
    }

    void createTable() {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS X" +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "A  TEXT, " +
                    "B  TEXT, " +
                    "C  TEXT, " +
                    "D  TEXT, " +
                    "E  TEXT, " +
                    "F  TEXT, " +
                    "G  TEXT, " +
                    "H  TEXT, " +
                    "I  TEXT, " +
                    "J  TEXT)";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table Created Successfully");

    }

    public void dropTable() {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            String sql = "DROP TABLE IF EXISTS X";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table Dropped Successfully");

    }

    void insertRow(String[] rowData) {

        try {

            String sql = "INSERT INTO X(A,B,C,D,E,F,G,H,I,J) VALUES(?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            for (int i = 1; i <= rowData.length; i++) {
                stmt.setString(i, rowData[i-1]);
            }

            stmt.executeUpdate();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
        }

        System.out.println("Records inserted successfully");
    }

}





