package com.qa.kittens.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.kittens.data.Kitten;
import com.qa.kittens.data.repos.KittenRepo;

@Service
@Primary // tells Spring just to make this one
public class KittenServiceDB implements KittenService {

	private KittenRepo repo;

	public KittenServiceDB(KittenRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Kitten createKitten(Kitten kitten) { // less fancy
		return this.repo.save(kitten);
	}

	@Override
	public List<Kitten> getAllKittens() {
		return this.repo.findAll();
	}

	@Override
	public List<Kitten> getByName(String name) {
		return this.repo.findByNameIgnoreCase(name);
	}

	@Override
	public Kitten getKitten(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public Kitten replaceKitten(int id, Kitten newKitten) {
		// pull out existing record
		Kitten found = this.repo.findById(id).get();

		// modify record
		found.setAge(newKitten.getAge());
		found.setName(newKitten.getName());

		// save it back to overwrite it
		Kitten updated = this.repo.save(found);

		return updated;
	}

	@Override
	public String deleteKitten(int id) {
		this.repo.deleteById(id);

		return "Deleted: " + id;
	}

}
