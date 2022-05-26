package com.rediscache.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rediscache.example.model.Student;
import com.rediscache.example.repository.StudentRepository;



@Service
public class StudentService 
{
	@Autowired 
	private StudentRepository repo;
	public Student create(int stdid, String firstname, String lastname, String standard, int marks, int percentage)
	{
		return repo.save(new Student(stdid,firstname,lastname,standard,marks,percentage));
	}
	// to create 
//	public void save(Student student) {
//		repo.save(student);
//	}
	// get all
	public List<Student> listAll()
	{
		return (List<Student>) repo.findAll();
		
	}
	//find by id 
	public Student findBystdid(int stdid)
	{
		return repo.findByStdid(stdid);
	}
	// update 
	public Student update(int stdid, String firstname, String lastname,String standard, int marks, int percentage)
	{
		Student Std=repo.findByStdid(stdid);
		Std.setFirstname(firstname);
		Std.setLastname(lastname);
		Std.setMarks(marks);
		Std.setPercenatage(percentage);
		Std.setStandard(standard);
		return repo.save(Std);
	}
	// delete all
	public void delete()
	{
		 repo.deleteAll();
	}
	//delete by id
	public void deleteById(int stdid)
	{
		repo.deleteById(stdid);
	}
	
}
