package com.itz.cloud.model;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud
 * @Version 1.0
 * @date 2021/3/4 23:12
 */
public class User {
    private String username;

    private String address;

    private Integer id;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }

    public User(String username, String address, Integer id) {
        this.username = username;
        this.address = address;
        this.id = id;
    }

    public User() {
        System.out.println("***********init**********************");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println(username);
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
