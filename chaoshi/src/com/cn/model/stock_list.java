package com.cn.model;

public class stock_list {
	private int sl_id;
	private String sl_name;
	private int goods_number;
	private float goods_price;
	private String supplier_name;
//	private String ruku_name;
	public int getSl_id() {
		return sl_id;
	}
	public void setSl_id(int sl_id) {
		this.sl_id = sl_id;
	}
	public String getSl_name() {
		return sl_name;
	}
	public void setSl_name(String sl_name) {
		this.sl_name = sl_name;
	}
	public int getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}
	public float getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(float goods_price) {
		this.goods_price = goods_price;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
//	public String getRuku_name() {
//		return ruku_name;
//	}
//	public void setRuku_name(String ruku_name) {
//		this.ruku_name = ruku_name;
//	}
	@Override
	public String toString() {
		return "stock_list [sl_id=" + sl_id + ", sl_name=" + sl_name + ", goods_number=" + goods_number
				+ ", goods_price=" + goods_price + ", supplier_name=" + supplier_name
				+ "]";
	}
	
}
