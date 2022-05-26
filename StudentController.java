package com.rediscache.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rediscache.example.model.Student;
import com.rediscache.example.service.StudentService;

@RestController
public class StudentController 
{

	@Autowired
	private StudentService service;
	
	@RequestMapping("/create")
	@CachePut(value="student", key="#stdid")
		public String create(@RequestParam int stdid,@RequestParam String firstname,@RequestParam String lastname,@RequestParam String standard,@RequestParam int marks,@RequestParam int percentage)
		{ 
			Student Std=service.create(stdid, firstname, lastname, standard, marks, percentage);		
			return Std.toString();
		}
	@RequestMapping("/get")
	@ResponseBody
	@Cacheable(value="student",key="#stdid")
	public Student getStudent(@RequestParam int stdid)
	{
		System.out.println("getting record!!!!");
		return service.findBystdid(stdid);
	}
	@RequestMapping("listAll")
	@Cacheable(value="student")
	public List<Student> listAll()
	{
		System.out.println("getting records");
		return service.listAll();
	}
	@RequestMapping("/update")
	@CachePut(value="student",key="#stdid")
	public String update(@RequestParam int stdid, @RequestParam String firstname, @RequestParam String lastname,@RequestParam String standard, @RequestParam int marks, @RequestParam int percentage)
	{
		 Student Std=service.update(stdid, firstname, lastname, standard, marks, percentage);
				return Std.toString();
	}	
	@RequestMapping("/delete")
	@CacheEvict(value="student",key="#stdid")
	public String delete(@RequestParam int stdid)
	{
		service.deleteById(stdid);
		return "Successfully deleted"+stdid;
	}
	@RequestMapping("/deleteAll")
	@CacheEvict(value="student",allEntries=true)
	public String deleteAll()
	{
		service.delete();
		return "all records deleted successfully";
	}
	@RequestMapping("/clearcache")
	@CacheEvict(value="student",allEntries=true)
	public String clearcache()
	{
		return "all cache cleared";
	}
}


