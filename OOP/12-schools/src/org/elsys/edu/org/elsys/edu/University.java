package org.elsys.edu;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class University implements EducationalInstitution {

	private List<Student> students;
	private Integer course;
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
		return null;
	}

	@Override
	public List<Student> order(Comparator<Student> comparator) {
		students.sort(comparator);
		return students;
	}

	@Override
	public Collection<Student> filter(Predicate<Student> predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	private Comparator<Student> cmp = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			return (int) (o1.getAverageGrade() - o2.getAverageGrade());
		}
	};

}
