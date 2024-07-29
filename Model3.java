package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SellerUniqueKey")
public class Model3 {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Long id;
	 @Column(name="SellerUniqueKey")
	private String UniqueKey;
	public Model3() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model3(Long id, String uniqueKey) {
		super();
		this.id = id;
		UniqueKey = uniqueKey;
	}
	@Override
	public String toString() {
		return "Model3 [id=" + id + ", UniqueKey=" + UniqueKey + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUniqueKey() {
		return UniqueKey;
	}
	public void setUniqueKey(String uniqueKey) {
		UniqueKey = uniqueKey;
	}
}
