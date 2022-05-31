package com.cn.model;

public class salelist {
	private int saleid;
	private String salename;
	private int salenum;
	private float total;
	private String date;
	private String funder;
	public int getSaleid() {
		return saleid;
	}
	public void setSaleid(int saleid) {
		this.saleid = saleid;
	}
	public String getSalename() {
		return salename;
	}
	public void setSalename(String salename) {
		this.salename = salename;
	}
	public int getSalenum() {
		return salenum;
	}
	public void setSalenum(int salenum) {
		this.salenum = salenum;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFunder() {
		return funder;
	}
	public void setFunder(String funder) {
		this.funder = funder;
	}
	@Override
	public String toString() {
		return "salelist [saleid=" + saleid + ", salename=" + salename + ", salenum=" + salenum + ", total=" + total
				+ ", date=" + date + ", funder=" + funder + "]";
	}
	

}
