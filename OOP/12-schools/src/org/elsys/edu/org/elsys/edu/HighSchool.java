package org.elsys.edu;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HighSchool implements EducationalInstitution {

	private List<Student> students = new ArrayList<>();
	private String name;

	public HighSchool(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean signUpForNextYear(Student student) {
		if(student.getUncompletedSubjects().size() > 1){
			throw new EducationalInstitutionException();
		}
		student.setCourse(student.getCourse() + 1);
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
			this.order(cmp);
		return students.stream().filter(s -> s.getCourse().equals(course)).collect(Collectors.toList());
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

	@Override
	public Map<Integer, List<Student>> groupStudentsByGrade() {
		return null;
	}

	private Comparator<Student> cmp = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			return (int) (o1.getAverageGrade() - o2.getAverageGrade());
		}
	};

}
