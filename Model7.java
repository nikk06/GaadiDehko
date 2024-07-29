package com.example.demo;

public class Model7 {
  private String Semail;

public Model7() {
	super();
	// TODO Auto-generated constructor stub
}

public Model7(String semail) {
	super();
	Semail = semail;
}

@Override
public String toString() {
	return "Model7 [Semail=" + Semail + "]";
}

public String getSemail() {
	return Semail;
}

public void setSemail(String semail) {
	Semail = semail;
}
}
