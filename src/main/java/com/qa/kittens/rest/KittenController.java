package com.qa.kittens.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.kittens.data.Kitten;
import com.qa.kittens.service.KittenService;

@RestController // Tells Spring to make an instance of this class
public class KittenController {

	// dependency
	private KittenService service;

	// spring injecting it into my class
	public KittenController(KittenService service) {
		super();
		this.service = service;
	}

	@GetMapping("/") // MAPS a GET request to "/" to this method
	public String hello() {
		return "Hello, World!";
	}

	@PostMapping("/createKitten") // fancy
	public void createKitten(@RequestBody Kitten kitten) { // less fancy
		this.service.createKitten(kitten);
	}

	@GetMapping("/getAllKittens")
	public List<Kitten> getAllKittens() {
		return this.service.getAllKittens();
	}

	@GetMapping("/getKitten/{id}")
	public Kitten getKitten(@PathVariable int id) {
		return this.service.getKitten(id);
	}

	@PutMapping("/replaceKitten/{id}")
	public Kitten replaceKitten(@PathVariable int id, @RequestBody Kitten newKitten) {
		return this.service.replaceKitten(id, newKitten);
	}

	@DeleteMapping("/deleteKitten/{id}")
	public String deleteKitten(@PathVariable int id) {
		return this.service.deleteKitten(id);
	}

}
