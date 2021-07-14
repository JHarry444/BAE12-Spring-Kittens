package com.qa.kittens.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.kittens.data.Kitten;

@RestController
public class KittenController {

	private List<Kitten> kittens = new ArrayList<>();

	@GetMapping("/") // MAPS a GET request to "/" to this method
	public String hello() {
		return "Hello, World!";
	}

	@PostMapping("/createKitten") // fancy
	public void createKitten(@RequestBody Kitten kitten) { // less fancy
		// just Java
		System.out.println(kitten);
		this.kittens.add(kitten);
	}

	@GetMapping("/getAllKittens")
	public List<Kitten> getAllKittens() {
		return this.kittens;
	}

	@GetMapping("/getKitten/{id}")
	public Kitten getKitten(@PathVariable int id) {
		Kitten found = this.kittens.get(id);
		return found;
	}

	@PutMapping("/replaceKitten/{id}")
	public Kitten replaceKitten(@PathVariable int id, @RequestBody Kitten newKitten) {
		return this.kittens.set(id, newKitten); // replace the kitten at index id
	}

	@DeleteMapping("/deleteKitten/{id}")
	public String deleteKitten(@PathVariable int id) {
		this.kittens.remove(id);

		return "Deleted kitten at index: " + id;
	}

}
