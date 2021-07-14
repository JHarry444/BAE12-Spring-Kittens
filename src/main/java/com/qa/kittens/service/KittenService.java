package com.qa.kittens.service;

import java.util.List;

import com.qa.kittens.data.Kitten;

public interface KittenService {

	public void createKitten(Kitten kitten);

	public List<Kitten> getAllKittens();

	public Kitten getKitten(int id);

	public Kitten replaceKitten(int id, Kitten newKitten);

	public String deleteKitten(int id);

}
