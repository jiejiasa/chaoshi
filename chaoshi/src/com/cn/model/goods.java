package com.cn.model;

public class goods {
private int goods_id;
private String goods_name;
private float goods_price;
private int goods_number;
private String goods_shelf_number;
public int getGoods_id() {
	return goods_id;
}
public void setGoods_id(int goods_id) {
	this.goods_id = goods_id;
}
public String getGoods_name() {
	return goods_name;
}
public void setGoods_name(String goods_name) {
	this.goods_name = goods_name;
}
public float getGoods_price() {
	return goods_price;
}
public void setGoods_price(float goods_price) {
	this.goods_price = goods_price;
}
public int getGoods_number() {
	return goods_number;
}
public void setGoods_number(int goods_number) {
	this.goods_number = goods_number;
}
public String getGoods_shelf_number() {
	return goods_shelf_number;
}
public void setGoods_shelf_number(String goods_shelf_number) {
	this.goods_shelf_number = goods_shelf_number;
}
@Override
public String toString() {
	return "goods [goods_id=" + goods_id + ", goods_name=" + goods_name + ", goods_price=" + goods_price
			+ ", goods_number=" + goods_number + ", goods_shelf_number=" + goods_shelf_number + "]";
}

}
