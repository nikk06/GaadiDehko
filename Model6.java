package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="VehicleDetails")
public class Model6 {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	public Model6() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model6(Long id, String oname, String oemail, String okey, String ophno, String ovtyp, String ocomp,
			String ovmodel, String ovyear, String ovno, String ovcol, String ovprice, String odesc, String oimage1,
			String oimage2, String oimage3, String oimage4) {
		super();
		this.id = id;
		Oname = oname;
		Oemail = oemail;
		Okey = okey;
		Ophno = ophno;
		Ovtyp = ovtyp;
		Ocomp = ocomp;
		Ovmodel = ovmodel;
		Ovyear = ovyear;
		Ovno = ovno;
		Ovcol = ovcol;
		Ovprice = ovprice;
		Odesc = odesc;
		Oimage1 = oimage1;
		Oimage2 = oimage2;
		Oimage3 = oimage3;
		Oimage4 = oimage4;
	}
	@Override
	public String toString() {
		return "Model6 [id=" + id + ", Oname=" + Oname + ", Oemail=" + Oemail + ", Okey=" + Okey + ", Ophno=" + Ophno
				+ ", Ovtyp=" + Ovtyp + ", Ocomp=" + Ocomp + ", Ovmodel=" + Ovmodel + ", Ovyear=" + Ovyear + ", Ovno="
				+ Ovno + ", Ovcol=" + Ovcol + ", Ovprice=" + Ovprice + ", Odesc=" + Odesc + ", Oimage1=" + Oimage1
				+ ", Oimage2=" + Oimage2 + ", Oimage3=" + Oimage3 + ", Oimage4=" + Oimage4 + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOname() {
		return Oname;
	}
	public void setOname(String oname) {
		Oname = oname;
	}
	public String getOemail() {
		return Oemail;
	}
	public void setOemail(String oemail) {
		Oemail = oemail;
	}
	public String getOkey() {
		return Okey;
	}
	public void setOkey(String okey) {
		Okey = okey;
	}
	public String getOphno() {
		return Ophno;
	}
	public void setOphno(String ophno) {
		Ophno = ophno;
	}
	public String getOvtyp() {
		return Ovtyp;
	}
	public void setOvtyp(String ovtyp) {
		Ovtyp = ovtyp;
	}
	public String getOcomp() {
		return Ocomp;
	}
	public void setOcomp(String ocomp) {
		Ocomp = ocomp;
	}
	public String getOvmodel() {
		return Ovmodel;
	}
	public void setOvmodel(String ovmodel) {
		Ovmodel = ovmodel;
	}
	public String getOvyear() {
		return Ovyear;
	}
	public void setOvyear(String ovyear) {
		Ovyear = ovyear;
	}
	public String getOvno() {
		return Ovno;
	}
	public void setOvno(String ovno) {
		Ovno = ovno;
	}
	public String getOvcol() {
		return Ovcol;
	}
	public void setOvcol(String ovcol) {
		Ovcol = ovcol;
	}
	public String getOvprice() {
		return Ovprice;
	}
	public void setOvprice(String ovprice) {
		Ovprice = ovprice;
	}
	public String getOdesc() {
		return Odesc;
	}
	public void setOdesc(String odesc) {
		Odesc = odesc;
	}
	public String getOimage1() {
		return Oimage1;
	}
	public void setOimage1(String oimage1) {
		Oimage1 = oimage1;
	}
	public String getOimage2() {
		return Oimage2;
	}
	public void setOimage2(String oimage2) {
		Oimage2 = oimage2;
	}
	public String getOimage3() {
		return Oimage3;
	}
	public void setOimage3(String oimage3) {
		Oimage3 = oimage3;
	}
	public String getOimage4() {
		return Oimage4;
	}
	public void setOimage4(String oimage4) {
		Oimage4 = oimage4;
	}
	@Column(name = "VehicleOwner")
	private String Oname;
	@Column(name="OwnerEmailId")
	private String Oemail;
	@Column(name="OwnerUniqueKey")
	private String Okey;
	@Column(name = "OwnerPhno")
	private String Ophno;
	@Column(name="TypeofVehicle")
	private String Ovtyp;
	@Column(name="VehicleCompany")
	private String Ocomp;
	@Column(name="ModelName")
	private String Ovmodel;
	@Column(name="ModelYear")
	private String Ovyear;
	@Column(name="VehicleNumber")
	private String Ovno;
	@Column(name="VehicleColour")
	private String Ovcol;
	@Column(name="SellingPrice")
	private String Ovprice;
	@Column(name = "Description")
	private String Odesc;
	@Column(name = "VehicleImage")
	private String Oimage1;
	@Column(name="InsuranceCertificate")
	private String Oimage2;
	@Column(name="PollutionCertificate")
	private String Oimage3;
	@Column(name="Roadtaxpaymentreceipt")
	private String Oimage4;
}
