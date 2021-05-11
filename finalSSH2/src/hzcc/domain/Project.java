package hzcc.domain;

import java.io.Serializable;

public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    private String projID;
    private String projName;
    private String depID;
    private String unit;
    private float price;
    private String notes;

    public String getProjID() {
        return projID;
    }

    public void setProjID(String projID) {
        this.projID = projID;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projID='" + projID + '\'' +
                ", projName='" + projName + '\'' +
                ", depID='" + depID + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", notes='" + notes + '\'' +
                '}';
    }
}
