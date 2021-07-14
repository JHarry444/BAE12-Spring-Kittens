package com.qa.kittens.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.kittens.data.Kitten;

@RestController
public class KittenController {

	@GetMapping("/") // MAPS a GET request to "/" to this method
	public String hello() {
		return "Hello, World!";
	}

	@PostMapping("/createKitten") // fancy
	public void createKitten(@RequestBody Kitten kitten) { // less fancy
		// just Java
		System.out.println(kitten);
	}

	@GetMapping("/getKitten")
	public Kitten getKitten() {
		return new Kitten("Tabby", "Maine Coon", 12, 9);
	}

	@DeleteMapping("/deleteKitten/{id}")
	public String deleteKitten(@PathVariable int id) {
		return "Deleted kitten at index: " + id;
	}

}
