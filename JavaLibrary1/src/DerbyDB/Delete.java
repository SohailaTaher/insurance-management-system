package DerbyDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
    public static void main(String[] args) {
        String connectionURL= "jdbc:derby://localhost:1527/Insurance DB";
        // ConnectionURL, username and password should be specified in getConnection()
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
            Statement st = conn.createStatement();

            String sql1 = "DELETE FROM PERSON WHERE person_id = 18";
          

            String sql2 = "DELETE FROM PERSON WHERE person_id = 19";
         

            String sql3 = "DELETE FROM PERSON WHERE person_id = 20";
         
            
            String sql4 = "DELETE FROM ADMIN WHERE ADMIN_ID = 1";
           
            
            String sql5 = "DELETE FROM CLIENT WHERE CLIENT_ID = 1";
            //st.executeUpdate(sql5);

            String sql6 = "DELETE FROM CLAIM WHERE CLAIM_ID = 1";
            //st.executeUpdate(sql6);


            String sql7 = "DELETE FROM POLICY WHERE POLICY_ID = 1";
            //st.executeUpdate(sql7);

            String sql8 = "DELETE FROM FEEDBACK WHERE FEEDBACK_ID = 1";
            //st.executeUpdate(sql8);

            
            String sql9 = "DELETE FROM PAYMENT WHERE PAYMENT_ID = 1";
            //st.executeUpdate(sql9);

            
            st.close();
            conn.close();
            System.out.println("Selected records deleted successfully!");
        } catch (SQLException ex) {
            System.out.println("Connect or delete failed: " + ex.getMessage());
        }
    }
}