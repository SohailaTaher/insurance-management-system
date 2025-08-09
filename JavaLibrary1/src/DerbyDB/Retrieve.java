package DerbyDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retrieve {
    public static void main(String[] args) {
        String connectionURL = "jdbc:derby://localhost:1527/Insurance DB";
        // ConnectionURL, username and password should be specified in getConnection()
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
            String sql = "SELECT * FROM PAYMENT";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            
//Person      
//            while (rs.next()) {
//                System.out.println(
//                    rs.getInt("person_id") + "\t" +
//                    rs.getString("name") + "\t" +
//                    rs.getString("email") + "\t" +
//                    rs.getString("phone") + "\t" +
//                    rs.getString("address")
//                );
//            }


//Admin
//            while (rs.next()) {
//            System.out.println(rs.getInt("ADMIN_ID") + "\t" + rs.getString("ADMIN_ROLE"));
//        }


//Claim
//while (rs.next()) {
//    System.out.println(
//        rs.getInt("CLAIM_ID") + "\t" +
//        rs.getInt("POLICYID") + "\t" +
//        rs.getDate("DATE_FILED") + "\t" +
//        rs.getString("STATUS")
//    );
//}


//Policy
//while (rs.next()) {
//    System.out.println(
//        rs.getInt("POLICY_ID") + "\t" +
//        rs.getString("POLICYTYPE") + "\t" +
//        rs.getString("COVERAGEDETAILS") + "\t" +
//        rs.getDate("STARTDATE") + "\t" +
//        rs.getDate("ENDDATE") + "\t" +
//        rs.getString("STATUS")
//    );
//}


//Feedback
//while (rs.next()) {
//    System.out.println(rs.getInt("FEEDBACK_ID"));
//}



//Payment
//while (rs.next()) {
//    System.out.println(
//        rs.getInt("PAYMENT_ID") + "\t" +
//        rs.getInt("CLIENT_ID") + "\t" +
//        rs.getDouble("AMOUNT") + "\t" +
//        rs.getDate("PAYMENTDATE") + "\t" +
//        rs.getString("RECEIPT")
//    );
//}



while (rs.next()) {
    System.out.println(rs.getInt("CLIENT_ID"));
}

            
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed! " + ex.getMessage());
        }
    }
}
