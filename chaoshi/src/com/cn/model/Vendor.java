package com.cn.model;

public class Vendor {
    private int ve_id;
    private String ve_name;
    private String ve_tel;
    private String ve_address;

    public int getVe_id() {
        return ve_id;
    }

    public void setVe_id(int ve_id) {
        this.ve_id = ve_id;
    }

    public String getVe_name() {
        return ve_name;
    }

    public void setVe_name(String ve_name) {
        this.ve_name = ve_name;
    }

    public String getVe_tel() {
        return ve_tel;
    }

    public void setVe_tel(String ve_tel) {
        this.ve_tel = ve_tel;
    }

    public String getVe_address() {
        return ve_address;
    }

    public void setVe_address(String ve_address) {
        this.ve_address = ve_address;
    }


    @Override
    public String toString() {
        return "vendor{" +
                "ve_id=" + ve_id +
                ", ve_name='" + ve_name + '\'' +
                ", ve_tel='" + ve_tel + '\'' +
                ", ve_address='" + ve_address + '\'' +
                '}';
    }
}
