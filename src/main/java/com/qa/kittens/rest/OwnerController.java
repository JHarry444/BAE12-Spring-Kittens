package com.qa.kittens.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.kittens.data.Owner;
import com.qa.kittens.service.OwnerService;

@RestController // Tells Spring to make an instance of this class
@CrossOrigin
public class OwnerController {

	// dependency
	private OwnerService service;

	// spring injecting it Longo my class
	public OwnerController(OwnerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createOwner") // fancy
	public ResponseEntity<Owner> createOwner(@RequestBody Owner kitten) { // less fancy
		Owner created = this.service.createOwner(kitten);
		return new ResponseEntity<>(created, HttpStatus.CREATED); // body, code
	}

	@GetMapping("/getAllOwners")
	public List<Owner> getAllOwners() {
		return this.service.getAllOwners();
	}

	@GetMapping("/getOwner/{id}")
	public Owner getOwner(@PathVariable Long id) {
		return this.service.getOwner(id);
	}

	@DeleteMapping("/deleteOwner/{id}")
	public ResponseEntity<String> deleteOwner(@PathVariable Long id) {
		String body = this.service.deleteOwner(id);
		return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);
	}

}
