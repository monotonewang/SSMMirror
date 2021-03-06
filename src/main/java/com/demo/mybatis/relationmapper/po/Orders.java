package com.demo.mybatis.relationmapper.po;

import java.util.Date;
import java.util.List;

public class Orders {

	private List<Items> itemses;

	private User user;

	private List<Orderdetail> orderdetails;

	private Integer id;

	private Integer userId;

	private String number;

	private Date createtime;

	private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number == null ? null : number.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Orderdetail> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public List<Items> getItemses() {
		return itemses;
	}

	public void setItemses(List<Items> itemses) {
		this.itemses = itemses;
	}

	@Override
	public String toString() {
		return "Orders{" +
				"itemses=" + itemses +
				", user=" + user +
				", orderdetails=" + orderdetails +
				", id=" + id +
				", userId=" + userId +
				", number='" + number + '\'' +
				", createtime=" + createtime +
				", note='" + note + '\'' +
				'}';
	}
}