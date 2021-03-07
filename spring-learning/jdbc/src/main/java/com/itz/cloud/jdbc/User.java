package com.itz.cloud.jdbc;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.jdbc
 * @Version 1.0
 * @date 2021/3/8 0:16
 */
public class User {
    private long id;
    private String name;
    private String address;
    private String favorites;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", favorites='" + favorites + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }
}
