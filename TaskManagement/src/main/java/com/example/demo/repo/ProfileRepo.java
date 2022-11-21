package com.example.demo.repo;

import com.example.demo.model.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProfileRepo extends JpaRepository<Profile,Integer>{

	
	
}
