import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Insert {
 public static void main(String[] args) {
 String connectionURL= "jdbc:derby://localhost:1527/Insurance DB [bue on BUE]";
//ConnectionURL, username and password should be specified in getConnection()
try {
Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
Statement st = conn.createStatement();
String sql = "INSERT INTO PERSON (PERSON_ID, NAME) VALUES (2, 'demo1')";
st.executeUpdate(sql);
st.close(); conn.close(); }
catch (SQLException ex) {System.out.println("Connect failed ! ");}
}
}