package com.chainsys.springmvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.springmvc.pojo.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
	Doctor findById(int id);

	Doctor save(Doctor dr); // used for adding a new doctor and modifying the doctor.

	void deleteById(int id);

	List<Doctor> findAll();

}
