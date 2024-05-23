package com.zak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zak.entity.StaffDtls;
import com.zak.entity.StudentDtls;

public interface UserRepository extends JpaRepository<StaffDtls, Integer>{

	void save(StudentDtls s);
	
	public StaffDtls findByEmail(String email);

	//StaffDtls findByEmail(String email);

}
