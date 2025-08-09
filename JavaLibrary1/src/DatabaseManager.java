import java.sql.*;

public class DatabaseManager {


    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Insurance DB", "bue", "bue")) {
            createTables(conn);
        } catch (SQLException ex) {
            System.err.println("Database initialization failed: " + ex.getMessage());
        }
    }

    private static void createTables(Connection conn) throws SQLException {
        // PERSON table (parent table)
        String createPersonTable = "CREATE TABLE PERSON ("
                + "ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,"
                + "FULL_NAME VARCHAR(100) NOT NULL)";
        
        // USERS table (child table)
        String createUsersTable = "CREATE TABLE USERS ("
                + "ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,"
                + "USERNAME VARCHAR(50) UNIQUE NOT NULL,"
                + "PASSWORD VARCHAR(100) NOT NULL,"
                + "EMAIL VARCHAR(100) UNIQUE NOT NULL,"
                + "PERSON_ID INT REFERENCES PERSON(ID))";

        executeUpdate(conn, createPersonTable);
        executeUpdate(conn, createUsersTable);
    }

    private static void executeUpdate(Connection conn, String sql) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            if (!ex.getMessage().contains("already exists")) {
                throw ex;
            }
        }
    }

    static void intializeDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
