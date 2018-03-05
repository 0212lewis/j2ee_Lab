package cn.edu.nju.p.po;

/**
 * Created by pc on 2018/3/2.
 */
public class UserPO {

    private String username;
    private String sex;
    private String phoneNumber;
    private String email;
    private String address;
    private String unit;
    private String realName;
    private String identity;
    private String level;
    private String balance;
    private String integral;
    private String consumption;
    private String description;

    public UserPO(String username, String sex, String phoneNumber, String email, String address, String unit, String realName, String identity, String level, String balance, String integral, String consumption, String description) {
        this.username = username;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.unit = unit;
        this.realName = realName;
        this.identity = identity;
        this.level = level;
        this.balance = balance;
        this.integral = integral;
        this.consumption = consumption;
        this.description = description;
    }
    public UserPO(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", unit='" + unit + '\'' +
                ", realName='" + realName + '\'' +
                ", identity='" + identity + '\'' +
                ", level='" + level + '\'' +
                ", balance='" + balance + '\'' +
                ", integral='" + integral + '\'' +
                ", consumption='" + consumption + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
