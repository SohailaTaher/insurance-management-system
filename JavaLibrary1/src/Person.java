import java.util.*;

// Base Person class
public abstract class Person {
    protected int personID;
    protected String name;
    protected String email;
    protected String phone;
    protected String address;
    protected String username;
    protected String password;

    public Person(int personID, String name, String email, String phone, 
                 String address, String username, String password) {
        this.personID = personID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void resetPassword(String newPassword) {
        this.password = newPassword;
    }

    public void updateInfo(String email, String phone, String address) {
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getters and setters
    public int getPersonID() { return personID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getUsername() { return username; }
}

// Document class
class Document {
    private String docID;
    private String name;
    private String type;
    private byte[] content;

    public Document(String docID, String name, String type, byte[] content) {
        this.docID = docID;
        this.name = name;
        this.type = type;
        this.content = content;
    }

    // Getters
    public String getDocID() { return docID; }
    public String getName() { return name; }
    public String getType() { return type; }
    public byte[] getContent() { return content; }
}