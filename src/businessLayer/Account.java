package businessLayer;

import java.io.Serializable;

public class Account implements Serializable {
    private String username;
    private final String password;
    private int id;
    private final Type type;

    public Account(String username, String password, int id, Type type) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.type = type;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
