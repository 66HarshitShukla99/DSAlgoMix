package com.generics;

public class Employee {

	int id;
	String name;
	
	public Employee() {
	}
	public Employee(int id, String name) {
		this.id=id;
		this.name=name;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj==null) return false;
		if(obj instanceof Employee) {
			if(this.name.equals(((Employee) obj).name)) return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}
}
