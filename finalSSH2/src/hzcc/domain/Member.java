package hzcc.domain;

import java.io.Serializable;

public class Member implements Serializable {
    //设定序列化版本ID，防止兼容性问题
    private static final long serialVersionUID=1L;

    private String mebID;
    private String mebName;
    private String sex;
    private String phone;
    private String resdate;

    public Member() {
    }

    public Member(String mebID, String mebName, String sex, String phone, String resdate) {
        this.mebID = mebID;
        this.mebName = mebName;
        this.sex = sex;
        this.phone = phone;
        this.resdate = resdate;
    }

    public String getMebID() {
        return mebID;
    }

    public void setMebID(String mebID) {
        this.mebID = mebID;
    }

    public String getMebName() {
        return mebName;
    }

    public void setMebName(String mebName) {
        this.mebName = mebName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResdate() {
        return resdate;
    }

    public void setResdate(String resdate) {
        this.resdate = resdate;
    }

    @Override
    public String toString() {
        return mebID+"|"+mebName;
    }
}
