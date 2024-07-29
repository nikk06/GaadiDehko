package com.example.demo;

public class Model11 {
  private String fmail;

public Model11() {
	super();
	// TODO Auto-generated constructor stub
}

public Model11(String fmail) {
	super();
	this.fmail = fmail;
}

@Override
public String toString() {
	return "Model11 [fmail=" + fmail + "]";
}

public String getFmail() {
	return fmail;
}

public void setFmail(String fmail) {
	this.fmail = fmail;
}
}
