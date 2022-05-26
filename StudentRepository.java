package com.rediscache.example.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rediscache.example.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer>
{
	public Student findByStdid(int stdid);
	
}
