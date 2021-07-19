package com.qa.kittens.service;

import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
	public Kitten getKitten(int id) {
		Kitten found = this.repo.findById(id).get();
		return found;
	}

	@Override
	public Kitten replaceKitten(int id, Kitten newKitten) {
		// pull out existing record
		Kitten found = this.repo.findById(id).get();

		System.out.println("FOUND: " + found);

		// modify record
		found.setAge(newKitten.getAge());
		found.setName(newKitten.getName());
		found.setBreed(newKitten.getBreed());
		found.setCuteness(newKitten.getCuteness());

		System.out.println("FOUND AFTER UPDATE: " + found);
		// save it back to overwrite it
		Kitten updated = this.repo.save(found);
		System.out.println("UPDATED: " + updated);
		return updated;
	}

	@Override
	public String deleteKitten(int id) {
		this.repo.deleteById(id);

		if (this.repo.existsById(id)) {
			return "Not deleted: " + id;
		} else {
			return "Deleted: " + id;
		}
	}

}
