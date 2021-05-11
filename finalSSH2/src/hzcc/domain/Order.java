package hzcc.domain;

import java.io.Serializable;

public class Order implements Serializable {
    private static final long serialVersionUID=1L;
    private Long orderID;
    private String mebID;
    private String projID;
    private int num;
    private String appotime;
    private String state;

    public Order() {
    }

    public Order(String mebID, String projID, int num, String appotime, String state) {
        this.mebID = mebID;
        this.projID = projID;
        this.num = num;
        this.appotime = appotime;
        this.state = state;
    }

    public Order(Long orderID, String mebID, String projID, int num, String appotime, String state) {
        this.orderID = orderID;
        this.mebID = mebID;
        this.projID = projID;
        this.num = num;
        this.appotime = appotime;
        this.state = state;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public String getMebID() {
        return mebID;
    }

    public void setMebID(String mebID) {
        this.mebID = mebID;
    }

    public String getProjID() {
        return projID;
    }

    public void setProjID(String projID) {
        this.projID = projID;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getAppotime() {
        return appotime;
    }

    public void setAppotime(String appotime) {
        this.appotime = appotime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", mebID='" + mebID + '\'' +
                ", projID='" + projID + '\'' +
                ", num=" + num +
                ", appotime='" + appotime + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
