package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SellerData")
public class Model5 {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
    private long id;
	@Column(name="Seller Name")
	private String Yname;
	public Model5() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model5(long id, String yname, String ycity, String ystate, String ykey) {
		super();
		this.id = id;
		Yname = yname;
		Ycity = ycity;
		Ystate = ystate;
		Ykey = ykey;
	}
	@Override
	public String toString() {
		return "Model4 [id=" + id + ", Yname=" + Yname + ", Ycity=" + Ycity + ", Ystate=" + Ystate + ", Ykey=" + Ykey
				+ "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getYname() {
		return Yname;
	}
	public void setYname(String yname) {
		Yname = yname;
	}
	public String getYcity() {
		return Ycity;
	}
	public void setYcity(String ycity) {
		Ycity = ycity;
	}
	public String getYstate() {
		return Ystate;
	}
	public void setYstate(String ystate) {
		Ystate = ystate;
	}
	public String getYkey() {
		return Ykey;
	}
	public void setYkey(String ykey) {
		Ykey = ykey;
	}
	@Column(name="Seller City")
	private String Ycity;
	@Column(name ="Seller State")
	private String Ystate;
    @Column(name="Seller UniqueKey")
	private String Ykey;
}
