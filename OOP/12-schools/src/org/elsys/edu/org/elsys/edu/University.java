package org.elsys.edu;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class University extends HighSchool{

	private List<Student> students = new ArrayList<>();
	private Integer totalSubjects;

	public University(String name, Integer totalSubjects) {
		super(name);
		this.totalSubjects = totalSubjects;
	}

	@Override
	public boolean signUpForNextYear(Student student) {
		if(student.getUncompletedSubjects().stream().filter(Subject::isMandatory).count() < totalSubjects){
			throw new EducationalInstitutionException();
		}
		student.setCourse(student.getCourse() + 1);
		return students.add(student);
	}
}
