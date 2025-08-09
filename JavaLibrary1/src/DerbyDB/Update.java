package DerbyDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    public static void main(String[] args) {
        String connectionURL = "jdbc:derby://localhost:1527/Insurance DB";
        // ConnectionURL, username and password should be specified in getConnection()
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
            Statement st = conn.createStatement();

            String sql1 = "UPDATE PERSON SET name='Khaled Updated' WHERE person_id=4";
            st.executeUpdate(sql1);

            String sql2 = "UPDATE PERSON SET name='Mona Updated' WHERE person_id=5";
            st.executeUpdate(sql2);

            String sql3 = "UPDATE PERSON SET name='Omar Updated' WHERE person_id=6";
            st.executeUpdate(sql3);

            String sql5 = "UPDATE ADMIN SET ADMIN_ROLE = 'Updated Manager' WHERE ADMIN_ID = 2";
            st.executeUpdate(sql5);
            
            String sql6 = "UPDATE CLAIM SET STATUS = 'Rejected' WHERE CLAIM_ID = 2";
            st.executeUpdate(sql6);


            String sql7 = "UPDATE POLICY SET STATUS = 'Expired' WHERE POLICY_ID = 2";
            st.executeUpdate(sql7);

            String sql8 = "UPDATE PAYMENT SET AMOUNT = 1200.0 WHERE PAYMENT_ID = 2";
            st.executeUpdate(sql8);

            
            st.close();
            conn.close();
            System.out.println("Selected records updated successfully!");
        } catch (SQLException ex) {
            System.out.println("Connect or update failed: " + ex.getMessage());
        }
    }
}
