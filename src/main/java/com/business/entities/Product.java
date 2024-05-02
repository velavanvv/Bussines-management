package com.business.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String pname;
	private double pprice;
	public String getPimage() {
		return pimage;
	}
	public Product(String pname, double pprice, String pdescription) {
		this.pname = pname;
		this.pprice = pprice;
		this.pdescription = pdescription;
	}
	public Product() {
	}
	public Product(int pid, String pname, double pprice, String pimage, String pdescription) {
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pimage = pimage;
		this.pdescription = pdescription;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	private String pimage;
	private String pdescription;

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pimage=" + pimage
				+ ", pdescription=" + pdescription + "]";
	}
	


}
