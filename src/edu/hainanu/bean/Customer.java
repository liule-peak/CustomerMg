package edu.hainanu.bean;

/**
 * @author 9527 Email：839119912@qq.com
 * @version 1.0
 * @Describtion Customer 为实体对象，用来封装客户信息
 * @date 2020/8/18
 * model level
 */
public class Customer {
    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer() {

    }

    public Customer(String name, char gender, int age, String phone, String email) {
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
        this.name = name;
    }
}
