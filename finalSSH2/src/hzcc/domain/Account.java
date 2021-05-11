package hzcc.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID=1L;
    private String userID;
    private String pwd;
    private int kind;

    public Account() {
    }

    public Account(String userID, String pwd) {
        this.userID = userID;
        this.pwd = pwd;
    }

    public Account(String userID, String pwd, int kind) {
        this.userID = userID;
        this.pwd = pwd;
        this.kind = kind;
    }

    public String getKindStr(){
        String result="ERROR";
        if (kind==0){
            result="admin";
        }else {
            result ="user";
        }
        return result;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getKindstr(){
        if (kind==1) {
            return "会员";
        }else if (kind==0){
            return "管理员";
        }else {
            return "ERROR";
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "userID='" + userID + '\'' +
                ", pwd='" + pwd + '\'' +
                ", kind=" + kind +
                '}';
    }
}
