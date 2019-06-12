package org.elsys.edu;

public class Subject {

	private String name;
	private boolean mandatory;

	public Subject(String name, boolean mandatory) {
		this.name = name;
		this.mandatory = mandatory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	
}
