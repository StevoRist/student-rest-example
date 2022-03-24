package com.iwec.rest.example.controller.rest;

import static com.iwec.rest.example.util.Constants.CONSUMES;
import static com.iwec.rest.example.util.Constants.PRODUCES;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iwec.rest.example.model.Student;
import com.iwec.rest.example.repository.StudentRepository;

@RestController

@RequestMapping("v1/rest/students")
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@RequestMapping(method = RequestMethod.GET, produces = PRODUCES)
	@ResponseBody
	public List<Student> getAllStudentsOrderedById() {
		return repository.getAllStudentsOrderedById();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getById(@PathVariable(value = "id") Integer id) {
		Student student = repository.findById(id);
		HttpStatus status = student != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Student>(student, status);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = CONSUMES)
	@ResponseStatus(HttpStatus.CREATED)
	public Integer insert(@RequestBody Student student) {
		return repository.saveOrUpdate(student);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = CONSUMES)
	@ResponseStatus(HttpStatus.OK)
	public Integer update(@RequestBody Student student) {
		// TODO from repository return new created object,
		// and check it as with GET and POST
		return repository.saveOrUpdate(student);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)

	public HttpStatus delete(@PathVariable(value = "id") Integer id) {
		boolean isDeleted = repository.delete(id);
		System.err.println("######" + isDeleted);
		return (isDeleted) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
//		return new ResponseEntity<Student>(student, status);

	}
}