package cn.edu.nju.p.po;

/**
 * Created by pc on 2018/3/12.
 */
public class IncomePO {
    private Double actualIncome;
    private Double Income;
    private Double shouldPay;
    private String venueName;

    public IncomePO(){

    }

    public Double getActualIncome() {
        return actualIncome;
    }

    public void setActualIncome(Double actualIncome) {
        this.actualIncome = actualIncome;
    }

    public Double getIncome() {
        return Income;
    }

    public void setIncome(Double income) {
        Income = income;
    }

    public Double getShouldPay() {
        return shouldPay;
    }

    public void setShouldPay(Double shouldPay) {
        this.shouldPay = shouldPay;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public IncomePO(Double actualIncome, Double income, Double shouldPay, String venueName) {

        this.actualIncome = actualIncome;
        Income = income;
        this.shouldPay = shouldPay;
        this.venueName = venueName;
    }

    @Override
    public String toString() {
        return "IncomePO{" +
                ", actualIncome=" + actualIncome +
                ", Income=" + Income +
                ", shouldPay=" + shouldPay +
                ", venueName='" + venueName + '\'' +
                '}';
    }
}
