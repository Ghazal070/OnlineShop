package entity;

public class Customer extends BaseEntity<Integer>{

    public static final String TABLE_NAME="customer";
    public static final String USERNAME="username";
    public static final String PASSWORD="password";

    private String username;
    private String password;

    public Customer(Integer id, String username, String password) {
        super(id);
        this.username = username;
        this.password = password;
    }

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
