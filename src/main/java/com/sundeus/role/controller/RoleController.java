package com.sundeus.role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sundeus.role.exception.ResourceNotFoundException;
import com.sundeus.role.model.Role;
import com.sundeus.role.repository.RoleRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	RoleRepository roleRepository;
	
	//Get All Roles
	@GetMapping("/roles")
	public List<Role> getAllRoles() {
	    return roleRepository.findAll();
	}
	
	//Create a new Role
	@CrossOrigin
	@PostMapping("/roles")
	public Role createRole(@Valid @RequestBody Role role) {
	    return roleRepository.save(role);
	}
	
	//Get a Single Role
	@GetMapping("/roles/{id}")
	public Role getRoleById(@PathVariable(value = "id") Integer roleId) {
	    return roleRepository.findById(roleId)
	            .orElseThrow(() -> new ResourceNotFoundException("Role", "id", roleId));
	}
	
	//Update Role
	@CrossOrigin
	@PutMapping("/roles/{id}")
	public Role updateRole(@PathVariable(value = "id") Integer roleId,
	                                        @Valid @RequestBody Role roleDetails) {

		Role role = roleRepository.findById(roleId)
	            .orElseThrow(() -> new ResourceNotFoundException("Role", "id", roleId));

		role.setName(roleDetails.getName());
		role.setDescription(roleDetails.getDescription());
		role.setStatus(roleDetails.getStatus());	    
	    role.setCreatedBy(roleDetails.getCreatedBy());
	    role.setUpdatedBy(roleDetails.getUpdatedBy());
	    
	    Role updatedRole = roleRepository.save(role);
	    return updatedRole;
	}
	
	// Delete a Role
	@CrossOrigin
	@DeleteMapping("/roles/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable(value = "id") Integer roleId) {
		Role role = roleRepository.findById(roleId)
	            .orElseThrow(() -> new ResourceNotFoundException("Role", "id", roleId));

		roleRepository.delete(role);

	    return ResponseEntity.ok().build();
	}
}