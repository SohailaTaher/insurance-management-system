import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Retrieve {

 public static void main(String[] args) {
 String connectionURL= "jdbc:derby://localhost:1527/Insurance DB [bue on BUE]";
//ConnectionURL, username and password should be specified in getConnection()
try {
Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
String sql = "SELECT * FROM STUDENT";
Statement st = conn.createStatement();
ResultSet rs=null;
rs=st.executeQuery(sql);
while(rs.next()){
System.out.println(rs.getInt("id")+"\t"+rs.getString("name"));
}
rs.close();
st.close();
conn.close();
} catch (SQLException ex) {
System.out.println("Connect failed ! ");
}
  }
    }