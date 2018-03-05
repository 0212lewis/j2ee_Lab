package cn.edu.nju.p.po;

/**
 * Created by pc on 2018/3/3.
 */
public class VenuePO {

    private String venueName;
    private String address;
    private String totalSeats;
    private String seatType;
    private String seatA;
    private String seatB;
    private String seatC;
    private String manager;
    private String phoneNumber;
    private String available;


    public VenuePO(){

    }

    public VenuePO(String venueName, String address, String totalSeats, String seatType, String seatA, String seatB, String seatC, String manager, String phoneNumber, String available) {
        this.venueName = venueName;
        this.address = address;
        this.totalSeats = totalSeats;
        this.seatType = seatType;
        this.seatA = seatA;
        this.seatB = seatB;
        this.seatC = seatC;
        this.manager = manager;
        this.phoneNumber = phoneNumber;
        this.available = available;
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

    public String getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(String totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
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

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "VenuePO{" +
                "venueName='" + venueName + '\'' +
                ", address='" + address + '\'' +
                ", totalSeats='" + totalSeats + '\'' +
                ", seatType='" + seatType + '\'' +
                ", seatA='" + seatA + '\'' +
                ", seatB='" + seatB + '\'' +
                ", seatC='" + seatC + '\'' +
                ", manager='" + manager + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", available='" + available + '\'' +
                '}';
    }
}
