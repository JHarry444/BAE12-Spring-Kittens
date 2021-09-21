package com.qa.kittens.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.kittens.data.Owner;
import com.qa.kittens.data.repos.OwnerRepo;

@Service
public class OwnerService {

	private OwnerRepo repo;

	public OwnerService(OwnerRepo repo) {
		super();
		this.repo = repo;
	}

	public Owner createOwner(Owner owner) { // less fancy
		return this.repo.save(owner);
	}

	public List<Owner> getAllOwners() {
		return this.repo.findAll();
	}

	public Owner getOwner(Long id) {
		return this.repo.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public Owner replaceOwner(Long id, Owner newOwner) {
		// pull out existing record
		Owner found = this.repo.findById(id).orElseThrow(EntityNotFoundException::new);
		// modify record
		// save it back to overwrite it
		return this.repo.save(found);
	}

	public String deleteOwner(Long id) {
		this.repo.deleteById(id);

		return "Deleted: " + id;
	}

}
