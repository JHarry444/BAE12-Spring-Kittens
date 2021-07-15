package com.qa.kittens.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.kittens.data.Kitten;

@Service

public class KittenServiceList implements KittenService {
	private List<Kitten> kittens = new ArrayList<>();

	@Override
	public Kitten createKitten(Kitten kitten) { // less fancy
		System.out.println(kitten);
		this.kittens.add(kitten);
		return this.kittens.get(this.kittens.size() - 1);
	}

	@Override
	public List<Kitten> getAllKittens() {
		return this.kittens;
	}

	@Override
	public Kitten getKitten(int id) {
		Kitten found = this.kittens.get(id);
		return found;
	}

	@Override
	public Kitten replaceKitten(int id, Kitten newKitten) {
		return this.kittens.set(id, newKitten); // replace the kitten at index id
	}

	@Override
	public String deleteKitten(int id) {
		this.kittens.remove(id);

		return "Deleted kitten at index: " + id;
	}

	@Override
	public List<Kitten> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
