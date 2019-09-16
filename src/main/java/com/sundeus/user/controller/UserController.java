package com.sundeus.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sundeus.user.exception.UserNotFoundException;
import com.sundeus.user.model.User;
import com.sundeus.user.model.UserDetails;
import com.sundeus.user.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
    UserRepository userRepository;
	
	//Get All Users
	@GetMapping("/users")
	public List<User> getAllUsers() {
	    return userRepository.findAll();
	}
	
	//Authenticate User
	@CrossOrigin
	@PostMapping("/authenticateuser")
	public User authenticateUser(@Valid @RequestBody UserDetails user) {
	    User inUser= userRepository.findByEmailAddress(user.getEmailAddress());
	    		
	    if (inUser==null || !(inUser.getPassword().equals(user.getPassword()))) {
	    	throw new UserNotFoundException("User", "EmailAddress", user.getEmailAddress());
	    }
	    return inUser;		
	}
	
	//Create a new User
	@CrossOrigin
	@PostMapping("/users")
	//public User createUser(@Valid @RequestBody User user) {
	//    return userRepository.save(user);
	//}
	
	public User createUser(@Valid @ModelAttribute User user, @RequestParam(required=false)  MultipartFile profilePicture) {
		
		if (profilePicture != null && !profilePicture.isEmpty()) {			
			try 
			{	            
	            byte[] image = profilePicture.getBytes();
	            user.setProfilePic(image);
			}
        	catch (Exception e) {
        		e.printStackTrace();        		
        	}			
		}		
		 return userRepository.save(user);		
	}
	
	//Get a Single User
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value = "id") Integer userId) {
	    return userRepository.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User", "id", userId));
	}
	
	//Update a User
	@CrossOrigin
	@PutMapping("/users/{id}")
	/*public User updateUser(@PathVariable(value = "id") Integer userId,
	                                        @Valid @RequestBody User userDetails, @RequestParam(required=false)  MultipartFile profilePicture) {*/
	public User updateUser(@PathVariable(value = "id") Integer userId,
            @Valid @ModelAttribute User userDetails, @RequestParam(required=false)  MultipartFile profilePicture) {

		User user = userRepository.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User", "id", userId));

		user.setEmployeeId(userDetails.getEmployeeId());
		user.setFirstName(userDetails.getFirstName());
		user.setMiddleName(userDetails.getMiddleName());
		user.setLastName(userDetails.getLastName());
		user.setAddress(userDetails.getAddress());
		user.setCountry(userDetails.getCountry());
		user.setEmailAddress(userDetails.getEmailAddress());
		
		user.setPassword(userDetails.getPassword());
		user.setContactNumber(userDetails.getContactNumber());
		
		if (profilePicture != null && !profilePicture.isEmpty()) {			
			try 
			{	            
	            byte[] image = profilePicture.getBytes();
	            user.setProfilePic(image);
			}
        	catch (Exception e) {
        		e.printStackTrace();        		
        	}			
		}	
		//user.setProfilePic(userDetails.getProfilePic());
		user.setDesignation(userDetails.getDesignation());
		user.setOrganizationLevel(userDetails.getOrganizationLevel());
		user.setDepartment(userDetails.getDepartment());
		user.setDateOfJoining(userDetails.getDateOfJoining());
		user.setReportingManager(userDetails.getReportingManager());		
		user.setCreatedBy(userDetails.getCreatedBy());
		user.setUpdatedBy(userDetails.getUpdatedBy());
	    
	    User updatedUser = userRepository.save(user);
	    return updatedUser;
	}
	
	//Delete a User
	@CrossOrigin
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer userId) {
		User user = userRepository.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User", "id", userId));

		userRepository.delete(user);

	    return ResponseEntity.ok().build();
	}
}