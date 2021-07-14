package com.qa.kittens.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.kittens.data.Kitten;

@Service // FUTURE FUNCTIONALITY - PLZ DO NOT USE
public class KittenServiceDB implements KittenService {

	@Override
	public void createKitten(Kitten kitten) { // less fancy

	}

	@Override
	public List<Kitten> getAllKittens() {
		return null;
	}

	@Override
	public Kitten getKitten(int id) {
		return null;
	}

	@Override
	public Kitten replaceKitten(int id, Kitten newKitten) {
		return null;
	}

	@Override
	public String deleteKitten(int id) {
		return null;
	}

}
