package com.cn.model;

public class emp {
	private int empid;
	private String empname;
	private String emptel;
	private String emppos;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmptel() {
		return emptel;
	}
	public void setEmptel(String emptel) {
		this.emptel = emptel;
	}
	public String getEmppos() {
		return emppos;
	}
	public void setEmppos(String emppos) {
		this.emppos = emppos;
	}
	@Override
	public String toString() {
		return "emp [empid=" + empid + ", empname=" + empname + ", emptel=" + emptel + ", emppos=" + emppos + "]";
	}
	

}
