package com.example.demo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SellerusernameAndpasssword")
public class Model2 {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
     public Model2(Long id) {
		super();
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "Seller Email")
    private String Demaill;
    public Model2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model2(String demaill, String dpasssowrd) {
		super();
		Demaill = demaill;
		Dpasssowrd = dpasssowrd;
	}
	@Override
	public String toString() {
		return "Model2 [id=" + id + ", Demaill=" + Demaill + ", Dpasssowrd=" + Dpasssowrd + "]";
	}
	public String getDemaill() {
		return Demaill;
	}
	public void setDemaill(String demaill) {
		Demaill = demaill;
	}
	public String getDpasssowrd() {
		return Dpasssowrd;
	}
	public void setDpasssowrd(String dpasssowrd) {
		Dpasssowrd = dpasssowrd;
	}
	@Column(name = "Seller Password")
    private String Dpasssowrd;
}
