package cn.sm1234.movie.pojo;

import java.io.Serializable;


public class User implements Serializable{

    private Integer id;
    private String user;
    private String password;
    private String sex;
    private Double money;
    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", money=" + money +
                '}';
    }

    public User(Integer id, String user, String password, String sex, Double money) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.sex = sex;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
