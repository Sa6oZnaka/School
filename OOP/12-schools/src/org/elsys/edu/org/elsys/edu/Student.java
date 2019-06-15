package org.elsys.edu;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String name;
	private Integer course;
	private double avgGrade;
	private List<Subject> subjects;

	public Student(String name, Integer course, double avgGrade) {
		this.name = name;
		this.course = course;
		setAverageGrade(avgGrade);
		subjects = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCourse() {
		return course;
	}

	public void setCourse(Integer course) {
		this.course = course;
	}

	public double getAverageGrade() {
		return avgGrade;
	}

	public void setAverageGrade(double averageGrade) {
		if(averageGrade > 6 || averageGrade < 1){
			throw new EducationalInstitutionException();
		}
		this.avgGrade = averageGrade;
	}

	public List<org.elsys.edu.Subject> getUncompletedSubjects() {
		return subjects;
	}

	public boolean addUncompletedSubject(org.elsys.edu.Subject subject) {
		return subjects.add(subject);
	}

	public boolean removeUncompletedSubject(org.elsys.edu.Subject subject) {
		return subjects.remove(subject);
	}
}
