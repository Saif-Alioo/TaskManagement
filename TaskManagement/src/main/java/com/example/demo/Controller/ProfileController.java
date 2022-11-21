package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import com.example.demo.exception.customException;

//import javax.validation.Valid;

import com.example.demo.model.Profile;
import com.example.demo.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
@RequestMapping("/tata")
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	
	//Add the profile...
	@PostMapping("/upload")
//	public ResponseEntity<String> addNewProfile(@Valid@RequestBody Profile profile)
//	{
//	   service.addProfile(profile);
//	   log.info("New task is added.");
//	   return ResponseEntity.ok("Profile is valid");
//	}
	public String saveProfile(@RequestParam("file") MultipartFile file, @RequestParam String name, @RequestParam int proId) throws IOException {
		service.uploadProfile(proId, name, file);
		log.info("Profile is Uploded...");
		return "Prolife added";
	}
	
	//Get The all the Profiles
	@GetMapping("/profiles")
	public List<Profile> findAllProfiles(){
		log.info("Getting Profile...");
		return service.getProfiles();
	}
	
	//Get the Profile by Using Profile Id.
	@GetMapping("/profiles/{id}")
	public String findProfileById(@PathVariable ("id")int id) throws customException {
		log.info("Getting Profilename by Id...");
	    service.getProfileById(id);
	    return "Profile found";
	}
	
	//Update the Profile name by using profile Id.
    @PutMapping("/update/{id}")
//    public Profile updateProfile(@PathVariable ("id")int id ,int age, @RequestBody Profile profile) throws customException {
//    	log.info("Update Profile by using Id...");
//		return service.updateProfile(id,age,profile);
//		
//	}
    
	public Profile updateProfile(@PathVariable ("id")int id ,MultipartFile file, @RequestBody Profile profile) throws customException {
    	log.info("Update Profile by using Id...");
		return service.updateProfile(id,file,profile);
		
	}
	
    //Delete the Profile using Id.
	@DeleteMapping("/delete/{id}")
	public String deleteProfile(@PathVariable ("id")int id) {
		log.info("Profile is deleted...");
		return service.deleteProfile(id);
	}
	
	
	
	
	


}
