package com.example.demo;

public class Model12 {
  private String fmaill;

public Model12() {
	super();
	// TODO Auto-generated constructor stub
}

public Model12(String fmaill) {
	super();
	this.fmaill = fmaill;
}

@Override
public String toString() {
	return "Model12 [fmaill=" + fmaill + "]";
}

public String getFmaill() {
	return fmaill;
}

public void setFmaill(String fmaill) {
	this.fmaill = fmaill;
}
}
