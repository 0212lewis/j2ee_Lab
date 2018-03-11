package cn.edu.nju.p.po;

/**
 * Created by pc on 2018/3/6.
 */
public class VenueModifyPO {

    private String title;
    private String state;
    private String createTime;
    private String venueName;
    private String address;
    private String totalSeats;
//    private String seatType;
    private String seatA;
    private String seatB;
    private String seatC;
    private String manager;
    private String phoneNumber;
    private String description;
    private String message1;
    private String message2;
    private String message3;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
//
//    public String getVenueId() {
//        return venueId;
//    }
//
//    public void setVenueId(String venueId) {
//        this.venueId = venueId;
//    }

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

//    public String getSeatType() {
//        return seatType;
//    }
//
//    public void setSeatType(String seatType) {
//        this.seatType = seatType;
//    }

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

//    public String getAvailable() {
//        return available;
//    }

//    public void setAvailable(String available) {
//        this.available = available;
//    }

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
        return "VenueModifyPO{" +
                "title='" + title + '\'' +
                ", state='" + state + '\'' +
                ", createTime='" + createTime + '\'' +
//                ", venueId='" + venueId + '\'' +
                ", venueName='" + venueName + '\'' +
                ", address='" + address + '\'' +
                ", totalSeats='" + totalSeats + '\'' +
//                ", seatType='" + seatType + '\'' +
                ", seatA='" + seatA + '\'' +
                ", seatB='" + seatB + '\'' +
                ", seatC='" + seatC + '\'' +
                ", manager='" + manager + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
//                ", available='" + available + '\'' +
                ", description='" + description + '\'' +
                ", message1='" + message1 + '\'' +
                ", message2='" + message2 + '\'' +
                ", message3='" + message3 + '\'' +
                '}';
    }
}
