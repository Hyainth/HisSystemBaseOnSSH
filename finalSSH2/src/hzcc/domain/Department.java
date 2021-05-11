package hzcc.domain;

import java.io.Serializable;

public class Department implements Serializable {
    private static final long serialVersionUID=1L;
    private String depID;
    private String depName;
    private String phone;

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depID='" + depID + '\'' +
                ", depName='" + depName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
