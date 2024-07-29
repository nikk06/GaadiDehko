package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BuyerUniqueKey")
public class Model9 {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	@Column(name="Buyer Unique Key")
	private String UniqueKeyy;
	public Model9() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model9(Long id, String uniqueKeyy) {
		super();
		this.id = id;
		UniqueKeyy = uniqueKeyy;
	}
	@Override
	public String toString() {
		return "Model9 [id=" + id + ", UniqueKeyy=" + UniqueKeyy + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUniqueKeyy() {
		return UniqueKeyy;
	}
	public void setUniqueKeyy(String uniqueKeyy) {
		UniqueKeyy = uniqueKeyy;
	}
	
}
