package com.iwec.rest.example.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.iwec.rest.example.model.Student;

@Component
public class StudentRepository {
	private static final Map<Integer, Student> students = new TreeMap<>();

	@PostConstruct
	public void initData() {

		Student student = new Student();
		student.setId(1);
		student.setFirstName("Круме");
		student.setLastName("Крумев");
		students.put(student.getId(), student);

		student = new Student();
		student.setId(2);
		student.setFirstName("Перо");
		student.setLastName("Перов");
		students.put(student.getId(), student);

		student = new Student();
		student.setId(3);
		student.setFirstName("Ѓургина");
		student.setLastName("Ѓурѓевна");
		students.put(student.getId(), student);

		student = new Student();
		student.setId(4);
		student.setFirstName("Paca");
		student.setLastName("Pacevskaja");
		students.put(student.getId(), student);
	}

	public Student findById(Integer id) {
		return (id == null) ? null : students.get(id);
	}

	public List<Student> getAllStudentsOrderedById() {
		List<Student> studentList = new ArrayList<>(students.values());
		return studentList;
	}

	public Integer saveOrUpdate(Student student) {
		Integer key = (student == null || student.getId() == null)
				? students.size() + 1
				: student.getId();
		student.setId(key);
		students.put(key, student);
		return student.getId();
	}

	public boolean delete(Integer id) {
		Student student = students.remove(id);
		return (student != null) ? true : false;
	}
}