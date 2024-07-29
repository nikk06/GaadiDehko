package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BuyerusernameAndpasssword")
public class Model8 {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	@Column(name = "Buyer Email")
	private String Bemaill;
	public Model8() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model8(Long id, String bemaill, String bpasssowrd) {
		super();
		this.id = id;
		Bemaill = bemaill;
		Bpasssowrd = bpasssowrd;
	}
	@Override
	public String toString() {
		return "Model8 [id=" + id + ", Bemaill=" + Bemaill + ", Bpasssowrd=" + Bpasssowrd + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBemaill() {
		return Bemaill;
	}
	public void setBemaill(String bemaill) {
		Bemaill = bemaill;
	}
	public String getBpasssowrd() {
		return Bpasssowrd;
	}
	public void setBpasssowrd(String bpasssowrd) {
		Bpasssowrd = bpasssowrd;
	}
	@Column(name = "Buyer Password")
	private String Bpasssowrd;
}
