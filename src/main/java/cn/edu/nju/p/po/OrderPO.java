package cn.edu.nju.p.po;

/**
 * Created by pc on 2018/3/2.
 */
public class OrderPO {

    private String username;
    private String orderId;
    private String createTime;
    private String showName;
    private String showTime;
    private String seatType;
    private String seat;
    private String price;
    private String num;
    private String total;
    private String code;
    private String number;
    private String state;


    public OrderPO(String username, String orderId, String createTime, String showTime, String seatType, String seat, String price, String num, String total, String code, String number) {
        this.username = username;
        this.orderId = orderId;
        this.createTime = createTime;
        this.showTime = showTime;
        this.seatType = seatType;
        this.seat = seat;
        this.price = price;
        this.num = num;
        this.total = total;
        this.code = code;
        this.number = number;
    }

    public OrderPO(){

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "OrderPO{" +
                "username='" + username + '\'' +
                ", orderId='" + orderId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", showTime='" + showTime + '\'' +
                ", seatType='" + seatType + '\'' +
                ", seat='" + seat + '\'' +
                ", price='" + price + '\'' +
                ", num='" + num + '\'' +
                ", total='" + total + '\'' +
                ", code='" + code + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
