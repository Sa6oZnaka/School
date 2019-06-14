package org.elsys.edu;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class University implements EducationalInstitution {

	private List<Student> students = new ArrayList<>();
	private String name;
	private Integer totalSubjects;

	public University(String name, Integer totalSubjects) {
		this.name = name;
		this.totalSubjects = totalSubjects;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean signUpForNextYear(Student student) {
		if(student.getUncompletedSubjects().size() < totalSubjects){
			throw new EducationalInstitutionException();
		}
		return students.add(student);
	}

	@Override
	public boolean signOut(Student student) {
		return students.remove(student);
	}

	@Override
	public Collection<Student> getStudents() {
		return students;
	}

	@Override
	public List<Student> getStudentsInCourse(int course, boolean orderedByAverageGrade) {
		if(orderedByAverageGrade)
			order(cmp);
		return students.stream().filter(s -> s.getCourse().equals(course)).collect(Collectors.toList());
	}

	@Override
	public Map<Integer, List<Student>> groupStudentsByGrade() {
		order(cmp);
		return null;
	}

	@Override
	public List<Student> order(Comparator<Student> comparator) {
		students.sort(comparator);
		return students;
	}

	@Override
	public Collection<Student> filter(Predicate<Student> predicate) {
		return students.stream().filter(predicate).collect(Collectors.toList());
	}

	private Comparator<Student> cmp = (o1, o2) -> (int) (o1.getAverageGrade() - o2.getAverageGrade());

}
