package cn.edu.nju.p.po;

/**
 * Created by dell- on 2017/7/10.
 */
public class AccountPO {

    private String username;
    private String email;
    private String authority;

    public AccountPO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "AccountPO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", authority=" + authority +
                '}';
    }
}
