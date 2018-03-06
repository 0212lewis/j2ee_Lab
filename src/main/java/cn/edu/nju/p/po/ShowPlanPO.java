package cn.edu.nju.p.po;

/**
 * Created by pc on 2018/3/3.
 */
public class ShowPlanPO {

    private String showName;
    private String showTime;
    private String type;
    private String venueName;
    private String manager;
    private String phoneNumber;
    private String showPlace;
    private String showPrice;
    private String description;
    private String state;
    private String createTime;
    private String openTime;

    public ShowPlanPO(String showName, String showTime, String type, String venueName, String manager, String phoneNumber, String showPlace, String showPrice, String description, String state,String createTime,String openTime) {
        this.showName = showName;
        this.showTime = showTime;
        this.type = type;
        this.venueName = venueName;
        this.manager = manager;
        this.phoneNumber = phoneNumber;
        this.showPlace = showPlace;
        this.showPrice = showPrice;
        this.description = description;
        this.state = state;
        this.createTime=createTime;
        this.openTime=openTime;
    }

    public ShowPlanPO(){

    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
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

    public String getShowPlace() {
        return showPlace;
    }

    public void setShowPlace(String showPlace) {
        this.showPlace = showPlace;
    }

    public String getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(String showPrice) {
        this.showPrice = showPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ShowPlanPO{" +
                "showName='" + showName + '\'' +
                ", showTime='" + showTime + '\'' +
                ", type='" + type + '\'' +
                ", venueName='" + venueName + '\'' +
                ", manager='" + manager + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", showPlace='" + showPlace + '\'' +
                ", showPrice='" + showPrice + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", createTime='" + createTime + '\'' +
                ", openTime='" + openTime + '\'' +
                '}';
    }
}
