package com.cn.model;

public class member {
	private int memid;
	private String memname;
	private String memtel;
	private int memjifen;
	public int getMemid() {
		return memid;
	}
	public void setMemid(int memid) {
		this.memid = memid;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	public String getMemtel() {
		return memtel;
	}
	public void setMemtel(String memtel) {
		this.memtel = memtel;
	}
	public int getMemjifen() {
		return memjifen;
	}
	public void setMemjifen(int memjifen) {
		this.memjifen = memjifen;
	}
	@Override
	public String toString() {
		return "member [memid=" + memid + ", memname=" + memname + ", memtel=" + memtel + ", memjifen=" + memjifen
				+ "]";
	}
	
}
