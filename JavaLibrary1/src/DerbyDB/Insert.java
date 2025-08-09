package DerbyDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Insert {
 public static void main(String[] args) {
 String connectionURL= "jdbc:derby://localhost:1527/Insurance DB";
//ConnectionURL, username and password should be specified in getConnection()
try {
Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
Statement st = conn.createStatement();


//PERSON 

String sql14 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (14, 'Marwa', 'marwa@gmail.com', '0123450800', 'Mansoura')";


String sql15 = "INSERT INTO PERSON (person_id, name, email, phone, address, PASSWORD) " +
               "VALUES (15, 'Amr', 'amr@gmail.com', '0123450801', 'Tanta', 'mory')";


String sql16 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (16, 'Dina', 'dina@gmail.com', '0123450802', 'Ismailia')";


String sql17 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (17, 'Mostafa Saber', 'mostafa.saber@gmail.com', '0123450803', 'Fayoum')";


String sql18 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (18, 'Layla', 'layla@gmail.com', '0123450804', 'Assiut')";


String sql19 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (19, 'Ibrahim', 'ibrahim@gmail.com', '0123450805', 'Suez')";


String sql20 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (20, 'Salma', 'salma@gmail.com', '0123450806', 'Zagazig')";



String sql21 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (21, 'Ahmed', 'ahmed@gmail.com', '0123450807', 'Cairo')";


String sql22 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (22, 'Mona', 'mona@gmail.com', '0123450808', 'Alexandria')";


String sql23 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (23, 'Omar', 'omar@gmail.com', '0123450809', 'Giza')";


String sql24 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (24, 'Layla', 'layla@gmail.com', '0123450810', 'Luxor')";


String sql25 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (25, 'Karim', 'karim@gmail.com', '0123450811', 'Aswan')";


String sql26 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (26, 'Nadia', 'nadia@gmail.com', '0123450812', 'Port Said')";


String sql27 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (27, 'Hassan', 'hassan@gmail.com', '0123450813', 'Suez')";


String sql28 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (28, 'Dalia', 'dalia@gmail.com', '0123450814', 'Mansoura')";


String sql29 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (29, 'Tarek', 'tarek@gmail.com', '0123450815', 'Ismailia')";

String sql30 = "INSERT INTO PERSON (person_id, name, email, phone, address) " +
               "VALUES (30, 'Yasmine', 'yasmine@gmail.com', '0123450816', 'Tanta')";

//ADMIN

String sql3 = "INSERT INTO ADMIN (ADMIN_ID, ADMIN_ROLE) VALUES (3, 'Coordinator')";


String sql4 = "INSERT INTO ADMIN (ADMIN_ID, ADMIN_ROLE) VALUES (4, 'Director')";


String sql5 = "INSERT INTO ADMIN (ADMIN_ID, ADMIN_ROLE) VALUES (5, 'Analyst')";


String sql6 = "INSERT INTO ADMIN (ADMIN_ID, ADMIN_ROLE) VALUES (6, 'Specialist')";


String sql7 = "INSERT INTO ADMIN (ADMIN_ID, ADMIN_ROLE) VALUES (7, 'Executive')";


String sql8 = "INSERT INTO ADMIN (ADMIN_ID, ADMIN_ROLE) VALUES (8, 'Officer')";


String sql9 = "INSERT INTO ADMIN (ADMIN_ID, ADMIN_ROLE) VALUES (9, 'Representative')";


String sql10 = "INSERT INTO ADMIN (ADMIN_ID, ADMIN_ROLE) VALUES (10, 'Assistant')";


String sql11 = "INSERT INTO ADMIN (ADMIN_ID, ADMIN_ROLE) VALUES (11, 'Consultant')";


String sql12 = "INSERT INTO ADMIN (ADMIN_ID, ADMIN_ROLE) VALUES (12, 'Administrator')";




//CLIENT

String sql1 = "INSERT INTO CLIENT (CLIENT_ID) VALUES (1)";
//st.executeUpdate(sql1);

String sql2 = "INSERT INTO CLIENT (CLIENT_ID) VALUES (2)";
//st.executeUpdate(sql2);

String sq131 = "INSERT INTO CLIENT (CLIENT_ID) VALUES (3)";  
//st.executeUpdate(sq131);  

String sql41 = "INSERT INTO CLIENT (CLIENT_ID) VALUES (4)";  
//st.executeUpdate(sql41);  

String sql51 = "INSERT INTO CLIENT (CLIENT_ID) VALUES (5)";  
//st.executeUpdate(sql51);  

String sql61 = "INSERT INTO CLIENT (CLIENT_ID) VALUES (6)";  
//st.executeUpdate(sql61);  

String sql71 = "INSERT INTO CLIENT (CLIENT_ID) VALUES (7)";  
//st.executeUpdate(sql71);  

String sql81 = "INSERT INTO CLIENT (CLIENT_ID) VALUES (8)";  
//st.executeUpdate(sql81);  

String sql91 = "INSERT INTO CLIENT (CLIENT_ID) VALUES (9)";  
//st.executeUpdate(sql91);  

String sq200 = "INSERT INTO CLIENT (CLIENT_ID) VALUES (10)";  
//st.executeUpdate(sq200);  

String sq201 = "INSERT INTO CLIENT (CLIENT_ID) VALUES (11)";  
//st.executeUpdate(sq201);  

String sq202 = "INSERT INTO CLIENT (CLIENT_ID) VALUES (12)";  
//st.executeUpdate(sq202);  

    


//POLICY

String sq211 = "INSERT INTO POLICY (POLICY_ID, POLICYTYPE, COVERAGEDETAILS, STARTDATE, ENDDATE, STATUS) " +
              "VALUES (101, 'Health', 'Full Coverage', '2025-01-01', '2025-12-31', 'Active')";
//st.executeUpdate(sq211);

String sq2l2 = "INSERT INTO POLICY (POLICY_ID, POLICYTYPE, COVERAGEDETAILS, STARTDATE, ENDDATE, STATUS) " +
              "VALUES (102, 'Auto', 'Partial Coverage', '2025-02-01', '2026-01-31', 'Inactive')";
//st.executeUpdate(sq2l2);
//
String sq2l3 = "INSERT INTO POLICY (POLICY_ID, POLICYTYPE, COVERAGEDETAILS, STARTDATE, ENDDATE, STATUS) " +
              "VALUES (103, 'Life', 'Term Life Insurance', '2025-03-01', '2035-03-01', 'Active')";
//st.executeUpdate(sq2l3);
//
String sq2l4 = "INSERT INTO POLICY (POLICY_ID, POLICYTYPE, COVERAGEDETAILS, STARTDATE, ENDDATE, STATUS) " +
              "VALUES (104, 'Home', 'Comprehensive Protection', '2025-04-15', '2026-04-14', 'Pending')";
//st.executeUpdate(sq2l4);
//
String sq2l5 = "INSERT INTO POLICY (POLICY_ID, POLICYTYPE, COVERAGEDETAILS, STARTDATE, ENDDATE, STATUS) " +
              "VALUES (105, 'Travel', 'International Coverage', '2025-05-01', '2025-11-30', 'Active')";
//st.executeUpdate(sq2l5);

//CLAIM

String sq2l1 = "INSERT INTO CLAIM (CLAIM_ID, POLICYID, DATE_FILED, STATUS) VALUES (1, '101', '2025-04-01', 'Pending')";
//st.executeUpdate(sq2l1);
//
String sq2l6 = "INSERT INTO CLAIM (CLAIM_ID, POLICYID, DATE_FILED, STATUS) VALUES (2, '102', '2025-04-02', 'Approved')";
//st.executeUpdate(sq2l6);
//
String sq2l7 = "INSERT INTO CLAIM (CLAIM_ID, POLICYID, DATE_FILED, STATUS) VALUES (3, '103', '2025-04-03', 'Rejected')";
//st.executeUpdate(sq2l7);
//
String sq2l8 = "INSERT INTO CLAIM (CLAIM_ID, POLICYID, DATE_FILED, STATUS) VALUES (4, '104', '2025-04-04', 'Pending')";
//st.executeUpdate(sq2l8);
//
String sq2l9 = "INSERT INTO CLAIM (CLAIM_ID, POLICYID, DATE_FILED, STATUS) VALUES (5, '105', '2025-04-05', 'Approved')";
//st.executeUpdate(sq2l9);


//Feedback

String sq221 = "INSERT INTO FEEDBACK (FEEDBACK_ID) VALUES (1)";
//st.executeUpdate(sq221);

String sq222 = "INSERT INTO FEEDBACK (FEEDBACK_ID) VALUES (2)";
//st.executeUpdate(sq222);

String sq223 = "INSERT INTO FEEDBACK (FEEDBACK_ID) VALUES (3)";
//st.executeUpdate(sq223);

String sq224 = "INSERT INTO FEEDBACK (FEEDBACK_ID) VALUES (4)";
//st.executeUpdate(sq224);

String sq225 = "INSERT INTO FEEDBACK (FEEDBACK_ID) VALUES (5)";
//st.executeUpdate(sq225);

String sq226 = "INSERT INTO FEEDBACK (FEEDBACK_ID) VALUES (6)";
//st.executeUpdate(sq226);

String sq227 = "INSERT INTO FEEDBACK (FEEDBACK_ID) VALUES (7)";
//st.executeUpdate(sq227);

String sq228 = "INSERT INTO FEEDBACK (FEEDBACK_ID) VALUES (8)";
//st.executeUpdate(sq228);

String sq229 = "INSERT INTO FEEDBACK (FEEDBACK_ID) VALUES (9)";
//st.executeUpdate(sq229);

String sq230 = "INSERT INTO FEEDBACK (FEEDBACK_ID) VALUES (10)";
//st.executeUpdate(sq230);

String sq231 = "INSERT INTO FEEDBACK (FEEDBACK_ID) VALUES (11)";
//st.executeUpdate(sq231);

String sq232 = "INSERT INTO FEEDBACK (FEEDBACK_ID) VALUES (12)";
//st.executeUpdate(sq232);



//Payment

String sq241 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
              "VALUES (1, 1, 1000.0, '2025-04-10', 'Receipt001')";
st.executeUpdate(sq241);

String sq242 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
              "VALUES (2, 2, 1500.0, '2025-04-11', 'Receipt002')";
st.executeUpdate(sq242);

String sq243 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
              "VALUES (3, 3, 1200.0, '2025-04-12', 'Receipt003')";
st.executeUpdate(sq243);

String sq244 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
              "VALUES (4, 4, 1800.0, '2025-04-13', 'Receipt004')";
st.executeUpdate(sq244);

String sq245 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
              "VALUES (5, 5, 950.0, '2025-04-14', 'Receipt005')";
st.executeUpdate(sq245);

String sq246 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
              "VALUES (6, 6, 2100.0, '2025-04-15', 'Receipt006')";
st.executeUpdate(sq246);

String sq247 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
              "VALUES (7, 7, 1300.0, '2025-04-16', 'Receipt007')";
st.executeUpdate(sq247);

String sq248 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
              "VALUES (8, 8, 1750.0, '2025-04-17', 'Receipt008')";
st.executeUpdate(sq248);

String sq249 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
              "VALUES (9, 9, 2200.0, '2025-04-18', 'Receipt009')";
st.executeUpdate(sq249);

String sql250 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
               "VALUES (10, 10, 1100.0, '2025-04-19', 'Receipt010')";
st.executeUpdate(sql250);

String sql251 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
               "VALUES (11, 11, 1950.0, '2025-04-20', 'Receipt011')";
st.executeUpdate(sql251);

String sql252 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
               "VALUES (12, 12, 1600.0, '2025-04-21', 'Receipt012')";
st.executeUpdate(sql252);

String sql253 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
               "VALUES (13, 13, 1400.0, '2025-04-22', 'Receipt013')";
st.executeUpdate(sql253);

String sql254 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
               "VALUES (14, 14, 2300.0, '2025-04-23', 'Receipt014')";
st.executeUpdate(sql254);

String sql255 = "INSERT INTO PAYMENT (PAYMENT_ID, CLIENT_ID, AMOUNT, PAYMENTDATE, RECEIPT) " +
               "VALUES (15, 15, 1250.0, '2025-04-24', 'Receipt015')";
st.executeUpdate(sql255);



    
st.close(); conn.close(); }
catch (SQLException ex) {System.out.println("Connect failed ! ");}
}
}