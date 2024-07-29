package com.example.demo;

public class Model1 {
   private String Demail;

public String getDemail() {
	return Demail;
}

public Model1() {
	super();
	// TODO Auto-generated constructor stub
}

public Model1(String demail) {
	super();
	Demail = demail;
}

public void setDemail(String demail) {
	Demail = demail;
}

@Override
public String toString() {
	return "Model1 [Demail=" + Demail + "]";
}
}
