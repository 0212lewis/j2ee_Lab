package cn.edu.nju.p.po;

/**
 * Created by pc on 2018/3/7.
 */
public class VenueRegisterAccountPO {
    private String username;
    private String state;
    private String venueName;
    private String address;
    private String total;
    private String seatA;
    private String seatB;
    private String seatC;
    private String manager;
    private String phoneNumber;
    private String description;
    private String message1;
    private String message2;
    private String message3;
    private String venueId;


    public VenueRegisterAccountPO(String username, String state, String venueName, String address, String total, String seatA, String seatB, String seatC, String manager, String phoneNumber, String description, String message1, String message2, String message3,String venueId) {
        this.username = username;
        this.state = state;
        this.venueName = venueName;
        this.address = address;
        this.total = total;
        this.seatA = seatA;
        this.seatB = seatB;
        this.seatC = seatC;
        this.manager = manager;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.message1 = message1;
        this.message2 = message2;
        this.message3 = message3;
        this.venueId = venueId;
    }

    public VenueRegisterAccountPO(){

    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSeatA() {
        return seatA;
    }

    public void setSeatA(String seatA) {
        this.seatA = seatA;
    }

    public String getSeatB() {
        return seatB;
    }

    public void setSeatB(String seatB) {
        this.seatB = seatB;
    }

    public String getSeatC() {
        return seatC;
    }

    public void setSeatC(String seatC) {
        this.seatC = seatC;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getMessage3() {
        return message3;
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }

    @Override
    public String toString() {
        return "VenueRegisterAccountPO{" +
                "username='" + username + '\'' +
                ", state='" + state + '\'' +
                ", venueName='" + venueName + '\'' +
                ", address='" + address + '\'' +
                ", total='" + total + '\'' +
                ", seatA='" + seatA + '\'' +
                ", seatB='" + seatB + '\'' +
                ", seatC='" + seatC + '\'' +
                ", manager='" + manager + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", description='" + description + '\'' +
                ", message1='" + message1 + '\'' +
                ", message2='" + message2 + '\'' +
                ", message3='" + message3 + '\'' +
//                ", createTime='" + createTime + '\'' +
                '}';
    }
}
