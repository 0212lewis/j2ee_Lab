package cn.edu.nju.p.po;

/**
 * Created by pc on 2018/3/3.
 */
public class VenuePO {

    private String venueId;
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
    private String description;
    private String message1;
    private String message2;
    private String message3;
    private String actualIncome;


    public VenuePO(){

    }

    public VenuePO(String venueId,String venueName, String address, String totalSeats, String seatType, String seatA, String seatB, String seatC, String manager, String phoneNumber, String available,String description,String message1,String message2,String message3,String actualIncome) {
       this.venueId = venueId;
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
        this.description = description;
        this.message1=message1;
        this.message2=message2;
        this.message3=message3;
        this.actualIncome=actualIncome;

    }

    public String getActualIncome() {
        return actualIncome;
    }

    public void setActualIncome(String actualIncome) {
        this.actualIncome = actualIncome;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
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
                "venueId='" + venueId + '\'' +
                ", venueName='" + venueName + '\'' +
                ", address='" + address + '\'' +
                ", totalSeats='" + totalSeats + '\'' +
                ", seatType='" + seatType + '\'' +
                ", seatA='" + seatA + '\'' +
                ", seatB='" + seatB + '\'' +
                ", seatC='" + seatC + '\'' +
                ", manager='" + manager + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", available='" + available + '\'' +
                ", description='" + description + '\'' +
                ", message1='" + message1 + '\'' +
                ", message2='" + message2 + '\'' +
                ", message3='" + message3 + '\'' +
                '}';
    }
}
