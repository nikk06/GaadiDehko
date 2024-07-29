package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Buyerbuyingdetails")
public class Model10 {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	public Model10() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model10(Long id, String bname, String bcity, String bstate, String baddress, String bno, String bmail,
			String bimage1, String bimage2, String bvno, String bnp, String bdesc) {
		super();
		this.id = id;
		Bname = bname;
		Bcity = bcity;
		Bstate = bstate;
		Baddress = baddress;
		Bno = bno;
		Bmail = bmail;
		Bimage1 = bimage1;
		Bimage2 = bimage2;
		Bvno = bvno;
		Bnp = bnp;
		Bdesc = bdesc;
	}
	@Override
	public String toString() {
		return "Model10 [id=" + id + ", Bname=" + Bname + ", Bcity=" + Bcity + ", Bstate=" + Bstate + ", Baddress="
				+ Baddress + ", Bno=" + Bno + ", Bmail=" + Bmail + ", Bimage1=" + Bimage1 + ", Bimage2=" + Bimage2
				+ ", Bvno=" + Bvno + ", Bnp=" + Bnp + ", Bdesc=" + Bdesc + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getBcity() {
		return Bcity;
	}
	public void setBcity(String bcity) {
		Bcity = bcity;
	}
	public String getBstate() {
		return Bstate;
	}
	public void setBstate(String bstate) {
		Bstate = bstate;
	}
	public String getBaddress() {
		return Baddress;
	}
	public void setBaddress(String baddress) {
		Baddress = baddress;
	}
	public String getBno() {
		return Bno;
	}
	public void setBno(String bno) {
		Bno = bno;
	}
	public String getBmail() {
		return Bmail;
	}
	public void setBmail(String bmail) {
		Bmail = bmail;
	}
	public String getBimage1() {
		return Bimage1;
	}
	public void setBimage1(String bimage1) {
		Bimage1 = bimage1;
	}
	public String getBimage2() {
		return Bimage2;
	}
	public void setBimage2(String bimage2) {
		Bimage2 = bimage2;
	}
	public String getBvno() {
		return Bvno;
	}
	public void setBvno(String bvno) {
		Bvno = bvno;
	}
	public String getBnp() {
		return Bnp;
	}
	public void setBnp(String bnp) {
		Bnp = bnp;
	}
	public String getBdesc() {
		return Bdesc;
	}
	public void setBdesc(String bdesc) {
		Bdesc = bdesc;
	}
	@Column(name="Buyer Name")
	private String Bname;
	@Column(name="Buyer City")
	private String Bcity;
	@Column(name="Buyer State")
	private String Bstate;
	@Column(name="Buyer Full Address")
	private String Baddress;
	@Column(name="Buyer Phno")
	private String Bno;
	@Column(name="Buyer Email")
	private String Bmail;
	@Column(name="Buyer Image")
	private String Bimage1;
	@Column(name="Aadhar No")
	private String Bimage2;
	@Column(name="Requested Vehicle No")
	private String Bvno;
	@Column(name="Negotiation Price")
	private String Bnp;
	@Column(name="Little Desciption for seller")
	private String Bdesc;
}
